package RouletteGame;

/**
 * Class for 1326 strategy.
 */
public class Player1326 extends Player {
    private Outcome outcome;
    private Player1326State state;
    private int amount;

    /**
     * Constructor for Player1326 objects.
     *
     * @param stake      Amount of money player currently has.
     * @param roundsToGo How many more rounds the player will play.
     * @param table      The table the player is playing on.
     */
    public Player1326(int stake, int roundsToGo, Table table) {
        super(stake, roundsToGo, table);
        this.outcome = table.getOutcome("Black");
        this.amount = 10;
        this.state = new Player1326NoWins(this);
    }

    /**
     * Place a bet on the table.
     */
    @Override
    public void placeBet() {
        Bet bet = state.currentBet();

        if (bet.getAmountBet() > super.getMoney())
            amount = super.getMoney();
        if (bet.getAmountBet() > table.getLimit())
            amount = table.getLimit();

//        if (super.getRoundsToGo() > 0 && amount > 0) {
        table.placeBet(bet);
        super.decrementRounds();
//        }
    }

    /**
     * Get the base bet amount for 1326 players.
     *
     * @return Base bet for 1326 players.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Get outcome the 1326 player is betting on.
     *
     * @return Outcome 1326 player is betting on.
     */
    public Outcome getOutcome() {
        return outcome;
    }

    /**
     * Add winnings (including original stake) to players money.
     *
     * @param bet Bet object corresponding to bet player won.
     */
    @Override
    public void win(Bet bet) {
        super.win(bet);
        state = state.nextWon();
    }

    /**
     * Remove amount of money player bet on this outcome from money
     *
     * @param bet Bet object for bet we lost.
     */
    @Override
    public void lose(Bet bet) {
        super.lose(bet);
        state = state.nextLoss();
    }
}

