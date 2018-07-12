package RouletteTests;

import RouletteGame.Bet;
import RouletteGame.BinBuilder;
import RouletteGame.Outcome;
import RouletteGame.Wheel;
import org.junit.Test;

import java.util.Map;

public class BetTest {
    @Test
    public void betTest() {
        Wheel wheel = new Wheel();
        BinBuilder builder = new BinBuilder();
        builder.buildBins(wheel);

        Map<String, Outcome> map = wheel.getOutcomes();

        for (String s : map.keySet())
            System.out.println("Key: " + s + ", Value: " + map.get(s));

        Bet one = new Bet(100, new Outcome("Lad ere", 34));
        Bet two = new Bet(50, new Outcome("Lad", 43));

        System.out.println();
        System.out.println(one.toString());
        System.out.println(two.toString());

        int won1 = one.winAmount();
        int won2 = two.winAmount();

        System.out.println();
        System.out.println("Winning 1: " + won1);
        System.out.println("Winning 2: " + won2);

        int lost1 = one.loseAmount();
        int lost2 = two.loseAmount();

        System.out.println();
        System.out.println("Lost 1: " + lost1);
        System.out.println("Lost 2: " + lost2);

        Outcome out1 = one.getOutcome();
        Outcome out2 = two.getOutcome();

        System.out.println();
        System.out.println(out1.toString());
        System.out.println(out2.toString());
    }
}
