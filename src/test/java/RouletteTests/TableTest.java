package RouletteTests;

import RouletteGame.Bet;
import RouletteGame.Outcome;
import RouletteGame.Table;
import org.junit.Test;

import java.util.Iterator;

public class TableTest {
    @Test
    public void testTable() {
        Bet one = new Bet(100, new Outcome("Cunt", 34));
        Bet two = new Bet(50, new Outcome("Lad", 43));

        System.out.println();
        System.out.println(one.toString());
        System.out.println(two.toString());

        Table table = new Table(500, 10, null);
        table.placeBet(one);
        table.placeBet(two);

        System.out.println(table.toString());

        System.out.println();
        Iterator<Bet> iter = table.iterator();
        while (iter.hasNext()) {
            Bet b = iter.next();
            System.out.println(b.toString());
        }
    }
}
