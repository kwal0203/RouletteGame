package RouletteGame;

import java.util.Iterator;

/**
 * This class handles the running of the simulation.
 */
public class Game {
    private Wheel wheel;
    private Table table;

    /**
     * Constructor for Game objects.
     *
     * @param wheel Game wheel.
     * @param table Game table.
     */
    public Game(Wheel wheel, Table table) {
        this.wheel = wheel;
        this.table = table;
    }

    /**
     * Plays one cycle of roulette:
     *  1. Player bets
     *  2. Wheel is spun
     *  3. Check if player bet has won
     *  4. Update player money accordingly.
     *
     * @param player Player who is playing at the moment.
     */
    public void cycle(Player player) {
        player.placeBet();
        Bin bin = wheel.next();
        player.winners(bin);
        Iterator<Bet> it = table.iterator();

        while (it.hasNext()) {
            Bet bet = it.next();
            if (bin.inSet(bet.getOutcome()))
                player.win(bet);
            else
                player.lose(bet);
        }
        table.removeBets();
    }
}
