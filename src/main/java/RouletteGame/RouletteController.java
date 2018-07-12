package RouletteGame;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * Class to handling network requests.
 */
@RestController
public class RouletteController {
    @RequestMapping("/")
    public Results simulate(@RequestParam(value = "text",
            defaultValue = "No content provided") String text)
    {
        Wheel wheel = new Wheel();
        BinBuilder builder = new BinBuilder();
        builder.buildBins(wheel);
        Table table = new Table(1000, 10, wheel);
        Game game = new Game(wheel, table);

        Player player = null;
        switch (text) {
            case "Martingale":
                player = new Martingale(0, 0, table);
                break;
            case "Player57":
                player = new Player57(0, 0, table);
                break;
            case "SevenReds":
                player = new SevenReds(0, 0, table);
                break;
            case "Player1326":
                player = new Player1326(0, 0, table);
                break;
            case "PlayerCancellation":
                player = new PlayerCancellation(0, 0, table);
                break;
            case "PlayerFibonacci":
                player = new PlayerFibonacci(0, 0, table);
                break;
            case "PlayerRandom":
                Random rng = new Random();
                player = new PlayerRandom(0, 0, table, rng);
            default:
                break;
        }

        Simulator sim = new Simulator(game, player);
        sim.gather();
        List<Integer> maxs = sim.getMaxima();
        List<Integer> durs = sim.getDurations();

        IntegerStatistics stats = new IntegerStatistics();
        double maxsMean = stats.mean(maxs);
        double maxsStdev = stats.stdev(maxs);
        double dursMean = stats.mean(durs);
        double dursStdev = stats.stdev(durs);

        return new Results(text, maxsMean, maxsStdev, dursMean, dursStdev);
    }
}
