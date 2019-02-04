import javax.swing.*;
import java.awt.*;
/**
 * Project 1 - MySwingApplication
 *
 * @ Steven Nguyen
 * @ 2/4/19
 */

public class CanvasComponent extends JComponent {
    int xPos;
    int yPos;
    int width;
    int height;
    
    public CanvasComponent(int width, int height){
        setSize(width, height);
        xPos = 200;
        yPos = 200;
        width = 400;
        height = 400;
    }
    
    public void paintComponent(int xPos, int yPos, int width, int height){
        //setColor(Color.red);
        
    }
}