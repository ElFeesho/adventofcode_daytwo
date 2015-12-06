import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class WrappingPaperCalculatorTest {

    private static class WrapperPaperCalculator {
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
        private final BufferedReader bufferedReader;

        public WrapperPaperCalculatorGenerator(InputStream stream) {
            this.bufferedReader = new BufferedReader(new InputStreamReader(stream));
        }

        public void forEachWrappingPaperCalculator(GeneratorFunctor generatorFunctor)
        {
            try {
                String input = bufferedReader.readLine();
                String[] dimensions = input.split("x");
                int width = Integer.parseInt(dimensions[0]);
                int length = Integer.parseInt(dimensions[1]);
                int height = Integer.parseInt(dimensions[2]);
                generatorFunctor.generatedWrappingPaperCalculator(new WrapperPaperCalculator(width, length, height));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
