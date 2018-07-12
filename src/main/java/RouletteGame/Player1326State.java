package RouletteGame;

/**
 * Base class (of the states) for the 1326 strategy.
 */
public abstract class Player1326State {
    private Player1326 player;

    /**
     * Constructor for Player1326State objects.
     *
     * @param player The player that is currently in this state.
     */
    Player1326State(Player1326 player) {
        this.player = player;
    }

    /**
     * Creates new state after winning a bet.
     *
     * @return Next state in the betting sequence.
     */
    public abstract Player1326State nextWon();

    /**
     * Gets the appropriate bet for the current state.
     *
     * @return Appropriate bet for current state.
     */
    public abstract Bet currentBet();

    /**
     * Get the base bet for 1326 players.
     *
     * @return Base bet for 1326 players.
     */
    public int getAmount() {
        return player.getAmount();
    }

    /**
     * Get the outcome the 1326 player is betting on.
     *
     * @return Outcome the 1326 player is betting on.
     */
    public Outcome getOutcome() {
        return player.getOutcome();
    }

    /**
     * When a bet is lost we always reset to the NoWins state. This
     * method creates an object representing this state and returns it.
     *
     * @return No win state object.
     */
    Player1326State nextLoss() {
        return new Player1326NoWins(player);
    }

    /**
     * Get the 1326 player object that is playing.
     *
     * @return 1326 Player object.
     */
    public Player1326 getPlayer() {
        return player;
    }
}

