// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the
//actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;

import student.TestCase;

/**
*
* tests the HanoiSolve class
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class HanoiSolverTest extends TestCase {

    private HanoiSolver solver;

    /**
     * sets up the needed objects for the test methods
     */
    public void setUp() {
        solver = new HanoiSolver(3);
    }

    /**
     * tests the disk method
     */
    public void testDisks() {
        assertEquals(3, solver.disks());
        
    }
    
    /**
     * tests the getTower method
     */
    public void testGetTower() {
        Disk l = new Disk(1);
        Disk l2 = new Disk(2);
        Disk mid = new Disk(3);
        Disk mid2 = new Disk(4);
        Disk r = new Disk(5);
        
        solver.getTower(Position.LEFT).push(l);
        solver.getTower(Position.LEFT).push(l2);
        solver.getTower(Position.MIDDLE).push(mid);
        solver.getTower(Position.RIGHT).push(r);
        solver.getTower(Position.DEFAULT).push(mid2);
        
        assertEquals("[2, 1][2, 3][5]", solver.toString());
        
    }
    
    /**
     * tests the toString method
     */
    public void testToString() {
        assertEquals("[1, 2, 3][][]", solver.toString());
    }
    
    /**
     * tests the solve method
     */
    public void testSolve() {
        solver.solve();
        assertEquals("[][][1, 2, 3]", solver.toString());
    }

}
