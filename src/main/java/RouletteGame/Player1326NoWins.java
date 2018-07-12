package RouletteGame;

/**
 * No wins observed state of the 1326 strategy.
 */
public class Player1326NoWins extends Player1326State {

    /**
     * Constructor for Player1326NoWins state objects.
     *
     * @param player 1326 Player in this state.
     */
    Player1326NoWins(Player1326 player) {
        super(player);
    }

    /**
     * Create next state after winning a bet.
     *
     * @return One win state object.
     */
    @Override
    public Player1326State nextWon() {
        return new Player1326OneWin(super.getPlayer());
    }

    /**
     * Create an appropriate bet for this state.
     *
     * @return Bet corresponding to this state.
     */
    @Override
    public Bet currentBet() {
        int amount = super.getAmount();
        return new Bet(amount, super.getOutcome());
    }
}
