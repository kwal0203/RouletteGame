package RouletteGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

/**
 * This class represents the wheel of a Roulette table.
 *
 * Author: Kane Walter
 */
public class Wheel {
    private Vector<Bin> bins;
    private Map<String, Outcome> outcomes;
    private Random rng;

    /**
     * Constructor for the Wheel object of the game.
     */
    public Wheel() {
        this.bins = new Vector<>(38);
        this.outcomes = new HashMap<>();

        for (int i = 0; i < 38; ++i)
            this.bins.add(new Bin());

        this.rng = new Random();
    }

    /**
     * Constructor for the Wheel object of the game.
     *
     * @param rng Random number generator.
     */
    public Wheel(Random rng) {
        this.bins = new Vector<>(38);
        this.outcomes = new HashMap<>();

        for (int i = 0; i < 38; ++i)
            this.bins.add(new Bin());

        this.rng = rng;
    }

    /**
     * Adds an outcome to a bin.
     *
     * @param outcome A possible outcome if this bin is landed in
     *                while playing.
     * @param bin     Bin the given outcome should be added to.
     */
    public void addOutcome(Outcome outcome, int bin) {
        Bin tmpBin = bins.get(bin);
        tmpBin.addToBin(outcome);
        if (!outcomes.containsKey(outcome.getName()))
            outcomes.put(outcome.getName(), outcome);
    }

    /**
     * Chooses the next bin the ball falls into randomly i.e.
     * this simulates a spinning of the wheel.
     *
     * @return The required Bin.
     */
    public Bin next() {
        return bins.get(rng.nextInt(38));
    }

    /**
     * Get an outcome object from the wheel.
     *
     * @param name Name of required outcome.
     * @return Outcome object with provided name.
     */
    public Outcome getOutcome(String name) {
        return outcomes.get(name);
    }

    /**
     * Return the whole collection of outcomes for testing.
     */
    public Map<String, Outcome> getOutcomes() {
        return outcomes;
    }

    /**
     * For testing
     */
    public void addBin(int idx, Bin bin) {
        bins.add(idx, bin);
    }

    /**
     * Standard toString() displays what is inside each bin of the
     * wheel.
     *
     * @return String of what is in each bin of the wheel.
     */
    @Override
    public String toString() {
        String s = "";

        for (int i = 0; i < 38; ++i)
            s += "Bin" + (i+1) + " = [" + bins.get(i).toString() + "]\n";

        return s;
    }
}
