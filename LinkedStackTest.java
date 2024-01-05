// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;


import student.TestCase;

/**
* test the LinkedStack
* 
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class LinkedStackTest extends TestCase {
    
    private LinkedStack<String> stack;

    /**
     * sets up the needed objects for the test methods
     */
    public void setUp() {
        stack = new LinkedStack<String>();
    }

    /**
     * tests the push method
     */
    public void testPush() {
        stack.push("a");
        assertEquals(1, stack.size());

    }
    
    /**
     * tests the pop method
     */
    public void testPop() {
        Exception thrown = null;
        try 
        {
            stack.pop();
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        stack.push("a");

        assertEquals("a", stack.pop());
        assertEquals(0, stack.size());
    }
    
    /**
     * tests the peek method
     */
    public void testPeek() {
        Exception thrown = null;
        try 
        {
            stack.peek();
        }
        catch (Exception e) 
        {
            thrown = e;
        }
        stack.push("a");
        assertEquals("a", stack.peek());
        assertEquals(1, stack.size());
    }
    
    /**
     * test the isEmpty
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("a");
        assertFalse(stack.isEmpty());
    }
    
    /**
     * test the clear method
     */
    public void testClear() {
        stack.push("a");
        stack.clear();
        assertTrue(stack.isEmpty());
    }
    
    /**
     * tests the toString
     */
    public void testToString() {
        assertEquals("[]", stack.toString());
        stack.push("a");
        
        stack.push("b");

        assertEquals("[b, a]", stack.toString());
    }
    
    

}
