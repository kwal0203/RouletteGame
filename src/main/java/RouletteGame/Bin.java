package RouletteGame;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a 'bin' of the roulette wheel. A bin is an
 * area that the ball can come to rest on the wheel after spinning.
 *
 * Author: Kane Walter
 */
public class Bin {
    private Set<Outcome> bin;

    public Bin() {
        this.bin = new HashSet<>();
    }

    /**
     * Add an outcome to this bin.
     *
     * @param outcome Possible outcome if ball lands in this bin while
     *                playing.
     */
    public void addToBin(Outcome outcome) {
        bin.add(outcome);
    }

    /**
     * Test set membership for provided argument.
     *
     * @param outcome Outcome we wish to test set membership.
     * @return true if outcome is in the set.
     */
    public boolean inSet(Outcome outcome) {
        return bin.contains(outcome);
    }

    /**
     * Standard toString() displays all Outcomes in the bin.
     *
     * @return List of Outcomes in this bin.
     */
    @Override
    public String toString() {
        String s = "";

        for (Outcome o : bin)
            s = s + o.toString() + "\n";

        return s;
    }
}
