import org.junit.Test;

import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class WrappingPaperCalculatorTest {

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

    @Test
    public void wrappingPaperCalculatorGenerator_canCreateWrappingPaperCalculatorsFromAStream_andCanBeUsedToSumTotalArea()
    {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("two_inputs.txt");
        assertThat(resourceAsStream, is(notNullValue()));

        WrapperPaperCalculatorGenerator generator = new WrapperPaperCalculatorGenerator(resourceAsStream);
        final int[] capturedTotalAreaAndSlack = new int[1];

        generator.forEachWrappingPaperCalculator((wrappingPaperCalculator)->{
            capturedTotalAreaAndSlack[0] += wrappingPaperCalculator.totalArea() + wrappingPaperCalculator.slackRequired();
        });

        assertThat(capturedTotalAreaAndSlack[0], is(58+43));
    }


}
