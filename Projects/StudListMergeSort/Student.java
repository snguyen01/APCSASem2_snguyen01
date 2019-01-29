
/**
 * Write a description of class Student here.
 *
 * @author (Steven Nguyen)
 * @version (125)
 */
public class Student
{
    // instance variables
    String firstName;
    String middleName;
    String lastName;
    int stuNumber;
    double gpa;
    
    public void setFirstName(String name) { // sets first name
        firstName = name;
    }
    
    public void setMiddleName(String name) { // sets middle name
        middleName = name;
    }
    
    public void setLastName(String name) { // sets last name
        lastName = name;
    }
    
    public void setStuNumber(int number) { // sets student number
        stuNumber = number;
    }
    
    public void setGPA(double stuGpa) { // sets GPA
        gpa = stuGpa;
    }
    
    public String getStudentName() { // returns full name
        return lastName + ", " + firstName + " " + middleName;
    }
    
    public String getLastName() { // returns last name
        return lastName;
    }
    
    public double getGPA() { // returns GPA
        return gpa;
    }
    
    public int getStuNumber() { // returns student number
        return stuNumber;
    }
}