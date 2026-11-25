package task3;

import java.util.List;

/** Strategy: правило розподілу здобичі */
public interface LootStrategy {
    String getName();
    Member choose(Item item, List<Member> members);
}
