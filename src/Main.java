public class Main {
    public static void main(String... args)
    {
        CalculatorGenerator<WrapperPaperCalculator> generator = new CalculatorGenerator<>(Main.class.getResourceAsStream("input.txt"), (width, length, height) -> new WrapperPaperCalculator(width, length, height));
        final int[] output = new int[1];
        generator.forEachWrappingPaperCalculator(calculator -> output[0] += calculator.slackRequired() + calculator.totalArea());
        System.out.println("Total wrapping paper required: "+output[0]);

        CalculatorGenerator<RibbonCalculator> ribbonGenerator = new CalculatorGenerator<>(Main.class.getResourceAsStream("input.txt"), (width, length, height) -> new RibbonCalculator(width, length, height));
        final int[] ribbonOutput = new int[1];
        ribbonGenerator.forEachWrappingPaperCalculator(calculator -> ribbonOutput[0] += calculator.lengthForBow() + calculator.lengthForWrapping());
        System.out.println("Total ribbon required: "+ribbonOutput[0]);
    }
}
