
/**
 * Write a description of class addClimb here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class addClimb
{
    a. public void addClimb(String peakName, int climbTime)
    {
        climbList.add(new ClimbInfo(peakName, climbTime));
    }

    b. public void addClimb(String peakName, int climbTime)
    {
        int i = 0;

        while(i < climbList.size() &&
        peakName.compareTo(climbList.get(i).getName()) > 0){
            i++;

            climbList.add(i, new ClimbInfo(peakName, climbTime));
        }
    }
    
    c. Yes,No
}