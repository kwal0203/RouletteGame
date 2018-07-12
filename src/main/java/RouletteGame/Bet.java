package RouletteGame;

/**
 * This class represents a bet.
 *
 * Author: Kane Walter
 */
public class Bet {
    private int amountBet;
    private Outcome outcome;

    /**
     * Constructor for Bet objects.
     *
     * @param amountBet Amount of many bet on a given outcome.
     * @param outcome   The outcome we are betting money on.
     */
    public Bet(int amountBet, Outcome outcome) {
        this.amountBet = amountBet;
        this.outcome = outcome;
    }

    /**
     * Get the amount of money returned if we win the bet. The amount
     * returned is the amount bet plus the amount won.
     *
     * @return Amount of money returned after winning a bet.
     */
    public int winAmount() {
        return outcome.winAmount(amountBet) + amountBet;
    }

    /**
     * Get amount of money lost after losing a bet. This is the amount
     * we placed on the outcome to win.
     *
     * @return Amount of money lost.
     */
    public int loseAmount() {
        return amountBet;
    }

    /**
     * Standard toString() displaying information about how much
     * money was placed on this outcome.
     *
     * @return Information displaying how much money was bet.
     */
    @Override
    public String toString() {
        return "Bet amount: " + amountBet + ", " + outcome.toString();
    }

    /**
     * Get amount we bet on this outcome.
     *
     * @return Amount of money bet on this outcome.
     */
    public int getAmountBet() {
        return amountBet;
    }

    /**
     * Get outcome of this bet.
     *
     * @return Outcome associated with this bet.
     */
    public Outcome getOutcome() {
        return outcome;
    }
}
