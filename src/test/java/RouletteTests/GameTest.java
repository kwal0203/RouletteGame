package RouletteTests;

import RouletteGame.BinBuilder;
import RouletteGame.Game;
import RouletteGame.Table;
import RouletteGame.Wheel;
import org.junit.Test;

import java.util.Random;

public class GameTest {
    @Test
    public void gameTest() {
        Random rng = new Random();
        rng.setSeed(3);
        Wheel wheel = new Wheel(rng);
        BinBuilder builder = new BinBuilder();
        builder.buildBins(wheel);

        // System.out.println(wheel.toString());

        Table table = new Table(1000, 1, wheel);
        Player player = new Player57(100, 20, table);

        Game game = new Game(wheel, table);
//        System.out.println("Money: " + player.getMoney());
//        game.cycle(player);
//        System.out.println("Money: " + player.getMoney());
//        game.cycle(player);
//        System.out.println("Money: " + player.getMoney());
//        game.cycle(player);
//        System.out.println("Money: " + player.getMoney());
//        game.cycle(player);
//        System.out.println("Money: " + player.getMoney());
//        game.cycle(player);
//        System.out.println("Money: " + player.getMoney());
//        game.cycle(player);
//        System.out.println("Money: " + player.getMoney());

        Player player2 = new Martingale(100, 20, table);

        System.out.println("Money: " + player2.getMoney());
        game.cycle(player2);
        System.out.println("Money: " + player2.getMoney());
        game.cycle(player2);
        System.out.println("Money: " + player2.getMoney());
        game.cycle(player2);
        System.out.println("Money: " + player2.getMoney());
        game.cycle(player2);
        System.out.println("Money: " + player2.getMoney());
        game.cycle(player2);
        System.out.println("Money: " + player2.getMoney());
        game.cycle(player2);
        System.out.println("Money: " + player2.getMoney());
    }
}
