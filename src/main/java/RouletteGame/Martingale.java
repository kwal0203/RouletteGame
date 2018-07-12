package RouletteGame;

/**
 * Class for Martingale strategy.
 */
public class Martingale extends Player {
    private int lossCount = 0;
    private double betMultiple = 1;

    /**
     * Constructor for Martingale strategy players.
     *
     * @param stake      Current amount of money held by player.
     * @param roundsToGo How many more rounds the player will play.
     * @param table      The table the player is playing at.
     */
    public Martingale(int stake, int roundsToGo, Table table) {
        super(stake, roundsToGo, table);
    }

    /**
     * Place a black bet on the table.
     */
    @Override
    public void placeBet() {
        Outcome black = table.getOutcome("Black");
        int amount = Math.min((int) betMultiple * 10, table.getLimit());
        if (amount > super.getMoney())
            amount = super.getMoney();
        if (super.getRoundsToGo() > 0 && amount > 0) {
//            System.out.println("Betting amount: " + amount);
            Bet bet = new Bet(amount, black);
            table.placeBet(bet);
            super.decrementRounds();
        }
    }

    /**
     * Add winnings (including original stake) to players money.
     *
     * @param bet Bet object corresponding to bet player won.
     */
    @Override
    public void win(Bet bet) {
        super.win(bet);
        lossCount = 0;
        betMultiple = 1;
    }

    /**
     * Remove amount of money player bet on this outcome from money
     *
     * @param bet Bet object for bet we lost.
     */
    @Override
    public void lose(Bet bet) {
        super.lose(bet);
        ++lossCount;
        betMultiple = Math.pow(2, lossCount);
    }
}

