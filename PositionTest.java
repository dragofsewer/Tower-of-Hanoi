// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept
//the actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;

import student.TestCase;

/**
* tests the position emun
* 
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class PositionTest extends TestCase {

    private Position position;

    /**
     * sets up the needed objects for the test methods
     */
    public void setUp() {
        position = Position.LEFT;
    }

    /**
     * tests the opposite method
     */
    public void testOpposite() {
        assertEquals(Position.RIGHT, position.opposite());
        position = Position.RIGHT;
        assertEquals(Position.LEFT, position.opposite());
        position = Position.MIDDLE;
        assertEquals(Position.DEFAULT, position.opposite());
        position = Position.DEFAULT;

    }

}
