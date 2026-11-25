package task3;

import java.util.List;

public class Situation3 {
    public static void run() {
        Party party = new Party("Загін «Північні вовки»", List.of(
                new Member("Ярослав", "Воїн", 500),
                new Member("Олена", "Маг", 300),
                new Member("Тарас", "Лучник", 150),
                new Member("Мирон", "Цілитель", 50)), new RoundRobinStrategy());

        // 1 По черзі
        party.distribute(List.of(
                new Item("Меч", "Воїн"), new Item("Посох", "Маг"), new Item("Лук", "Лучник"),
                new Item("Амулет", "Цілитель"), new Item("Щит", "Воїн")));
        party.printLoot();

        // 2 Лідер змінює правило на "за внеском у бій"
        System.out.println();
        party.setStrategy(new ContributionStrategy());
        party.distribute(List.of(
                new Item("Шолом", "Воїн"), new Item("Мантія", "Маг"), new Item("Кинджал", "Лучник"),
                new Item("Жезл", "Цілитель"), new Item("Кільце", "Маг")));
        party.printLoot();

        // 3 Нове правило "за потребою класу"
        System.out.println();
        party.setStrategy(new ClassNeedStrategy());
        party.distribute(List.of(
                new Item("Сокира", "Воїн"), new Item("Книга заклять", "Маг"), new Item("Стріли", "Лучник"),
                new Item("Цілюща трава", "Цілитель"), new Item("Кіраса", "Воїн")));
        party.printLoot();
    }
}
