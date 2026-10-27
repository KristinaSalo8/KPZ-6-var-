import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
//DIP(Dependency Inversion Principle) - модулі високого рівня не залежать від низького рівня
public class Task5_DIP {
    record Document(String documentId, String title, String authorUsername, String approverUsername) { }
    interface DocumentSearchIndex { void indexDocument(String docId, String title, String status); }
    interface ApproverValidator { boolean validateUserSignature(String username); }
    interface ChatNotifier { void postChannelMessage(String channel, String message); }
    // Production реалізація
    static class ElasticsearchDocumentIndex implements DocumentSearchIndex {
        public void indexDocument(String docId, String title, String status) {
            System.out.println("[Elasticsearch] Документ " + docId + " ('" + title + "') -> статус '" + status + "'.");
        }
    }
    static class ActiveDirectoryValidator implements ApproverValidator {
        public boolean validateUserSignature(String username) {
            System.out.println("[Active Directory] Користувача '" + username + "' підтверджено у групі 'Managers'.");
            return true;
        }
    }
    static class SlackNotifier implements ChatNotifier {
        public void postChannelMessage(String channel, String message) {
            System.out.println("[Slack] #" + channel + ": " + message);
        }
    }
        // Тестова реалізація
    static class InMemoryIndex implements DocumentSearchIndex {
        final List<String> records = new ArrayList<>();
        public void indexDocument(String docId, String title, String status) { records.add(docId + ":" + status); }
    }
    static class StubValidator implements ApproverValidator {
        private final boolean result;
        StubValidator(boolean result) { this.result = result; }
        public boolean validateUserSignature(String username) { return result; }
    }
    static class MockNotifier implements ChatNotifier {
        final List<String> messages = new ArrayList<>();
        public void postChannelMessage(String channel, String message) { messages.add(channel + ": " + message); }
    }
    static class DocumentApprovalWorkflow {
        private final DocumentSearchIndex searchIndex;
        private final ApproverValidator validator;
        private final ChatNotifier notifier;
        //Конструктор перевірки
        DocumentApprovalWorkflow(DocumentSearchIndex searchIndex, ApproverValidator validator, ChatNotifier notifier) {
            this.searchIndex = Objects.requireNonNull(searchIndex);
            this.validator = Objects.requireNonNull(validator);
            this.notifier = Objects.requireNonNull(notifier);
        }
        void approveDocument(Document doc) {
            if (doc == null || doc.documentId() == null || doc.documentId().isEmpty())
                throw new IllegalArgumentException("Некоректний документ для узгодження.");
            if (!validator.validateUserSignature(doc.approverUsername()))
                throw new IllegalStateException("Підписант не має повноважень для підпису.");
            searchIndex.indexDocument(doc.documentId(), doc.title(), "APPROVED");
            notifier.postChannelMessage("approvals", "Документ '" + doc.title() + "' (ID: " + doc.documentId()+ ") підписано користувачем " + doc.approverUsername() + ".");
        }
    }
    public static void main(String[] args) {
        Document doc = new Document("DOC-42", "Договір поставки", "ivanenko", "petrenko");
        new DocumentApprovalWorkflow(new ElasticsearchDocumentIndex(), new ActiveDirectoryValidator(), new SlackNotifier())
                .approveDocument(doc);
        InMemoryIndex index = new InMemoryIndex();
        MockNotifier notifier = new MockNotifier();
        new DocumentApprovalWorkflow(index, new StubValidator(true), notifier).approveDocument(doc);
        System.out.println("[TEST] index=" + index.records + ", chat=" + notifier.messages);
        try {
            new DocumentApprovalWorkflow(index, new StubValidator(false), notifier).approveDocument(doc);
        } catch (IllegalStateException e) {
            System.out.println("[TEST] Очікувана помилка: " + e.getMessage());
        }
    }
}