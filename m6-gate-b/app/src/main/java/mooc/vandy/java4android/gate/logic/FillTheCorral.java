package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    public void setCorralGates(Gate[] gates, Random random) {
        mOut.println("Initial gate setup:");
        for (int i = 0; i < gates.length; i++) {
            gates[i].setSwing(random.nextInt(3)-1);
            mOut.println("Gate "+i+": "+gates[i]);

        }
    }

    public boolean anyCorralAvailable(Gate[] gates) {
        for (Gate gate : gates) {
            if (gate.getSwingDirection() == Gate.IN) return true;
        }
        return false;
    }

    public int corralSnails(Gate[] gates, Random random) {
        if(!this.anyCorralAvailable(gates))return 0;
        int pasture = 5;
        int count = 0;
        while (pasture > 0) {
            int index = random.nextInt(gates.length);
            Gate g = gates[index];
            int s = random.nextInt(pasture)+1;
            pasture -= g.thru(s);
            mOut.println(s+" are trying to move through corral "+index);
            count ++;
        }
        mOut.println("It took "+count+" attempts to corral all of the snails");
        return count;
    }
    
}
