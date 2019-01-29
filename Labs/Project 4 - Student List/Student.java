/**
 * ArrayList Project
 *
 * @Steven Nguyen
 * @version 1025
 */
public class Student
{
    /**
     * Instance variables of class Student initialized
     */
    private String firstName;
    private String middleName;
    private String lastName;
    private int stuNumber;
    private double stuGPA;

    /**
     * Constructor for objects of class Student
     */
    public Student(String name, int num, double gpa)
    {
        firstName = "";
        middleName = "";
        lastName = "";
        stuNumber = num;
        stuGPA = gpa;
    }

    /**
     * Student Methods (getters and setters for each)
     *
     */
    public void setStuNumber(int sn)
    {
        stuNumber = sn;
    }
    public int getStuNumber()
    {
        return stuNumber;
    }
    public void setStuGPA(double sn)
    {
        stuGPA = sn;
    }
    public double getStuGPA()
    {
        return stuGPA;
    }
    public void setFirstName(String sn)
    {
        firstName = sn;
    }
    public void setMiddleName(String sn)
    {
        middleName = sn;
    }
    public void setLastName(String sn)
    {
        lastName = sn;
    }
    public String getFullName()
    {
        return lastName+", "+firstName+" "+middleName;
    }
    public String getLastName()
    {
        return lastName;
    }
}
