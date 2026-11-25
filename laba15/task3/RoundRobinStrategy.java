package task3;

import java.util.List;

/** ConcreteStrategy: по черзі */
public class RoundRobinStrategy implements LootStrategy {
    private int next;

    @Override public String getName() { return "По черзі"; }

    @Override public Member choose(Item item, List<Member> members) {
        return members.get(next++ % members.size());
    }
}
