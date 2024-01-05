// Virginia Tech Honor Code Pledge:

//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
//accept the actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;
/**
* Contains the main method for the tower of hanoi project.
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class Tower extends LinkedStack<Disk> {

    private Position position;

    /**
     * Creates a new tower with the given position.
     * 
     * @param position the position of the tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }

    /**
     * Returns the position of the tower.
     * @return the position of the tower
     */
    public Position position() {
        return position;
    }

    /**
     * Pushes the given disk onto the tower.
     * @param disk the disk to push onto the tower
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
            
        }
        if ((isEmpty()) || (disk.compareTo(peek()) == -1)) {
            super.push(disk);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

}
