import org.junit.Test;

import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
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

    @Test
    public void wrappingPaperCalculatorGenerator_canCreateWrappingPaperCalculatorsFromAStream()
    {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("single_input.txt");
        assertThat(resourceAsStream, is(notNullValue()));

        WrapperPaperCalculatorGenerator generator = new WrapperPaperCalculatorGenerator(resourceAsStream);
        final int[] capturedTotalArea = new int[1];
        final int[] capturedSlackArea = new int[1];
        generator.forEachWrappingPaperCalculator((wrappingPaperCalculator)->{
            capturedTotalArea[0] = wrappingPaperCalculator.totalArea();
            capturedSlackArea[0] = wrappingPaperCalculator.slackRequired();
        });

        assertThat(capturedTotalArea[0], is(52));
        assertThat(capturedSlackArea[0], is(6));
    }


    private static class WrapperPaperCalculatorGenerator {
        public interface GeneratorFunctor
        {
            void generatedWrappingPaperCalculator(WrapperPaperCalculator calculator);
        }
        private final InputStream inputStream;

        public WrapperPaperCalculatorGenerator(InputStream stream) {
            this.inputStream = stream;
        }

        public void forEachWrappingPaperCalculator(GeneratorFunctor generatorFunctor)
        {

        }
    }
}
