// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept
//the actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;

import cs2.Shape;
import student.TestableRandom;
import java.awt.Color;

/**
* this class creates the disk that will be stacked in the game
* 
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class Disk extends Shape implements Comparable<Disk> {
    
    /**
     * creates the disk object and the charateristics of it
     * @param width the width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, 8);
        TestableRandom rgb = new TestableRandom();
        int col1 = rgb.nextInt(256);
        int col2 = rgb.nextInt(256);
        int col3 = rgb.nextInt(256);
        Color color = new Color(col1, col2, col3);
        


    }

    /**
     * compares two disk objects to see if their widths are the same
     * @param otherDisk the disk that is being compared
     * @return int 1 if disk is larger, -1 if smaller, and 0 if equal
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        if (this.getWidth() > otherDisk.getWidth()) {
            return 1;
        }
        else if (this.getWidth() < otherDisk.getWidth()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    /**
     * Returns a string representation of this disk.
     * @return a string representation of this disk
     */
    public String toString() {
        return this.getWidth() + "";
    }

    /**
     * Returns true if this disk is equal to the other disk.
     * @param other the other disk
     * @return true if this disk is equal to the other disk
     */
    public boolean equals(Object other) {
        if (other instanceof Disk) {
            return this.compareTo((Disk) other) == 0;
        }
        return false;
    }

}
