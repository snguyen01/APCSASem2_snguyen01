
/**
 * Write a description of class GridTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridTester
{
    private int columns;
    private int rows; 
    private Cell[][] arr;
    /**
     * Constructor for objects of class GridTester
     */
    public GridTester(int rowParam, int colParam)
    {
        rows = rowParam;
        columns = colParam;
        arr = new Cell[rows][columns];
    }

    public void loadOccupied(){
        
    }
}

