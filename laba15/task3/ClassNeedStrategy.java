package task3;

import java.util.List;

/** ConcreteStrategy (нова): за потребою класу - предмет отримує той, для чийого класу він призначений */
public class ClassNeedStrategy implements LootStrategy {
    @Override public String getName() { return "За потребою класу"; }

    @Override public Member choose(Item item, List<Member> members) {
        Member best = null;
        for (Member m : members) {
            if (m.getPlayerClass().equals(item.getForClass())
                    && (best == null || m.getLootCount() < best.getLootCount())) {
                best = m;
            }
        }
        if (best != null) return best;
        // нікому з потрібного класу - віддаємо тому, хто має найменше
        best = members.get(0);
        for (Member m : members) {
            if (m.getLootCount() < best.getLootCount()) best = m;
        }
        return best;
    }
}
