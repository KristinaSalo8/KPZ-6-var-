package task2;

/** ConcreteHandler: заглушений гравець. */
public class MuteFilter extends ChatFilter {
    public MuteFilter() { super("Фільтр заглушення"); }

    @Override protected String check(Message m) {
        return m.getSender().isMuted() ? "гравець заглушений" : null;
    }
}
