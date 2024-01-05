// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the
//actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;

import java.util.Observable;

/**
*
* The class that solves the tower of hanoi puzzle.
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {

    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;

    /**
     * Creates a new HanoiSolver with the given number of disks.
     * @param numDisks the number of disks in the puzzle
     */
    public HanoiSolver(int numDisks) {
        this.numDisks = numDisks;
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
        right = new Tower(Position.RIGHT);
        for (int i = numDisks; i > 0; i--) {
            left.push(new Disk(i));
        }
    }

    /**
     * Returns the number of disks in the puzzle.
     * @return the number of disks in the puzzle
     */
    public int disks() {
        return numDisks;
    }

    /**
     * Returns the tower at the given position.
     * @param position the position of the tower
     * @return the tower at the given position
     */
    public Tower getTower(Position position) {
        if (left.isEmpty() && right.isEmpty()) {
            return middle;
        }
        else if (middle.isEmpty() && right.isEmpty()) {
            return left;
        }
        else {
            return right;
        }
    }
    
    /**
     * Returns the tower at the given position.
     * @return String the th
     */
    public String toString() {
        return left.toString() + middle.toString() + right.toString();
    }

    /**
     * determines the move that is needed to be made.
     * 
     * @param from the tower to move from
     * @param to the tower to move to
     * 
     */
    private void move(Tower from, Tower to) {
        to.push(from.pop());
        setChanged();
        notifyObservers( );
    }

    /**
     * sets up the towers needed to be moved
     * @param currentDisks the number of disks
     * @param startPole the tower to move from
     * @param tempPole the tower that is used temporarily
     * @param endPole the tower to move to
     */
    private void solveTowers(int currentDisks, Tower startPole, 
        Tower tempPole, Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }

    /**
     * Solves the puzzle using the changes made in the solveTowers method.
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }

}
