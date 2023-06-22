package jumptojava.sample05_q1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpgradeCalculatorTest {
    UpgradeCalculator upgradeCalculator;

    @BeforeEach
    void beforeEach(){
        //given
        upgradeCalculator = new UpgradeCalculator();
    }

    @DisplayName("숫자를 더할 수 있다.")
    @Test
    void addNumber() {
        //when
        upgradeCalculator.add(10);
        //then
        assertThat(upgradeCalculator.getValue()).isEqualTo(10);
    }

    @DisplayName("숫자를 뺄 수 있다.")
    @Test
    void minusNumber() {
        //when
        upgradeCalculator.minus(5);
        //then
        assertThat(upgradeCalculator.getValue()).isEqualTo(-5);
    }
}
