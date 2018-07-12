package RouletteGame;

import java.util.*;

/**
 * Class for player selecting random strategies.
 */
public class PlayerRandom extends Player {
    Random rng;

    /**
     * Constructor for PlayerRandom objects.
     *
     * @param stake      Amount of money player currently has.
     * @param roundsToGo How many more rounds the player will play.
     * @param table      The table the player is playing on.
     */
    public PlayerRandom(int stake, int roundsToGo, Table table, Random rng) {
        super(stake, roundsToGo, table);
        this.rng = rng;
    }

    /**
     * Player placing random bets.
     */
    @Override
    public void placeBet() {
        List<Outcome> list = new ArrayList<>();
        Collections.addAll(table.getOutcomesFromTable().values());
//        for (Outcome o : table.getOutcomesFromTable().values())
//            list.add(o);
//        for (Outcome o : table.getOutcomesFromTable().values())
//            list.add(o);
        int index = rng.nextInt(list.size());
        Outcome betOutcome = list.get(index);

        int amount = 10;
        if (amount > super.getMoney())
            amount = super.getMoney();
        if (super.getRoundsToGo() > 0 && amount > 0) {
//            System.out.println("Betting amount: " + amount);
            Bet bet = new Bet(amount, betOutcome);
            table.placeBet(bet);
            super.decrementRounds();
        }
    }
}

