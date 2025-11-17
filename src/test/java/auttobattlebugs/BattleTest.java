package auttobattlebugs;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BattleTest {
    @Test
    void get_first_attacker_test() {
        Team a = new Team();
        Team b = new Team();

        a.add(new Bug("a", 3, 3));
        b.add(new Bug("b", 2, 1));

        Battle battle = new Battle(a, b);

        assertThat(battle.getFirstAttacker()).isEqualTo(a);
    }

    @Test
    void bugs_fight_test() {
        Team a = new Team();
        Team b = new Team();

        Bug aBug = new Bug("A", 4, 3); // 공격 4
        Bug bBug = new Bug("B", 2, 5); // 공격 2

        a.add(aBug);
        b.add(bBug);

        Battle battle = new Battle(a, b);

        battle.exchangeOnce();

        assertThat(aBug.getHealth()).isEqualTo(3 - 2); // 상대 공격력만큼 감소
        assertThat(bBug.getHealth()).isEqualTo(5 - 4);
    }

    @Test
    void a_bug_death_test() {
        Team a = new Team();
        Team b = new Team();

        Bug aBug = new Bug("A", 4, 1);
        Bug bBug = new Bug("B", 2, 5);

        a.add(aBug);
        b.add(bBug);

        Battle battle = new Battle(a, b);

        battle.exchangeOnce(); // A는 사망해야 함

        assertThat(aBug.isAlive()).isFalse();
    }

    @Test
    void next_bug_test() {
        Team a = new Team();
        Team b = new Team();

        Bug a1 = new Bug("A1", 4, 1); // 죽을 벌레
        Bug a2 = new Bug("A2", 3, 3); // 다음 벌레
        Bug bBug = new Bug("B", 2, 5);

        a.add(a1);
        a.add(a2);
        b.add(bBug);

        Battle battle = new Battle(a, b);

        battle.exchangeOnce();
        battle.postExchange();

        assertThat(a.getFrontAlive()).isEqualTo(a2);
    }
}
