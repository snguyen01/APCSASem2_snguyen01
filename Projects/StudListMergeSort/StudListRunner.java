import java.util.Scanner;
import java.util.ArrayList;
/**
 * ArrayList Project 2- Student List
 *
 * @author (Steven Nguyen)
 * @version (Lab 125)
 */

public class StudListRunner{
    public static void main() {
        // whether or not the user has chosen to end the program
        boolean end = false;
        // create a new student list
        StudList studList = new StudList();
        while(end == false) {
            // takes in the user's command
            int command = menuNumber();
            if(command == 10) {
                // ends the program
                end = true;
            } else if (command == 1) {
                // adds a student
                Scanner command1 = new Scanner(System.in);
                System.out.print("Enter your student's name: ");
                String name = command1.nextLine();
                if((name.indexOf(",") != -1 && name.indexOf(" ") != -1 && name.indexOf(" ", name.indexOf(" ")) != -1) || (name.indexOf(",") == -1 && name.indexOf(" ") != -1)) {
                    System.out.print("Enter your student's student number: ");
                    int number = command1.nextInt();
                    if(countDigits(number) == 6) {
                        // ensures they enter valid inputs
                        System.out.print("Enter your student's GPA: ");
                        double gpa = command1.nextDouble();
                        // calls add student method
                        studList.addStudentToList(name, number, gpa);
                        System.out.println("Your student has been added!");
                    } else {
                        // prints invalid input message
                        invalid();
                    }
                } else {
                    invalid();
                }
                System.out.println();
            } else if (command == 2) {
                // to remove a student from the list
                Scanner command2 = new Scanner(System.in);
                System.out.print("Enter your student's last name: ");
                String name = command2.nextLine();
                if(studList.deleteStudentFromList(name) == true) {
                    // confirms removal
                    System.out.println("Your student has been removed!");
                } else {
                    // if the student wasn't found
                    System.out.println("Sorry, this student was not in the list.");
                }
                System.out.println();
            } else if (command == 3) {
                // edits a student
                Scanner command3 = new Scanner(System.in);
                // options make another scanner for the input
                System.out.println("Would you like to search for your student:");
                System.out.println("  - by student number (press 1), or");
                System.out.println("  - by last name (press 2)?");
                int choice = command3.nextInt();
                if (choice == 1) {
                    // search by number
                    Scanner command32 = new Scanner(System.in);
                    System.out.print("Enter your student's student number: ");
                    int number = command32.nextInt();
                    if(countDigits(number) == 6) {
                        // ensures input is valid
                        Scanner command33 = new Scanner(System.in);
                        System.out.print("Enter your student's updated name: ");
                        String name = command33.nextLine();
                        if((name.indexOf(",") != -1 && name.indexOf(" ") != -1 && name.indexOf(" ", name.indexOf(" ")) != -1) || (name.indexOf(",") == -1 && name.indexOf(" ") != -1)) {
                            // updated information
                            System.out.print("Enter your student's updated GPA: ");
                            double gpa = command33.nextDouble();
                            String last = null;
                            if(studList.editStudentList(number, last, name, gpa) == true) {
                                // confirms edit
                                System.out.println("Your student has been edited!");
                            } else {
                                // if student wasn't found
                                System.out.println("Sorry, this student was not in the list.");
                            }
                        } else {
                            invalid();
                        }
                    } else {
                        invalid();
                    }
                } else if (choice == 2) {
                    // search by name
                    Scanner command32 = new Scanner(System.in);
                    System.out.print("Enter your student's last name: ");
                    String last = command32.nextLine();
                    Scanner command33 = new Scanner(System.in);
                    // updated info
                    System.out.print("Enter your student's updated name: ");
                    String name = command33.nextLine();
                    System.out.print("Enter your student's updated GPA: ");
                    double gpa = command33.nextDouble();
                    int number = 0;
                    if(studList.editStudentList(number, last, name, gpa) == true) {
                        // confirms edit
                        System.out.println("Your student has been edited!");
                    } else {
                        // if student wasn't found
                        System.out.println("Sorry, this student was not in the list.");
                    }
                } else {
                    invalid();
                }
                System.out.println();
            } else if (command == 4) {
                // calls the clear list method
                studList.clearList();
                // confirmation
                System.out.println("Your list of students has been cleared.");
                System.out.println();
            } else if (command == 5) {
                // prints list of students
                System.out.println("Your list of students is as follows:");
                studList.printStudentList();
                System.out.println();
            } else if (command == 6) {
                // searches for a student
                Scanner command6 = new Scanner(System.in);
                // options
                System.out.println("Would you like to search for your student:");
                System.out.println("  - by student number (press 1), or");
                System.out.println("  - by last name (press 2)?");
                int choice = command6.nextInt();
                if (choice == 1) {
                    // by student number
                    Scanner command61 = new Scanner(System.in);
                    System.out.print("Enter your student's student number: ");
                    int number = command61.nextInt();
                    if(countDigits(number) == 6) {
                        // ensures input is valid
                        Student printed = studList.printStudent(number, "");
                        if(printed != null) {
                            // prints student
                            System.out.println("Your student is as follows. Name: " + printed.getStudentName() + ", Student Number: " + printed.getStuNumber() + ", GPA: " + printed.getGPA());
                        } else {
                            // if student wasn't found
                            System.out.println("Sorry, this student was not in the list.");
                        }
                    } else {
                        invalid();
                    }
                } else if (choice == 2) {
                    // search by name
                    Scanner command62 = new Scanner(System.in);
                    System.out.print("Enter your student's last name: ");
                    String last = command62.nextLine();
                    Student printed = studList.printStudent(0, last);
                    if(printed != null) {
                        // prints student
                        System.out.println("Your student is as follows. Name: " + printed.getStudentName() + ", Student Number: " + printed.getStuNumber() + ", GPA: " + printed.getGPA());
                    } else {
                        // if student wasn't found
                        System.out.println("Sorry, this student was not in the list.");
                    }
                } else {
                    invalid();
                }
                System.out.println();
            } else if (command == 7) {
                // searches for a student given criteria
                Scanner command7 = new Scanner(System.in);
                // options
                System.out.println("Would you like to filter:");
                System.out.println("  - by student number (press 1), or");
                System.out.println("  - by GPA (press 2)?");
                int choice = command7.nextInt();
                if (choice == 1) {
                    // by student number
                    Scanner command71 = new Scanner(System.in);
                    System.out.print("Enter the benchmark student number: ");
                    int number = command71.nextInt();
                    if(countDigits(number) == 6) {
                        studList.filterSearchStudentList(0, number);
                    } else {
                        invalid();
                    }
                } else if (choice == 2) {
                    // by GPA
                    Scanner command72 = new Scanner(System.in);
                    System.out.print("Enter the benchmark GPA: ");
                    double number = command72.nextDouble();
                    studList.filterSearchStudentList(number, 0);
                } else {
                    invalid();
                }
                System.out.println();
            } else if(command == 8) {
                studList.callMergeSort(); // calls the mergeSort method
                System.out.println();
            } else if(command == 9) {
                Scanner command9 = new Scanner(System.in);
                System.out.print("What student number would you like to search for? ");
                int number = command9.nextInt();
                studList.callBinarySearch(number); // calls the binarySort method
                System.out.println();
            } else {
                invalid();
            }
            if(command != 10) {
                // clears the screen after each command
                Scanner clear = new Scanner(System.in);
                System.out.println("Press any key to clear the screen and continue!");
                String clearScreen = clear.nextLine();
                // clearing screen command
                System.out.print('\u000C');
            } else {
                // when the program ends
                System.out.println("Thanks for using StudentList!");
            }
        }
    }
    
    public static int menuNumber() {
        // prints this every time (menu)
        Scanner takeCommand = new Scanner(System.in);
        System.out.println("What would you like to do? Choose a command:");
        System.out.println("  - Add a student (1)");
        System.out.println("  - Delete a student (2)");
        System.out.println("  - Edit a student's information (3)");
        System.out.println("  - Clear the list of students (4)");
        System.out.println("  - Print the list of students (5)");
        System.out.println("  - Print a student's information (6)");
        System.out.println("  - Do a filtered student search (7)");
        System.out.println("  - Merge sort your list by student number (8)");
        System.out.println("  - Binary search for a student by student number (9)");
        System.out.println("  - End the program (10)");
        System.out.println();
        // takes user's command
        int input = takeCommand.nextInt();
        return input;
    }
    
    public static int countDigits(int input) {
        // method to determine how many digits are in the input (helpful for determining validity of student number input)
        int number = input;
        int count = 0;
        while(number > 0){
            number = number / 10;
            count += 1;
        }
        return count;
    }
    
    public static void invalid() {
        // if an invalid input is entered
        System.out.println("Sorry, that was an invalid input. Please try again.");
    }
}