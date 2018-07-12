package RouletteTests;

import RouletteGame.Bin;
import RouletteGame.BinBuilder;
import RouletteGame.Outcome;
import RouletteGame.Wheel;
import org.junit.Test;

import java.util.Random;

public class WheelTest {
    private Wheel wheel;

    @Test
    public void testWheel() {
        // Create outcomes
        Outcome outcome1 = new Outcome("Black", 23);
        Outcome outcome2 = new Outcome("Lad", 25);
        Outcome outcome3 = new Outcome("Win it all", 100);
        Outcome outcome4 = new Outcome("Dont lose", 89);
        Outcome outcome5 = new Outcome("Word up", 53);

        // Create bins
        Bin bin1 = new Bin();
        Bin bin2 = new Bin();

        // Add outcomes to bin
        bin1.addToBin(outcome1);
        bin1.addToBin(outcome2);
        bin1.addToBin(outcome3);

        bin2.addToBin(outcome4);
        bin2.addToBin(outcome5);

        // Create wheel
        wheel = new Wheel();

        // Add bins to wheel
        wheel.addBin(0, bin1);
        wheel.addBin(1, bin2);

//        System.out.println(wheel.toString());

        // Testing RNG
        Bin lad1 = wheel.next();
        Bin lad2 = wheel.next();
        Bin lad3 = wheel.next();
        Bin lad4 = wheel.next();

//        System.out.println("Lad1: " + lad1.toString());
//        System.out.println("Lad2: " + lad2.toString());
//        System.out.println("Lad3: " + lad3.toString());
//        System.out.println("Lad4: " + lad4.toString());

        Random rng = new Random();
        rng.setSeed(3);
        Wheel wheel2 = new Wheel(rng);
        BinBuilder builder = new BinBuilder();
        builder.buildBins(wheel2);

        Bin one = wheel2.next();
        Bin two = wheel2.next();
        Bin three = wheel2.next();
        Bin four = wheel2.next();
        Bin five = wheel2.next();
        Bin six = wheel2.next();

        System.out.println("Bin 1: " + one.toString());
        System.out.println("Bin 2: " + two.toString());
        System.out.println("Bin 3: " + three.toString());
        System.out.println("Bin 4: " + four.toString());
        System.out.println("Bin 5: " + five.toString());
        System.out.println("Bin 6: " + six.toString());
    }
}
