
/**
 * Write a description of class MySwingApplication here.
 *
 * @author (Steven Nguyen)
 * @version (2419)
 */
import javax.swing.*;


public class MySwingApplication implements Runnable {
    // instance variables
    JFrame jFrame;
    CanvasComponent canvasComponent;
    
    public void run() {
        // creates and sets up a new window
        jFrame = new JFrame("Window");
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // new canvas component object
        canvasComponent = new CanvasComponent(100, 100);
        jFrame.add(canvasComponent);
        jFrame.setVisible(true);
    }
    
    public static void main() {
        // creates new my swing application object
        MySwingApplication mySwingApplicationSwing = new MySwingApplication();
        javax.swing.SwingUtilities.invokeLater(mySwingApplicationSwing);
    }
}