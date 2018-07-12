package RouletteGame;

/**
 * Two wins observed state of the 1326 strategy.
 */
public class Player1326TwoWins extends Player1326State {

    Player1326TwoWins(Player1326 player) {
        super(player);
    }

    /**
     * Create next state after winning three bets.
     *
     * @return Three win state object.
     */
    @Override
    public Player1326State nextWon() {
        return new Player1326ThreeWins(super.getPlayer());
    }

    /**
     * Create an appropriate bet for this state.
     *
     * @return Bet corresponding to this state.
     */
    @Override
    public Bet currentBet() {
        int amount = super.getAmount();
        return new Bet(2 * amount, super.getOutcome());
    }
}

