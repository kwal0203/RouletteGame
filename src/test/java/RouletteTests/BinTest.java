package RouletteTests;

import RouletteGame.Bin;
import RouletteGame.Outcome;
import org.junit.Test;

public class BinTest {
    @Test
    public void fillBins() {
        Outcome outcome1 = new Outcome("Black", 23);
        Outcome outcome2 = new Outcome("Lad", 25);
        Outcome outcome3 = new Outcome("Win it all", 100);
        Outcome outcome4 = new Outcome("Dont lose", 89);
        Outcome outcome5 = new Outcome("Word up", 53);

        Bin bin1 = new Bin();
        Bin bin2 = new Bin();

        bin1.addToBin(outcome1);
        bin1.addToBin(outcome2);
        bin1.addToBin(outcome3);

        bin2.addToBin(outcome4);
        bin2.addToBin(outcome5);

        // Bin 1
        System.out.println(bin1.toString());

        // Bin 2
        System.out.println(bin2.toString());
    }
}
