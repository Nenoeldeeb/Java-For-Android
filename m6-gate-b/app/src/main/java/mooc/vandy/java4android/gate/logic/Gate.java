package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {

    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;

    private int mSwing;

    public Gate() {
        this.mSwing = CLOSED;
    }

    public boolean setSwing(int direction) {
        if ((mSwing == CLOSED && (direction == IN || direction == OUT)) || (mSwing == IN && (direction == OUT || direction == CLOSED)) ||
                (mSwing == OUT && (direction == IN || direction == CLOSED))) {
            mSwing = direction;
            return true;
        }
        return false;
    }

    public boolean open(int direction) {
        if ((direction == IN || direction == OUT) && mSwing != direction) {
            return this.setSwing(direction);
        }
        return false;
    }

    public void close() {
        if(mSwing != CLOSED)this.setSwing(CLOSED);
    }

    public int getSwingDirection() {
        return mSwing;
    }

    public int thru(int count) {
        if(mSwing == IN)return +count;
        else if(mSwing == OUT)return -count;
        return 0;
    }

    @Override
    public String toString() {
        if(mSwing == CLOSED)return "This gate is closed";
        else if(mSwing == IN)return "This gate is open and swings to enter the pen only";
        else if(mSwing == OUT)return "This gate is open and swings to exit the pen only";
        return "This gate has an invalid swing direction";
    }

}