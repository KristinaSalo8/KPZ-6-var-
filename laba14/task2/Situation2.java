package task2_mediator;

public class Situation2 {

    private static void inventories(Trader a, Trader b) {
        System.out.println("  " + a);
        System.out.println("  " + b);
    }

    public static void run() {
        // 1. Успішний обмін: меч ⇄ 300 золота
        System.out.println("--- Сценарій 1: обидва підтверджують ---");
        Trader a1 = new Trader("Ярослав", 100, "Меч");
        Trader b1 = new Trader("Олена", 500, "Щит");
        new TradeSession(a1, b1);
        inventories(a1, b1);
        a1.propose(0, "Меч");
        b1.propose(300);
        a1.confirm();
        b1.confirm();
        inventories(a1, b1);

        // 2. Зміна пропозиції після підтвердження Б скидає підтвердження
        System.out.println("\n--- Сценарій 2: зміна пропозиції після підтвердження ---");
        Trader a2 = new Trader("Ярослав", 100, "Меч", "Зілля");
        Trader b2 = new Trader("Олена", 500, "Щит");
        new TradeSession(a2, b2);
        a2.propose(0, "Меч");
        b2.propose(300);
        b2.confirm();
        a2.propose(0, "Меч", "Зілля"); // координатор скидає підтвердження Олени
        inventories(a2, b2);

        // 3. Один із гравців відключається до підтвердження
        System.out.println("\n--- Сценарій 3: відключення до підтвердження ---");
        Trader a3 = new Trader("Ярослав", 100, "Меч");
        Trader b3 = new Trader("Олена", 500, "Щит");
        new TradeSession(a3, b3);
        a3.propose(0, "Меч");
        b3.propose(300);
        a3.confirm();
        b3.disconnect();
        a3.confirm(); // уже скасовано - ігнорується
        inventories(a3, b3);
    }
}
