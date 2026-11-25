package task3;

import java.util.List;
import java.util.Random;

/** ConcreteStrategy: випадково */
public class RandomStrategy implements LootStrategy {
    private final Random random = new Random(7);

    @Override public String getName() { return "Випадково"; }

    @Override public Member choose(Item item, List<Member> members) {
        return members.get(random.nextInt(members.size()));
    }
}
