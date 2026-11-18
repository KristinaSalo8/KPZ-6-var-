package task2;

import common.Logger;

/** ConcreteHandler: нецензурна лексика (не блокує, а змінює текст). */
public class ProfanityFilter extends ChatFilter {
    private static final String[] BAD_WORDS = {"ідіот", "дурень"};

    public ProfanityFilter() { super("Фільтр лексики"); }

    @Override protected String check(Message m) {
        String text = m.getText();
        for (String w : BAD_WORDS) {
            text = text.replaceAll("(?iu)" + w, "*".repeat(w.length()));
        }
        if (!text.equals(m.getText())) {
            Logger.log(getName(), "Нецензурне слово замінено зірочками: «" + text + "»");
            m.setText(text);
        }
        return null;
    }
}
