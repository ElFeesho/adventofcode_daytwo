import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WrappingPaperCalculatorTest {

    private class WrapperPaperCalculator {
        private final int totalArea;
        private final int slackRequired;

        public WrapperPaperCalculator(int width, int length, int height) {
            this.totalArea = 2 * (width * length) + 2 * (width * height) + 2 * (length * height);
            this.slackRequired = Math.min(width * length, Math.min(width*height, length*height));
        }

        public int totalArea() {
            return totalArea;
        }

        public int slackRequired() {
            return slackRequired;
        }
    }

    @Test
    public void wrapperPaperCalculatorCanCalculateTheAreaOfWrappingPaperRequired()
    {
        int width = 2;
        int height = 3;
        int length = 4;
        WrapperPaperCalculator calculator = new WrapperPaperCalculator(width, length, height);
        assertThat(calculator.totalArea(), is(52));
    }

    @Test
    public void wrapperPaperCalculatorCanCalculateTheAreaOfSlackPaperRequired()
    {
        int width = 2;
        int height = 3;
        int length = 4;
        WrapperPaperCalculator calculator = new WrapperPaperCalculator(width, length, height);
        assertThat(calculator.slackRequired(), is(6));
    }

    @Test
    public void secondTestCaseWorks()
    {
        int width = 1;
        int height = 1;
        int length = 10;
        WrapperPaperCalculator calculator = new WrapperPaperCalculator(width, length, height);
        assertThat(calculator.totalArea(), is(42));
        assertThat(calculator.slackRequired(), is(1));
    }



}
