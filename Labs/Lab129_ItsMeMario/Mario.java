
/**
 * Write a description of class Mario here.
 *
 * @author (Steven Nguyen)
 * @version (129)
 */
public class Mario extends Character{
    public Mario(String c, int s){
        super(c, s);
    }

    public void setSpeed(int speed){
        super.setSpeed(speed*2);
    }
}