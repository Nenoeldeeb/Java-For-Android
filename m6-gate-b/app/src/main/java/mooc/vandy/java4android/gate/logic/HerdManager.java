package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.MainActivity;
import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;
    /**The size of the escargatoire.*/
    public static final int HERD = 24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    public void simulateHerd(Random random) {
        int pen = HERD;
        int pasture = 0;
        int randomNumber = 0;
        mOut.println("There are currently "+pen+" snails in the pen and "+pasture+" snails in the pasture");
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            if (pen == 0) {
                randomNumber = random.nextInt(pasture)+1;
                pen += mWestGate.thru(randomNumber);
            } else if (pasture == 0) {
                randomNumber = random.nextInt(pen)+1;
                pen += mEastGate.thru(randomNumber);
            }
            else{
                if (random.nextBoolean()) {
                    randomNumber = random.nextInt(pen)+1;
                    pen += mEastGate.thru(randomNumber);
                }
                else{
                    randomNumber = random.nextInt(pasture)+1;
                    pen += mWestGate.thru(randomNumber);
                }
            }
            pasture = HERD - pen;
            mOut.println("There are currently "+pen+" snails in the pen and "+pasture+" snails in the pasture");
        }
    }


    
}
