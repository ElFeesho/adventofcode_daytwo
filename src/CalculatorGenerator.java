import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class CalculatorGenerator<CalculatorType> {
    private final CalculatorFactory<CalculatorType> calculatorFactory;

    public interface CalculatorFactory<CalculatorType>
    {
        CalculatorType createCalculator(int width, int length, int height);
    }

    public interface GeneratorFunctor<CalculatorType>
    {
        void generatedWrappingPaperCalculator(CalculatorType calculator);
    }
    private final BufferedReader bufferedReader;

    public CalculatorGenerator(InputStream stream, CalculatorFactory<CalculatorType> calculatorFactory) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(stream));
        this.calculatorFactory = calculatorFactory;
    }

    public void forEachWrappingPaperCalculator(GeneratorFunctor<CalculatorType> generatorFunctor)
    {
        try {
            while(bufferedReader.ready()) {
                String input = bufferedReader.readLine();
                String[] dimensions = input.split("x");
                int width = Integer.parseInt(dimensions[0]);
                int length = Integer.parseInt(dimensions[1]);
                int height = Integer.parseInt(dimensions[2]);
                generatorFunctor.generatedWrappingPaperCalculator(calculatorFactory.createCalculator(width, length, height));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
