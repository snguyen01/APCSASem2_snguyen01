import javax.swing.*;
/**
 * Write a description of class MySwingApplication here.
 *
 * @author (Steven Nguyen)
 * @version (2419)
 */
public class MySwingApplication implements Runnable {
    JFrame jFrame;
    public void run() {
        jFrame = new JFrame("Window");
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    
    public static void main() {
       MySwingApplication mySwingApplicationSwing = new MySwingApplication();
       javax.swing.SwingUtilities.invokeLater(mySwingApplicationSwing);
    }
}