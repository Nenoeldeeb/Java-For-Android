package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add implements ICalculator{


    /**The first number in the calculation.*/
    private final int val1;
    /**The second number in the calculation.*/
    private final int val2;

    /**
     * The constructor to initialize the instance fields.
     * @param val1 The first number in the calculation.
     * @param val2 The second number in the calculation.
     */
    public Add(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    /**
     * This method will perform the addition operation.
     * @return The sum of addition operation.
     */
    @Override
    public String calculate() {
        return Integer.toString(val1+val2);
    }
}
