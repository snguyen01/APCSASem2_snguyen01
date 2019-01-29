
/**
 * Write a description of class Character here.
 *
 * @author (Steven Nguyen)
 * @version (129)
 */
public class Character {
    String catchphrase;
    int speed;
    
    public Character(String c, int s) {
        setCatchphrase(c);
        setSpeed(s);
    }

    public void setCatchphrase(String phrase) {
        catchphrase = phrase;
    }
    
    public String getCatchphrase() {
        return catchphrase;
    }
    
    public void setSpeed(int value) {
        speed = value;
    }
    
    public int getSpeed() {
        return speed;
    }
}