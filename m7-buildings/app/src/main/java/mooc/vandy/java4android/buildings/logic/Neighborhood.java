package mooc.vandy.java4android.buildings.logic;

import android.icu.util.Output;

import java.io.FileNotFoundException;

import mooc.vandy.java4android.buildings.ui.OutputInterface;

/**
 * This Neighborhood utility class provides static helper methods the
 * print a Building List and calculate the area of a Building list.
 * A utility class in Java should always be final and have a private
 * constructor.
 */
public final class Neighborhood {

    private Neighborhood() {

    }

    public static void print(Building[] buildings, String header, OutputInterface mOut) {
        mOut.println(header);
        for (Building b : buildings) {
            mOut.println(b          );
        }
    }

    public static int calcArea(Building[] buildings) {
        int total = 0;
        for (Building b : buildings) {
            total += b.calcLotArea();
        }
        return total;
    }
    
}
