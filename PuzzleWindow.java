// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I 
//accept the actions of those who do.
// -- Stephen Ye(stepheny)
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
* creates the window where the game will take place
* 
* 
* @author Stephen Ye (stepheny)
* @version 2022.10.18
*/
public class PuzzleWindow implements Observer{

    private HanoiSolver game;
    private Shape left;
    private Shape middle;
    private Shape right;
    private Window window;
    
    private static final int WIDTH_FACTOR = 10;
    private static final int DISK_GAP = 1;
    private static final int DISK_HEIGHT = 8;

    /**
     * creates the window and add the base to the window
     * @param game the game to be played
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);

        window = new Window("Tower of Hanoi");
        
        left = new Shape(200, 50, 10, 200);
        middle = new Shape(300, 50, 10, 200);
        right = new Shape(400, 50, 10, 200);
        
        Shape bottom = new Shape(150, 250, 300, 30);
        
        for (int i = game.disks() - 1; i >= 0; i-- ) {
            //
           // Disk newDisk = new Disk(WIDTH_FACTOR * i);
            //window.addShape(newDisk);
            //game.getTower(Position.LEFT).push(newDisk);
            //moveDisk(Position.LEFT);
            this.game.getTower(Position.LEFT).push(new Disk(i*WIDTH_FACTOR));
            window.addShape(this.game.getTower(Position.LEFT).peek());
            this.moveDisk(Position.LEFT);
            
        }
        
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        window.addShape(bottom);
        
        Button solve = new Button("Solve");
        window.addButton(solve,  WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }
    
    /**
     * gives the game a bit of a delay in between steps
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }
    
    /**
     * starts the chain of actions that would happen 
     * when user starts the game
     * @param button the solve button
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }

    /**
     * moves the disk to the correct place for the puzzle
     * @param position the position where the disk is
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole = null;
        if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.MIDDLE) {
            currentPole = middle;
        }
        else {
            currentPole = right;
        }
        
        int mid = currentPole.getX() + (currentPole.getWidth() / 2);
        int bottom = currentPole.getY() + currentPole.getHeight();
        int x = mid - (currentDisk.getWidth() / 2);
        int y = bottom - (DISK_HEIGHT * game.getTower(position).size())
            - (DISK_GAP * game.getTower(position).size());
        currentDisk.setX(x);
        currentDisk.setY(y);
        

    }



    /**
     * updates the board to match where the disks should be
     * @param o the observable
     * @param arg used as a position
     */
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisk((Position) arg);
            sleep();
            
        }
        
    }

}
