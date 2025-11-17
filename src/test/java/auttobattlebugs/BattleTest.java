package auttobattlebugs;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BattleTest {
    @Test
    void 스탯_합이_높은_팀이_선공이다() {
        Team a = new Team();
        Team b = new Team();

        a.add(new Bug("a", 3, 3));
        b.add(new Bug("b", 2, 1));

        Battle battle = new Battle(a, b);

        assertThat(battle.getFirstAttacker()).isEqualTo(a);
    }
}
