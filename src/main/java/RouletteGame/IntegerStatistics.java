package RouletteGame;

import java.util.List;

/**
 * Calculates the statistics for a run of the simulator.
 */
public class IntegerStatistics {
    /**
     * Calculate the mean of the given list.
     *
     * @param list List of Integer values
     * @return Return mean of the given list.
     */
    public double mean(List<Integer> list) {
        double sum = 0;
        for (Integer i : list)
            sum += i;
        return Math.round(sum / list.size());
    }

    /**
     * Calculate the standard deviation of the given list.
     *
     * @param list List of Integer values.
     * @return Standard deviation of the given list.
     */
    public double stdev(List<Integer> list) {
        double listMean = mean(list);

        double sd = 0;
        for (Integer i : list) {
            double diff = i - listMean;
            sd += diff * diff;
        }
        double variance = sd / (list.size() - 1);

        return Math.round(Math.sqrt(variance));
    }
}

