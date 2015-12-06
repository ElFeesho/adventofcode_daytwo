public class Main {
    public static void main(String... args)
    {
        WrapperPaperCalculatorGenerator generator = new WrapperPaperCalculatorGenerator(Main.class.getResourceAsStream("input.txt"));
        final int[] output = new int[1];
        generator.forEachWrappingPaperCalculator(calculator -> output[0] += calculator.slackRequired() + calculator.totalArea());
        System.out.println("Total required: "+output[0]);
    }
}
