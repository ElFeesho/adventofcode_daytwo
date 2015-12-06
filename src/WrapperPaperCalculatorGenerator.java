import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class WrapperPaperCalculatorGenerator {
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
            while(bufferedReader.ready()) {
                String input = bufferedReader.readLine();
                String[] dimensions = input.split("x");
                int width = Integer.parseInt(dimensions[0]);
                int length = Integer.parseInt(dimensions[1]);
                int height = Integer.parseInt(dimensions[2]);
                generatorFunctor.generatedWrappingPaperCalculator(new WrapperPaperCalculator(width, length, height));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
