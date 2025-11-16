package auttobattlebugs;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TeamTest {

    @Test
    void add_bug_test() {
        Team team = new Team();
        Bug ant = new Bug("개미", 2, 2);

        team.add(ant);

        assertThat(team.size()).isEqualTo(1);
        assertThat(team.getAll()).containsExactly(ant);
    }

    @Test
    void get_front_alive_bug_test() {
        Team team = new Team();
        Bug a = new Bug("a", 3, 1);
        Bug b = new Bug("b", 2, 2);

        team.add(a);
        team.add(b);

        a.takeDamage(3);

        Bug front = team.getFrontAlive();

        assertThat(front).isEqualTo(b);
    }

    @Test
    void buff_all_test() {
        Team team = new Team();
        Bug a = new Bug("a", 1, 1);
        Bug b = new Bug("b", 2, 2);
        team.add(a);
        team.add(b);

        team.buffAll(1, 2);

        assertThat(a.getDamage()).isEqualTo(2);
        assertThat(a.getHealth()).isEqualTo(3);
        assertThat(b.getDamage()).isEqualTo(3);
        assertThat(b.getHealth()).isEqualTo(4);
    }

    @Test
    void add_to_front_test() {
        Team team = new Team();
        Bug a = new Bug("a", 1, 1);
        Bug b = new Bug("b", 2, 2);
        Bug summoned = new Bug("token", 1, 1);

        team.add(a);
        team.add(b);

        team.addToFront(summoned);

        assertThat(team.getAll()).containsExactly(summoned, a, b);
    }
}
