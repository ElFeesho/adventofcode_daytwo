import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RibbonCalculatorTest {

    @Test
    public void ribbonLengthCanBeCalculatedForExampleInput()
    {
        int width = 2;
        int length = 3;
        int height = 4;
        RibbonCalculator calculator = new RibbonCalculator(width, length, height);
        assertThat(calculator.lengthForWrapping(), is(10));
        assertThat(calculator.lengthForBow(), is(24));
    }

    public static class RibbonCalculator {
        public RibbonCalculator(int width, int length, int height) {

        }

        int lengthForWrapping()
        {
            return 0;
        }

        int lengthForBow()
        {
            return 0;
        }
    }
}
