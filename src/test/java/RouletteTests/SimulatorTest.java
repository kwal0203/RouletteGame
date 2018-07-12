package RouletteTests;

import RouletteGame.*;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class SimulatorTest {
    @Test
    public void simTest() {
        Wheel wheel = new Wheel();
        BinBuilder builder = new BinBuilder();
        builder.buildBins(wheel);
        Table table = new Table(1000, 10, wheel);
        Game game = new Game(wheel, table);
        Random rng = new Random();
//        Player player = new PlayerFibonacci(0, 0, table);
//        Player player = new PlayerCancellation(0, 0, table);
//        Player player = new Player1326(0, 0, table);
//        Player player = new PlayerRandom(0, 0, table, rng);
//        Player player = new Martingale(0, 0, table);
        Player player = new SevenReds(0, 0, table);

        Simulator sim = new Simulator(game, player);
        sim.gather();
        List<Integer> maxs = sim.getMaxima();
        List<Integer> durs = sim.getDurations();

//        System.out.println("Maxima:");
//        for (Integer i : maxs)
//            System.out.print(i + " ");
//
//        System.out.println();
//        System.out.println("Duration:");
//        for (Integer i : durs)
//            System.out.print(i + " ");
//        System.out.println();

        IntegerStatistics stats = new IntegerStatistics();
        double maxsMean = stats.mean(maxs);
        double maxsStdev = stats.stdev(maxs);
        double dursMean = stats.mean(durs);
        double dursStdev = stats.stdev(durs);

        System.out.println();
        System.out.println(player.getClass().getSimpleName());
        System.out.println();
        System.out.println("Max mean: " + maxsMean);
        System.out.println("Max stdev: " + maxsStdev);
        System.out.println();
        System.out.println("Dur mean: " + dursMean);
        System.out.println("Dur stdev: " + dursStdev);
    }
}
