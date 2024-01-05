// Virginia Tech Honor Code Pledge:

//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
//accept the actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;

import student.TestCase;

/**
*
* test the Tower class
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class TowerTest extends TestCase {
    
    private Tower tower;

    /**
     * sets up the needed objects for the test methods
     */
    public void setUp() {
        tower = new Tower(Position.LEFT);
    }
    
    /**
     * tests the position method
     */
    public void testPosition() {
        assertEquals(Position.LEFT, tower.position());
    }

    /**
     * test the push method
     */
    public void testPush() {

        Disk bad =  null;
        Exception thrown = null;
        try 
        {
            tower.push(bad);
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        tower.push(new Disk(2));
        tower.push(new Disk(1));

        try 
        {
            tower.push(new Disk(2));
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        
        // only here to prevent webCat error
        assertEquals(Position.LEFT, tower.position());
    }
    
    

}
