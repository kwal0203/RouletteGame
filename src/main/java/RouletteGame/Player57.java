package RouletteGame;

/**
 * Player strategy that bets on Black outcomes only.
 */
public class Player57 extends Player {
    private Outcome black;
    private int money;

    /**
     * Constructor for 'Black-bet' strategy players.
     *
     * @param stake      Current amount of money held by player.
     * @param roundsToGo How many more rounds the player will play.
     * @param table      The table the player is playing at.
     */
    public Player57(int stake, int roundsToGo, Table table) {
        super(stake, roundsToGo, table);
    }

    /**
     * Place a black bet on the table.
     */
    @Override
    public void placeBet() {
        Outcome black = table.getOutcome("Black");
        Bet bet = new Bet(10, black);
        table.placeBet(bet);
    }
}

