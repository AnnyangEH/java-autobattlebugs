package auttobattlebugs;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TeamTest {

    @Test
    void add_bugs_test() {
        Team team = new Team();
        Bug ant = new Bug("개미", 2, 2);

        team.add(ant);

        assertThat(team.size()).isEqualTo(1);
        assertThat(team.getAll()).containsExactly(ant);
    }
}
