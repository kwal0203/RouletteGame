package RouletteGame;

/**
 * Three wins observed state of the 1326 strategy.
 */
public class Player1326ThreeWins extends Player1326State {

    Player1326ThreeWins(Player1326 player) {
        super(player);
    }

    /**
     * Create next state after winning four bets.
     *
     * @return No win state object.
     */
    @Override
    public Player1326State nextWon() {
        return new Player1326NoWins(super.getPlayer());
    }

    /**
     * Create an appropriate bet for this state.
     *
     * @return Bet corresponding to this state.
     */
    @Override
    public Bet currentBet() {
        int amount = super.getAmount();
        return new Bet(6 * amount, super.getOutcome());
    }
}

