package task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** ConcreteStrategy: за внеском у бій */
public class ContributionStrategy implements LootStrategy {
    private final Map<Member, Integer> given = new HashMap<>();

    @Override public String getName() { return "За внеском у бій"; }

    @Override public Member choose(Item item, List<Member> members) {
        Member best = members.get(0);
        for (Member m : members) {
            if (score(m) > score(best)) best = m;
        }
        given.merge(best, 1, Integer::sum);
        return best;
    }

    private double score(Member m) { return (double) m.getContribution() / (given.getOrDefault(m, 0) + 1); }
}
