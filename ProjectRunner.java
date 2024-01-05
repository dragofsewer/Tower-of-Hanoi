// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept
//the actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;

/**
*
* contains the main method that starts the puzzle
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class ProjectRunner {




    /**
     * commands the puzzle to start
     * @param args the array os strings that gives info
     *  on how to program will run
     */
    public static void main(String[] args) {
        
        
        int disk = 6;
        if (args.length == 1) {
            disk = Integer.parseInt(args[0]);
        }
        HanoiSolver solver = new HanoiSolver(disk);
        PuzzleWindow window = new PuzzleWindow(solver);
        



    }



}
