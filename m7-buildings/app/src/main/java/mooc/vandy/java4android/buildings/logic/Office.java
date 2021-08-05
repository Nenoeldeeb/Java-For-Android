package mooc.vandy.java4android.buildings.logic;

import com.google.common.base.Objects;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office
       extends Building {


    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length,width,lotLength,lotWidth);
        this.setBusinessName(null);
        this.setParkingSpaces(0);
        sTotalOffices ++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        this(length, width, lotLength, lotWidth);
        this.setBusinessName(businessName);
        this.setParkingSpaces(0);
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int mParkingSpaces) {
        this(length, width, lotLength, lotWidth,businessName);
        this.setParkingSpaces(mParkingSpaces);
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public void setBusinessName(String mBusinessName) {
        this.mBusinessName = mBusinessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public void setParkingSpaces(int mParkingSpaces) {
        this.mParkingSpaces = mParkingSpaces;
    }

    public static int getTotalOffices() {
        return sTotalOffices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Business: ");
        if(this.getBusinessName() == null)sb.append("unoccupied");
        else sb.append(this.getBusinessName());
        if(this.getParkingSpaces() > 0)sb.append("; has ").append(this.getParkingSpaces()).append(" parking spaces");
        return sb.append(" (total offices: ").append(Office.getTotalOffices()).append(")").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return this.calcBuildingArea() == office.calcBuildingArea() && this.getParkingSpaces() == office.getParkingSpaces();
    }

}
