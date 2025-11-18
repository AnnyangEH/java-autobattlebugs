package auttobattlebugs;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BuffAbilityTest {
    @Test
    void onFaint_buff_test() {
        Team a = new Team();
        Team b = new Team();

        Bug ant = new Bug("개미", 1, 0, Trigger.ON_FAINT, new BuffAbility(1, 1));
        Bug ally = new Bug("아군", 2, 2);

        a.add(ant);
        a.add(ally);

        Battle battle = new Battle(a, b);

        battle.triggerFaint(ant, a, b);

        assertThat(ally.getDamage()).isEqualTo(3);  // +1
        assertThat(ally.getHealth()).isEqualTo(3);  // +1
    }

    @Test
    void onFaint_summon_test() {
        Team a = new Team();
        Team b = new Team();

        Bug spider = new Bug("거미", 1, 0, Trigger.ON_FAINT, new SummonAbility(BugType.TOKEN));

        a.add(spider);

        Battle battle = new Battle(a, b);

        battle.triggerFaint(spider, a, b);

        assertThat(a.getFrontAlive().getName()).isEqualTo("토큰");
    }

    @Test
    void onFaint_order_from_front_test() {
        List<String> log = new ArrayList<>();

        Ability logAbility = (self, ally, enemy) -> log.add(self.getName());

        Team a = new Team();
        a.add(new Bug("A1", 1, 0, Trigger.ON_FAINT, logAbility));
        a.add(new Bug("A2", 1, 0, Trigger.ON_FAINT, logAbility));
        a.add(new Bug("A3", 1, 0, Trigger.ON_FAINT, logAbility));

        Battle battle = new Battle(a, new Team());

        // 세 마리 모두 dead라고 가정하고 한꺼번에 faint 처리
        battle.triggerAllFaint(a);

        assertThat(log).containsExactly("A1", "A2", "A3");
    }
}
