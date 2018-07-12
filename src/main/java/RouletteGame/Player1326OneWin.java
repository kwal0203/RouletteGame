package RouletteGame;

/**
 * One win observed state of 1326 strategy.
 */
public class Player1326OneWin extends Player1326State {

    Player1326OneWin(Player1326 player) {
        super(player);
    }

    /**
     * Create next state after winning two bets.
     *
     * @return Two win state object.
     */
    @Override
    public Player1326State nextWon() {
        return new Player1326TwoWins(super.getPlayer());
    }

    /**
     * Create an appropriate bet for this state.
     *
     * @return Bet corresponding to this state.
     */
    @Override
    public Bet currentBet() {
        int amount = super.getAmount();
        return new Bet(3 * amount, super.getOutcome());
    }
}

