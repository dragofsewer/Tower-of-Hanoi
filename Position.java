// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept 
//the actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;
/**
 * Position enum for the tower of hanoi project.
 * 
 * @author Stephen Ye (stepheny)
 * @version 2022.10.18
 */
public enum Position {

    LEFT, MIDDLE, RIGHT, DEFAULT;


    /**
     * Returns the opposite position of the current position.
     * @return the position opposite the position that it refers to
     */
    public Position opposite() {
        if (this == LEFT) {
            return RIGHT;
        }
        else if (this == RIGHT) {
            return LEFT;
        }
        else {
            return DEFAULT;
        }
    }
}
