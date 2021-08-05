package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage
       extends House {

    private boolean mSecondFloor;

    public Cottage(int dimension, int lotLength, int lotWidth) {
        super(dimension,dimension,lotLength,lotWidth);
        this.mSecondFloor = false;
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean mSecondFloor) {
        this(dimension, lotLength, lotWidth);
        this.setOwner(owner);
        this.mSecondFloor = mSecondFloor;
    }

    public boolean hasSecondFloor() {
        return mSecondFloor;
    }

    @Override
    public String toString() {
        if(!hasSecondFloor())return super.toString() + "; is a cottage";
        return super.toString() + "; is a two story cottage";
    }
}

