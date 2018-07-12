package RouletteGame;

import java.util.Arrays;

/**
 * This class encapsulates the algorithms that populate the wheel bins
 * with winning outcomes.
 *
 * Author: Kane Walter
 */
public class BinBuilder {
    public void buildBins(Wheel wheel) {
        straightBets(wheel);
        splitBets(wheel);
        streetBets(wheel);
        cornerBets(wheel);
        lineBets(wheel);
        dozenBets(wheel);
        columnBets(wheel);
        evenBets(wheel);
    }

    /**
     * Add straight bet outcomes to the Wheel. This is simply a bet
     * that the ball win land in bin n.
     *
     * @param wheel Game wheel.
     */
    public void straightBets(Wheel wheel) {
        for (Integer i = 1; i < 37; ++i) {
            Outcome outcome = new Outcome("Straight " + i, 35);
            wheel.addOutcome(outcome, i);
        }
        wheel.addOutcome(new Outcome("Zero", 35), 0);
        wheel.addOutcome(new Outcome("Double Zero", 35), 37);
    }

    /**
     * Add split bets to this wheel. Split bets involve putting a bet
     * on two adjacent (on the table) numbers. This turns out to be
     * the n and (n+1) or n and (n+3) numbers for a given n.
     *
     * @param wheel Game wheel.
     */
    public void splitBets(Wheel wheel) {
        // Do horizontal splits
        for (int i = 0; i < 12; ++i) {
            // Get numbers that we are splitting (first column) and
            // convert to string
            int first = (3 * i) + 1;
            int second = first + 1;

            // Create an outcome for this split
            String name = "Split (" + first + ", " + second + ")";
            Outcome outcome = new Outcome(name, 17);

            // Add outcome to bins n and (n + 1)
            wheel.addOutcome(outcome, first);
            wheel.addOutcome(outcome, second);

            // Get numbers that we are splitting (second column) and
            // convert to string
            first = (3 * i) + 2;
            second = first + 1;

            // Create an outcome for this split
            name = "Split (" + first + ", " + second + ")";
            outcome = new Outcome(name, 17);

            // Add outcome to bins n and (n + 1)
            wheel.addOutcome(outcome, first);
            wheel.addOutcome(outcome, second);
        }

        // Do vertical splits
        for (int i = 1; i <= 33; ++i) {
            String name = "Split (" + i + ", " + (i + 3) + ")";
            Outcome outcome = new Outcome(name, 17);
            wheel.addOutcome(outcome, i);
            wheel.addOutcome(outcome, i + 3);
        }
    }

    /**
     * Street bet.
     *
     * @param wheel Game wheel.
     */
    public void streetBets(Wheel wheel) {
        for (int i = 0; i < 12; ++i) {
            int n = (3 * i) + 1;
            String name = "Street (" + n + ", " + (n + 2) + ")";
            Outcome outcome = new Outcome(name, 11);
            wheel.addOutcome(outcome, n);
            wheel.addOutcome(outcome, n + 1);
            wheel.addOutcome(outcome, n + 2);
        }
    }

    /**
     * Corner bet.
     *
     * @param wheel Game wheel.
     */
    public void cornerBets(Wheel wheel) {
        for (int i = 0; i < 11; ++i) {
            int n = (3 * i) + 1;
            String name = "Corner (" + n + ", " + (n + 4) + ")";
            Outcome outcome = new Outcome(name, 8);
            wheel.addOutcome(outcome, n);
            wheel.addOutcome(outcome, n + 1);
            wheel.addOutcome(outcome, n + 3);
            wheel.addOutcome(outcome, n + 4);

            n = (3 * i) + 2;
            name = "Corner (" + n + ", " + (n + 4) + ")";
            outcome = new Outcome(name, 8);
            wheel.addOutcome(outcome, n);
            wheel.addOutcome(outcome, n + 1);
            wheel.addOutcome(outcome, n + 3);
            wheel.addOutcome(outcome, n + 4);
        }
    }

    /**
     * Line bet.
     *
     * @param wheel Game wheel.
     */
    public void lineBets(Wheel wheel) {
        for (int i = 0; i < 11; ++i) {
            int n = (3 * i) + 1;
            String name = "Line (" + i + ", " + (i + 5) + ")";
            Outcome outcome = new Outcome(name, 5);
            wheel.addOutcome(outcome, n);
            wheel.addOutcome(outcome, n + 1);
            wheel.addOutcome(outcome, n + 3);
            wheel.addOutcome(outcome, n + 4);
            wheel.addOutcome(outcome, n + 5);
        }
    }

    /**
     * Dozen bet.
     *
     * @param wheel Game wheel.
     */
    public void dozenBets(Wheel wheel) {
        for (int i = 0; i < 3; ++i) {
            String name = "Dozen " + (i + 1);
            Outcome outcome = new Outcome(name, 2);
            for (int j = 0; j < 12; ++j)
                wheel.addOutcome(outcome, (j + 1));
        }
    }

    /**
     * Column bet.
     *
     * @param wheel Game wheel.
     */
    public void columnBets(Wheel wheel) {
        for (int i = 0; i < 3; ++i) {
            String name = "Column " + (i + 1);
            Outcome outcome = new Outcome(name, 2);
            for (int j = 0; j < 12; ++j)
                wheel.addOutcome(outcome, (3 * j) + i + 1);
        }
    }

    /**
     * Even bet.
     *
     * @param wheel Game wheel.
     */
    public void evenBets(Wheel wheel) {
        Integer[] reds = new Integer[] {1, 3, 5, 7, 9, 12, 14, 16, 18,
                19, 21, 23, 25, 27, 30, 32, 34,
                36};

        Outcome red = new Outcome("Red", 1);
        Outcome black = new Outcome("Black", 1);
        Outcome even = new Outcome("Even", 1);
        Outcome odd = new Outcome("Odd", 1);
        Outcome high = new Outcome("High", 1);
        Outcome low = new Outcome("Low", 1);

        for (int i = 1; i < 37; ++i) {
            if (i < 19)
                wheel.addOutcome(low, i);
            else
                wheel.addOutcome(high, i);

            if (i % 2 == 0)
                wheel.addOutcome(even, i);
            else
                wheel.addOutcome(odd, i);

            boolean contains = Arrays.asList(reds).contains(i);
            if (contains)
                wheel.addOutcome(red, i);
            else
                wheel.addOutcome(black, i);
        }
    }
}
