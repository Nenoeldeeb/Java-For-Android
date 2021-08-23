package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /*
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        horizontalFrames (size);
        topDiamondDrawer(size);
        middleDiamondDrawer(size);
        bottomDiamondDrawer(size);
        horizontalFrames (size);

        
    }


    private void topDiamondDrawer(int size) {
        mOut.print("\n");
        // Draw the top half of the diamond.
        for (int i = 1; i <= size-1; i++) {
            // Draw the right side of the frame.
            mOut.print("|");
            // Draw the right side spaces.
            for (int j = size-1; j >= i; j--) {
                mOut.print(" ");
            }
            // Draw the diamond itself.
            mOut.print("/");
            for (int j = 1; j <= (i-1)*2; j++) {
                // Check if the line number is even or odd.
                if(i % 2 == 0){
                    mOut.print("-");
                    continue;
                }
                mOut.print("=");
            }
            mOut.print("\\");
            // Draw the left side spaces.
            for (int j = size-1; j >= i; j--) {
                mOut.print(" ");
            }
            // Draw the left side of the frame.
            mOut.print("|\n");
        }
    }

    private void middleDiamondDrawer(int size) {
        // Draw the longest middle line of the diamond with the right side frame.
        mOut.print("|<");
        for (int i = 1; i <= (size - 1) * 2; i++) {
            // Check if the line number is even or odd.
            if (size % 2 == 0) {
                mOut.print("-");
                continue;
            }
            mOut.print("=");
        }
        // Draw the left side of the frame.
        mOut.print(">|\n");
    }

    private void bottomDiamondDrawer(int size) {
        // Draw the bottom half of the diamond.
        for (int i = size-1; i >= 1; i--) {
            // Draw the right side of the frame.
            mOut.print("|");
            // Draw the right side spaces.
            for (int j = size-i; j >= 1; j--) {
                mOut.print(" ");
            }
            // Draw the diamond itself.
            mOut.print("\\");
            for (int j = 1; j <= (i-1)*2; j++) {
                // Check the line number is even or odd.
                if(i % 2 == 0){
                    mOut.print("-");
                    continue;
                }
                mOut.print("=");
            }
            mOut.print("/");
            // Draw the left side spaces.
            for (int j = size-i; j >= 1; j--) {
                mOut.print(" ");
            }
            // Draw the left side of the frame.
            mOut.print("|\n");
        }
    }

    private void horizontalFrames (int size) {
        // Draw the top & bottom frames.
        mOut.print("+");
        for (int i = 1; i <= size * 2; i++) {
            mOut.print("-");
        }
        mOut.print("+");
    }

    
}
