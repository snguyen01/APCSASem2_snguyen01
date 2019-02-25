
/**
 * Project 1 - MySwingApplication
 *
 * @ Steven Nguyen
 * @ 2/4/19
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
/**
 * Project 1 - MySwingApplication
 *
 * @ Steven Nguyen
 * @ 2/4/19
 */
public class CanvasComponent extends JComponent implements MouseListener, MouseMotionListener, ActionListener, KeyListener{
    // instance variables
    int rectX;
    int rectY;
    int arcWidth;
    int arcHeight;
    int rectWidth;
    int rectHeight;
    int mouseFromX;
    int mouseFromY;
    boolean mouseInRect;
    boolean shapeSelected;
    int mouseToX;
    int mouseToY;
    int animationDeltaX;
    int animationDeltaY;
    int gutterX;
    int gutterY;
    Timer animationTimer;
    int motionSpeed;
    
    public CanvasComponent(int w, int h){
        // initializes canvas component object
        rectX = 150;
        rectY = 150;
        arcWidth = 20;
        arcHeight = 20;
        rectWidth = w;
        rectHeight = h;
        setSize(rectWidth, rectHeight);
        animationDeltaX = 1;
        animationDeltaY = 0;
        gutterX = 10;
        gutterY = 10;
        motionSpeed = 1;
        // picks up mouse events
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        // animation timer
        animationTimer = new Timer(20, this);
        animationTimer.start();
    }
    
    protected void paintComponent(Graphics g){
        // drawing the rectangle
        if(mouseInRect == true){
            // rectangle flashes random colors when your mouse is inside it/hasn't moved after exiting it
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B = (int)(Math.random()*256);
            Color randColor = new Color(R, G, B);
            g.setColor(randColor);
        } else {
            g.setColor(Color.black);
        }
        g.fillRoundRect(rectX, rectY, rectWidth, rectHeight, arcWidth, arcHeight);
        g.setColor(Color.white);
        g.setColor(Color.black);
        
    }
    
    public void mouseClicked(MouseEvent e){
        // empty method
    }
    
    public void mousePressed(MouseEvent e){
        // gets the position of the mouse
        mouseFromX = e.getX();
        mouseFromY = e.getY();
        
        // determines whether or not the mouse is inside the rectangle
        if(mouseFromX > rectX && mouseFromX < rectX + rectWidth && mouseFromY > rectY && mouseFromY < rectY + rectHeight){
            shapeSelected = true;
        } else {
            shapeSelected = false;
            // motion to follow the mouse
            if(mouseFromX < rectX){
                animationDeltaX = -1;
            } else {
                animationDeltaX = 1;
            }
            if(mouseFromY < rectY){
                animationDeltaY = -1;
            } else {
                animationDeltaY = 1;
            }
        }
    }
    
    public void mouseReleased(MouseEvent e){
        // used to make rectangle start moving after letting go of it
        shapeSelected = false;
    }
    
    public void mouseEntered(MouseEvent e){
        // empty method
    }
    
    public void mouseExited(MouseEvent e){
        // empty method
    }
    
    public void mouseDragged(MouseEvent e){
        if(shapeSelected == true){
            // gets the second mouse position
            mouseToX = e.getX();
            mouseToY = e.getY();
            // increments x position of rectangle
            rectX = rectX + (mouseToX - mouseFromX);
            // increments y position of rectangle
            rectY = rectY + (mouseToY - mouseFromY);
            // resets and redraws the shape
            mouseFromX = mouseToX;
            mouseFromY = mouseToY;
            repaint();
        }
    }
    
    public void mouseMoved(MouseEvent e){
        // gets the position of the mouse
        mouseFromX = e.getX();
        mouseFromY = e.getY();
        
        // extra method to determine whether or not your cursor is in the rectangle
        if(mouseFromX > rectX && mouseFromX < rectX + rectWidth && mouseFromY > rectY && mouseFromY < rectY + rectHeight){
            mouseInRect = true;
        } else {
            mouseInRect = false;
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if(shapeSelected == false){
            // new dimension object
            Dimension componentSizeDimension = getSize();
            if (rectX + rectWidth + animationDeltaX + gutterX > componentSizeDimension.getWidth()){
                // if the rectangle hits the right border, move down
                animationDeltaX = 0;
                animationDeltaY = 1;
                // resets x and y positions
                rectX = (int)componentSizeDimension.getWidth() - rectWidth - gutterX;
                rectY = rectY + animationDeltaY*motionSpeed;
            } else if(rectY + rectHeight + animationDeltaY + gutterY > componentSizeDimension.getHeight()){
                // if the rectangle hits the bottom border, move left            
                animationDeltaX = -1;
                animationDeltaY = 0;
                // resets x and y positions
                rectX = rectX + animationDeltaX*motionSpeed;
                rectY = (int)componentSizeDimension.getHeight() - rectHeight - gutterY;
            } else if(rectX + animationDeltaX < gutterX){
                // if the rectangle hits the left border, move up            
                animationDeltaX = 0;
                animationDeltaY = -1;
                // resets x and y positions
                rectX = gutterX;
                rectY = rectY + animationDeltaY*motionSpeed;
            } else if(rectY + animationDeltaY < gutterY){
                // if the rectangle hits the top border, move right            
                animationDeltaX = 1;
                animationDeltaY = 0;
                // resets x and y positions
                rectX = rectX + animationDeltaX*motionSpeed;
                rectY = gutterY;
            } else {
                // if the rectangle has not collided with a border, keep moving in the same direction
                rectX = rectX + animationDeltaX*motionSpeed;
                rectY = rectY + animationDeltaY*motionSpeed;
            }
        }
        // redraws the shape
        repaint();
    }
    
    public void keyTyped(KeyEvent e){
        // detects if a key is pressed
        char keyChar = e.getKeyChar();
        if(keyChar == '+'){
            // increase the speed if '+' is pressed
            motionSpeed++;
        } else if(keyChar == '-' && motionSpeed > 0){
            // decrease the speed if '-' is pressed
            motionSpeed--;
        }
    }

    public void keyPressed(KeyEvent e){
        // empty method
    }

    public void keyReleased(KeyEvent e){
        // empty method
    }
}