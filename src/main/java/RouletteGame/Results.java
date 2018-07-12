package RouletteGame;

public class Results {
    private final String name;
    private final double maxMean;
    private final double meanStdev;
    private final double durMean;
    private final double durStdev;

    /**
     * Constructor for result objects.
     *
     * @param name          Player type.
     * @param stackMean     Maximum mean stack achieved by this type of player.
     * @param stackStdev    Standard deviation of the mean.
     * @param durationMean  Maximum duration of play achieved.
     * @param durationStdev Standard deviation of durationf of play.
     */
    Results(String name, double stackMean, double stackStdev,
            double durationMean, double durationStdev) {
        this.name = name;
        this.maxMean = stackMean;
        this.meanStdev = stackStdev;
        this.durMean = durationMean;
        this.durStdev = durationStdev;
    }

    public String getName() {
        return name;
    }

    public double getMaxMean() {
        return maxMean;
    }

    public double getMeanStdev() {
        return meanStdev;
    }

    public double getDurMean() {
        return durMean;
    }

    public double getDurStdev() {
        return durStdev;
    }
}

