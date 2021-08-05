package mooc.vandy.java4android.calculator.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic implements LogicInterface {
    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    
    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out) {
        mOut = out;
        
    }

    

    /**
     * Perform the operation on argumentOne and argumentTwo.
     */
    public void process(int argumentOne, int argumentTwo, int operation) {
        ICalculator calculator = chooseOperation(argumentOne,argumentTwo,operation);
        mOut.print(calculator.calculate());
    }


    /**
     * This method will choose one of four operations based on the operation parameter.
     * @param val1 The first number in the calculation.
     * @param val2 The second number in the calculation.
     * @param operation The operation number.
     * @return The operation object ready to call methods on It.
     */
    private ICalculator chooseOperation(int val1,int val2,int operation) {
        List<ICalculator>  operations = new ArrayList<>();
        operations.add(new Add(val1,val2));
        operations.add(new Subtract(val1,val2));
        operations.add(new Multiply(val1,val2));
        operations.add(new Divide(val1,val2));
        return operations.get(operation-1);
    }
}
