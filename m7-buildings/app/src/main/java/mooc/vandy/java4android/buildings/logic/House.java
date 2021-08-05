package mooc.vandy.java4android.buildings.logic;

import androidx.annotation.Nullable;

/**
 * This is the House class file that extends Building.
 */
public class House
       extends Building {

    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth) {
        super(length,width,lotLength,lotWidth);
        this.setPool(false);
        this.setOwner(null);
    }

    public House(int length, int width, int lotLength, int lotWidth, String mOwner) {
        this(length,width,lotLength,lotWidth);
        this.setOwner(mOwner);
        this.setPool(false);
    }

    public House(int length, int width, int lotLength, int lotWidth, String mOwner, boolean mPool) {
        this(length,width,lotLength,lotWidth,mOwner);
        this.setPool(mPool);
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String mOwner) {
        this.mOwner = mOwner;
    }

    public boolean hasPool() {
        return mPool;
    }

    public void setPool(boolean mPool) {
        this.mPool = mPool;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Owner: ");
        if(this.getOwner() == null)sb.append("n/a");
        else sb.append(this.getOwner());
        if(this.hasPool())sb.append("; has a pool");
        if(this.calcLotArea() > this.calcBuildingArea())sb.append("; has a big open space");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house = (House) o;

        return this.calcBuildingArea() == house.calcBuildingArea() && this.hasPool() == house.hasPool();
    }


}
