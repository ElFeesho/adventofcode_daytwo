import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WrappingPaperCalculatorTest {

    private class WrapperPaperCalculator {
        private final int totalArea;

        public WrapperPaperCalculator(int width, int length, int height) {
            this.totalArea = 2 * (width * length) + 2 * (width * height) + 2 * (length * height);
        }

        public int totalArea() {
            return totalArea;
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



}
