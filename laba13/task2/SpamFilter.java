package task2;

/** ConcreteHandler: спам. */
public class SpamFilter extends ChatFilter {
    private static final String[] SPAM = {"купи золото", "безкоштовно", "акція"};

    public SpamFilter() { super("Фільтр спаму"); }

    @Override protected String check(Message m) {
        String text = m.getText().toLowerCase();
        for (String s : SPAM) {
            if (text.contains(s)) return "спам («" + s + "»)";
        }
        return null;
    }
}
