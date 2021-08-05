package mooc.vandy.java4android.calculator.logic;

/**
 * Interface that will unifies the call of different operation classes.
 */
public interface ICalculator {


    /**
     * The calculate method that all implementing classes must implement.
     * @return The result of calculation.
     */
    public String calculate();


}
