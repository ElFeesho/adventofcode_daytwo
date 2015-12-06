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
        private final int lengthForWrapping;
        private final int lengthForBow;

        public RibbonCalculator(int width, int length, int height) {
            this.lengthForWrapping = (2 * width) + (2 * length) + (2*height) - (Math.max(width, Math.max(length, height)) * 2);
            this.lengthForBow = width * length * height;
        }

        int lengthForWrapping()
        {
            return lengthForWrapping;
        }

        int lengthForBow()
        {
            return lengthForBow;
        }
    }
}
