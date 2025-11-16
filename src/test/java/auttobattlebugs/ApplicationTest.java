package auttobattlebugs;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void custom_delimiter_test() {
    }

    @Test
    void exception_test() {
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
