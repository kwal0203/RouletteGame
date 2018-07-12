package RouletteGame;

/**
 * Class for fibonacci strategy.
 */
public class PlayerFibonacci extends Player {
    private int recent = 10;
    private int previous = 0;
    private Outcome outcome;

    /**
     * Constructor for FibonacciPlayer objects.
     *
     * @param stake      Amount of money player currently has.
     * @param roundsToGo How many more rounds the player will play.
     * @param table      The table the player is playing on.
     */
    public PlayerFibonacci(int stake, int roundsToGo, Table table) {
        super(stake, roundsToGo, table);
        this.outcome = table.getOutcome("Black");
    }

    /**
     * Place a bet on the table.
     */
    @Override
    public void placeBet() {
        int amount = recent + previous;

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
     * update the recent and previous bet fields.
     *
     * @param bet Bet object corresponding to bet player won.
     */
    @Override
    public void win(Bet bet) {
        super.win(bet);
        recent = 1;
        previous = 0;
    }

    /**
     * Remove amount of money player bet on this outcome from money
     * and update the recent and previous bet fields.
     *
     * @param bet Bet object for bet we lost.
     */
    @Override
    public void lose(Bet bet) {
        super.lose(bet);
        int next = recent + previous;
        previous = recent;
        recent = next;
    }
}

