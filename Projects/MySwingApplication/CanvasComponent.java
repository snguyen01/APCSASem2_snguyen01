import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Project 1 - MySwingApplication
 *
 * @ Steven Nguyen
 * @ 2/4/19
 */
public class CanvasComponent extends JComponent implements MouseListener, MouseMotionListener, ActionListener
{
    int x = 100;
    int y = 100;
    int width = 100;
    int height = 100;
    int mouseFromX;
    int mouseFromY;
    int mouseToX;
    int mouseToY;
    boolean shapeSelected;
    int animationDeltaX = 1;
    int animationDeltaY = 0;
    int gutterX = 10;
    int gutterY = 10;
    Dimension componentSizeDimension;
    public CanvasComponent(int height, int width)
    {
        setSize(height, width);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }               
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    //MouseListener
    public void mouseClicked(MouseEvent e)
    {
    
    }
    public void mousePressed(MouseEvent e)
    {
        mouseFromX = e.getX();
        mouseFromY = e.getY();
        if((mouseFromX >= x && mouseFromX <= x + height) && (mouseFromY >= y && mouseFromY <= y + width))
        {
            shapeSelected = true;
        }
        else
        {
            shapeSelected = false;
        }
    }
    public void mouseReleased(MouseEvent e)
    {
    
    }
    public void mouseEntered(MouseEvent e)
    {
    
    }
    public void mouseExited(MouseEvent e)
    {
    
    }
    //MouseMotionListener
    public void mouseDragged(MouseEvent e)
    {
        mouseToX = e.getX();
        mouseToY = e.getY();
        if(shapeSelected)
        {
            x += mouseToX - x;
            y += mouseToY - y;
            repaint();
        }
    }
    public void mouseMoved(MouseEvent e)
    {
        
    }
    public void actionPerformed(ActionEvent e)
    {
        componentSizeDimension = getSize();
    }
}    