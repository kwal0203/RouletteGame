package RouletteGame;

/**
 * Base class for all player objects.
 */
public abstract class Player {
    private int stake;
    private int roundsToGo;
    public Table table;
    private int redCount = 7;

    /**
     * Constructor for Player objects.
     *
     * @param stake      Amount of money player currently has.
     * @param roundsToGo How many more rounds the player will play.
     * @param table      The table the player is playing on.
     */
    public Player(int stake, int roundsToGo, Table table) {
        this.stake = stake;
        this.roundsToGo = roundsToGo;
        this.table = table;
    }

    /**
     * Place a bet on the table.
     */
    public abstract void placeBet();

    /**
     * Decide whether player will keep playing.
     *
     * @return True/false depending on whether player chooses to keep
     *         playing.
     */
    public boolean playing() {
        return (stake > 0) && (roundsToGo > 0);
    }

    /**
     * Decrease rounds to go by one after each bet.
     */
    public void decrementRounds() {
        roundsToGo -= 1;
    }

    /**
     * Get number of rounds the player wants to play.
     *
     * @return Number of rounds left to play.
     */
    public int getRoundsToGo() {
        return roundsToGo;
    }

    /**
     * Add winnings (including original stake) to players money.
     *
     * @param bet Bet object corresponding to bet player won.
     */
    public void win(Bet bet) {
//        System.out.println("Won: " + (bet.winAmount() - bet.getAmountBet()));
        stake += bet.winAmount() - bet.getAmountBet();
    }

    /**
     * Remove amount of money player bet on this outcome from money
     *
     * @param bet Bet object for bet we lost.
     */
    public void lose(Bet bet) {
//        System.out.println("Lost: " + bet.getAmountBet());
        stake -= bet.getAmountBet();
    }

    /**
     * Return amount of money player has left.
     *
     * @return Amount of money player has left.
     */
    public int getMoney() {
        return stake;
    }

    /**
     * Set players stake.
     *
     * @param stake Amount of money we wish to stake the player.
     */
    public void setStake(int stake) {
        this.stake = stake;
    }

    /**
     * Set how many rounds the player will play.
     *
     * @param roundsToGo Number of rounds player will play.
     */
    public void setRoundsToGo(int roundsToGo) {
        this.roundsToGo = roundsToGo;
    }

    /**
     * Get the set of winning outcomes from the wheel.
     *
     * @param winBin The winning bin after a spin.
     */
    public void winners(Bin winBin) {
        Outcome red = table.getOutcome("Red");
        if (winBin.inSet(red))
            --redCount;
        else
            redCount = 7;
    }

    /**
     * Get number of consecutive reds the player has seen.
     *
     * @return Number of consecutive reds that have been seen.
     */
    public int getRedCount() {
        return redCount;
    }
}

