package RouletteTests;

import RouletteGame.BinBuilder;
import RouletteGame.Wheel;
import org.junit.Test;

public class BinBuilderTest {
    @Test
    public void testBins() {
        Wheel wheel = new Wheel();
        BinBuilder builder = new BinBuilder();
        builder.buildBins(wheel);

        System.out.println(wheel.toString());
    }
}
