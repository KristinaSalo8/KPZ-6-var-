package task2;

public class Situation2 {
    public static void run() {
        // Загальний чат: усі чотири фільтри
        ChatChannel general = new ChatChannel("Загальний",
                new MuteFilter(), new SpamFilter(), new ProfanityFilter(), new LinkFilter());
        // Клановий чат: без фільтра лексики
        ChatChannel clan = new ChatChannel("Клановий",
                new MuteFilter(), new SpamFilter(), new LinkFilter());

        Player olena = new Player("Олена", false);
        Player taras = new Player("Тарас", false);
        Player muted = new Player("Заглушений", true);

        general.send(olena, "Привіт усім, хто йде на ярмарок?");
        general.send(taras, "КУПИ ЗОЛОТО дешево, акція!");
        general.send(olena, "Ти ідіот, не стій на дорозі");
        general.send(taras, "Дивись http://free-gold.xyz");

        System.out.println();
        clan.send(olena, "Ти ідіот, не стій на дорозі");

        System.out.println();
        general.send(muted, "Чому мене не чути?");
    }
}
