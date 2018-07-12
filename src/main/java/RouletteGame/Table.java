package RouletteGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class represents the roulette table.
 */
public class Table {
    private int limit;
    private int minimum;
    private List<Bet> bets;
    private Wheel wheel;

    /**
     * Constructor for Table objects.
     *
     * @param limit   Maximum bet possible for this table.
     * @param minimum Minimum bet needed to bet on this table.
     * @param wheel   Wheel of this table.
     */
    public Table(int limit, int minimum, Wheel wheel) {
        this.limit = limit;
        this.minimum = minimum;
        this.wheel = wheel;
        this.bets = new ArrayList<>();
    }

    /**
     * Place a bet on the Table.
     *
     * @param bet Bet to place on this table.
     */
    public void placeBet(Bet bet) {
        /*
        if (!isValid(bet)) {
            System.out.println("Bet not valid");
            return;
        }
        */
        bets.add(bet);
    }

    /**
     * Get bet iterator.
     *
     * @return Iterator to scan bets.
     */
    public Iterator<Bet> iterator() {
        return bets.iterator();
    }

    /**
     * Display information about all current bets on table.
     *
     * @return String of bets on table.
     */
    @Override
    public String toString() {
        return "Table{" +
                "bets=" + bets +
                '}';
    }

    /**
     * Check if the amount bet by the player meets the table minimum
     * and maximum limits.
     *
     * @param bet Bet the player placed.
     * @return true if player but in a bet greater than table minimum
     *         and less than table maximum.
     */
    public boolean isValid(Bet bet) {
        int betAmount = 0;
        for (Bet b : bets)
            betAmount += b.getAmountBet();
        return betAmount <= limit && betAmount >= minimum;
    }

    /**
     * Remove bet from table once it's no longer needed.
     */
    public void removeBets() {
        bets.clear();
    }

    /**
     * Get an outcome object from the wheel.
     *
     * @param name Name of required outcome.
     * @return Outcome object with provided name.
     */
    public Outcome getOutcome(String name) {
        return wheel.getOutcome(name);
    }

    /**
     * Return Outcome map from the wheel.
     *
     * @return Map of outcomes keyed by their name.
     */
    public Map<String, Outcome> getOutcomesFromTable() {
        return wheel.getOutcomes();
    }

    /**
     * Get upper table limit.
     *
     * @return Upper limit for bets on this table.
     */
    public int getLimit() {
        return limit;
    }
}
