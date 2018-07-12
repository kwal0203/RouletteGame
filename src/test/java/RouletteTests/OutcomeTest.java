package RouletteTests;

import RouletteGame.Outcome;
import org.junit.Test;

public class OutcomeTest {
    @Test
    public void testOutcome() {
        Outcome outcome1 = new Outcome("Black", 5);
        Outcome outcome2 = new Outcome("Black", 5);
        Outcome outcome3 = new Outcome("Red", 10);

        // Test equals()
        if (outcome1.equals(outcome2))
            System.out.println("Outcomes 1 and 2 are equal");
        else
            System.out.println("Outcomes 1 and 2 are not equal");

        if (outcome1.equals(outcome3))
            System.out.println("Outcomes 1 and 3 are equal");
        else
            System.out.println("Outcomes 1 and 3 are not equal");
        System.out.println();

        // Test getName()
        System.out.println("Outcome1 name: " + outcome1.getName());
        System.out.println("Outcome2 name: " + outcome2.getName());
        System.out.println("Outcome3 name: " + outcome3.getName());
        System.out.println();

        // Test hashCode()
        System.out.println("Outcome1 hashcode: " +
                outcome1.hashCode());
        System.out.println("Outcome2 hashcode: " +
                outcome2.hashCode());
        System.out.println("Outcome3 hashcode: " +
                outcome3.hashCode());
        System.out.println();

        // Test winAmount()
        outcome1.toString();
        System.out.println("Bet 10 on outcome1");
        if (outcome1.winAmount(10) == (5 * 10))
            System.out.println("Win amount works for outcome1");
        else
            System.out.println("Win amount doesn't work for outcome1");

        outcome2.toString();
        System.out.println("Bet 10 on outcome2");
        if (outcome2.winAmount(33) == (5 * 33))
            System.out.println("Win amount works for outcome2");
        else
            System.out.println("Win amount doesn't work for outcome2");

        outcome3.toString();
        System.out.println("Bet 10 on outcome3");
        if (outcome3.winAmount(10) == (10 * 10))
            System.out.println("Win amount works for outcome3");
        else
            System.out.println("Win amount doesn't work for outcome3");
        System.out.println();
    }
}
