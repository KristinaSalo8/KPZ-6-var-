package task2;

/** ConcreteHandler: підозрілі посилання. */
public class LinkFilter extends ChatFilter {
    private static final String TRUSTED = "siver.game";

    public LinkFilter() { super("Фільтр посилань"); }

    @Override protected String check(Message m) {
        String text = m.getText().toLowerCase();
        boolean hasLink = text.contains("http") || text.contains("www.");
        return hasLink && !text.contains(TRUSTED) ? "підозріле посилання" : null;
    }
}
