public class Main {
    public static void main(String... args)
    {
        CalculatorGenerator<WrapperPaperCalculator> generator = new CalculatorGenerator<>(Main.class.getResourceAsStream("input.txt"), (width, length, height) -> new WrapperPaperCalculator(width, length, height));
        final int[] output = new int[1];
        generator.forEachWrappingPaperCalculator(calculator -> output[0] += calculator.slackRequired() + calculator.totalArea());
        System.out.println("Total required: "+output[0]);
    }
}
