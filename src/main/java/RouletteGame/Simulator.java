package RouletteGame;

import java.util.LinkedList;
import java.util.List;

/**
 * This class handles control of the overall simulation.
 */
public class Simulator {
    private int initDuration;
    private int initStake;
    private int samples;
    private List<Integer> durations;
    private List<Integer> maxima;
    private Player player;
    private Game game;

    /**
     * Constructor for Simulator objects.
     *
     * @param game   Game this player is playing.
     * @param player The current player.
     */
    public Simulator(Game game, Player player) {
        this.game = game;
        this.player = player;
        this.initDuration = 250;
        this.initStake = 1000;
        this.samples = 50;
        this.durations = new LinkedList<>();
        this.maxima = new LinkedList<>();
    }

    /**
     * Play through one session of a game.
     *
     * @return List of stake values at the start of each round.
     */
    private List<Integer> session() {
        player.setStake(initStake);
        player.setRoundsToGo(initDuration);
        List<Integer> stakeList = new LinkedList<>();

        while (player.playing()) {
            stakeList.add(player.getMoney());
            game.cycle(player);
        }
        stakeList.add(player.getMoney());

        return stakeList;
    }

    /**
     * Play a number of sessions of the game and record the duration
     * and maximum stake value of each one.
     */
    public void gather() {
        for (int i = 0; i < samples; ++i) {
            List<Integer> stakeList = session();

            durations.add(stakeList.size());
            Integer max = 0;
            for (Integer element : stakeList) {
                if (element > max)
                    max = element;
            }

            maxima.add(max);
        }
    }

    /**
     * Get durations of the previous sample run.
     *
     * @return List of durations.
     */
    public List<Integer> getDurations() {
        return durations;
    }

    /**
     * Get list of maximum stakes in the previous sample run.
     *
     * @return List of maximum stake values.
     */
    public List<Integer> getMaxima() {
        return maxima;
    }
}

