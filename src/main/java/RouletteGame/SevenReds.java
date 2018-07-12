package RouletteGame;

/**
 * Strategy where player uses Martingale strategy but only bets
 * after seeing seven 'Red' outcomes in a row.
 */
public class SevenReds extends Martingale {

    /**
     * Constructor for SevenRed player objects.
     *
     * @param stake      Current stake of this player.
     * @param roundsToGo How many rounds the player will play.
     * @param table      The table player is playing at.
     */
    public SevenReds(int stake, int roundsToGo, Table table) {
        super(stake, roundsToGo, table);
    }

    /**
     * Place a black bet on the table.
     */
    @Override
    public void placeBet() {
        if (super.getRedCount() == 0)
            super.placeBet();
        super.decrementRounds();
    }

    /**
     * Get the set of winning outcomes from the wheel.
     *
     * @param winBin The winning bin after a spin.
     */
    @Override
    public void winners(Bin winBin) {
        super.winners(winBin);
    }
}

