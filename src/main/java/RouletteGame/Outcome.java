package RouletteGame;

import java.util.Objects;

/**
 * This class represents an outcome of a spin of the roulette wheel.
 *
 * Author: Kane Walter
 */
public class Outcome {
    private final String name;
    private final int odds;

    /**
     * Constructor for Outcome objects.
     *
     * @param name Name of the outcome
     * @param odds The multiplying factor (against your bet) that you
     *             win.
     */
    public Outcome(String name, int odds) {
        this.name = name;
        this.odds = odds;
    }

    /**
     * Get the amount won if we won the bet.
     *
     * @param  betAmount Amount of money we wagered on the winning
     *                  outcome.
     * @return Amount of money we won.
     */
    public int winAmount(int betAmount) {
        return betAmount * odds;
    }

    /**
     * Standard equals (based on name of outcome).
     *
     * @param  o Object to compare name of this outcome to.
     * @return true/false depending on whether the names are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outcome outcome = (Outcome) o;
        return Objects.equals(name, outcome.name);
    }

    /**
     * Standard hashcode based on name of this outcome.
     *
     * @return Hashcode of the name of the outcome.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Standard toString override displaying name and odds of this
     * outcome.
     *
     * @return Name and odds of this outcome.
     */
    @Override
    public String toString() {
        return "Outcome name: " + name + ", Odds: " + odds;
    }

    /**
     * Get name of outcome.
     *
     * @return Name of outcome.
     */
    public String getName() {
        return name;
    }
}
