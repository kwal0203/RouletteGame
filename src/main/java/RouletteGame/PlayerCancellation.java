package RouletteGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for 'cancellation' strategy.
 */
public class PlayerCancellation extends Player {
    private List<Integer> list;
    private Outcome outcome;

    /**
     * Constructor for Cancellation player objects.
     *
     * @param stake      Amount of money player currently has.
     * @param roundsToGo How many more rounds the player will play.
     * @param table      The table the player is playing on.
     */
    public PlayerCancellation(int stake, int roundsToGo, Table table) {
        super(stake, roundsToGo, table);
        this.outcome = table.getOutcome("Black");
        this.list = new ArrayList<>(6);
        resetSequence();
    }

    /**
     * Place a bet on the table.
     */
    @Override
    public void placeBet() {
        int amount = list.get(0) + list.get(list.size() - 1);

        if (amount > super.getMoney())
            amount = super.getMoney();
        if (amount > table.getLimit())
            amount = table.getLimit();

        Bet bet = new Bet(amount, outcome);
        table.placeBet(bet);
        super.decrementRounds();
    }

    /**
     * Add winnings (including original stake) to players money and
     * cancel previous sequence bets.
     *
     * @param bet Bet object corresponding to bet player won.
     */
    @Override
    public void win(Bet bet) {
        super.win(bet);

        if (list.size() == 1) {
            list.remove(0);
        } else {
            list.remove(0);
            list.remove(list.size() - 1);
        }

        checkList();
    }

    /**
     * Remove amount of money player bet on this outcome from money
     * and add losing bet to sequence.
     *
     * @param bet Bet object for bet we lost.
     */
    @Override
    public void lose(Bet bet) {
        super.lose(bet);
        Integer sum = list.get(0) + list.get(list.size() - 1);
        list.add(sum);

        checkList();
    }

    /**
     * Check if the sequence is finished.
     */
    public void checkList() {
        if (list.size() == 0) {
            super.setRoundsToGo(0);
            resetSequence();
        }
    }

    /**
     * Initialize bet sequence.
     */
    public void resetSequence() {
        list.clear();
        for (int i = 1; i <= 6; ++i)
            list.add(i * 10);
    }
}

