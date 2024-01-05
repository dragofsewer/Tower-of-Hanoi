// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept 
//the actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;
import student.TestCase;

/**
* test the disk class
* 
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class DiskTest extends TestCase {

    private Disk disk;


    /**
     * sets up the needed objects for the test methods
     */
    public void setUp() {
        disk = new Disk(5);

    }

    /**
     * test the compareTo method
     */
    public void testCompareTo() {
        Disk disk2 = new Disk(6);
        assertEquals(-1, disk.compareTo(disk2));
        Disk disk3 = new Disk(4);
        assertEquals(1, disk.compareTo(disk3));
        Disk disk4 = new Disk(5);
        assertEquals(0, disk.compareTo(disk4));
        Disk disk5 = null;
        Exception thrown = null;
        try 
        {
            disk.compareTo(disk5);
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        
    }
    
    /**
     * test the toString method
     */
    public void testToString() {
        assertEquals("5", disk.toString());
    }

    /**
     * test the equals method
     */
    public void testEquals() {
        Disk disk2 = new Disk(5);
        assertTrue(disk.equals(disk2));
        Disk disk3 = new Disk(6);
        assertFalse(disk.equals(disk3));
        assertFalse(disk.equals(null));
        assertFalse(disk.equals("5"));
    }
}
