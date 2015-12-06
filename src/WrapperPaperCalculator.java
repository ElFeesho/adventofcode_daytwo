class WrapperPaperCalculator {
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
