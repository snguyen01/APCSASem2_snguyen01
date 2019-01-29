import java.util.ArrayList;
/**
 * Write a description of class StudList here.
 *
 * @author (Steven Nguyen)
 * @version (125)
 */
public class StudList{
    ArrayList<Student> studList = new ArrayList<Student>(); // creates new student array list

    public void addStudentToList(String name, int number, double gpa) {
        // initializes new student and adds it to the list
        Student s = new Student();
        parseUserInput(s, name);
        s.setStuNumber(number);
        s.setGPA(gpa);
        studList.add(s);
    }

    public boolean deleteStudentFromList(String last){
        boolean deleted = false; // if the student has been deleted
        for(int i = 0; i < studList.size(); i++) { // runs through the list
            if(studList.get(i).getLastName().equals(last)) { // sees if the element has a matching last name
                studList.remove(i); // removes the student
                deleted = true; // indicates it's been removed
            }
        }
        return deleted;
    }

    public boolean editStudentList(int number, String last, String name, double gpa) {
        boolean edited = false; // if the student has been edited
        if(number != 0) {
            for(int i = 0; i < studList.size(); i++) { // runs through the list
                if(studList.get(i).getStuNumber() == number) { // sees if the element has a matching student number
                    // if so, updates student information
                    Student student = new Student();
                    parseUserInput(student, name);
                    student.setStuNumber(number);
                    student.setGPA(gpa);
                    studList.set(i, student);
                    edited = true; // indicates it's been edited
                }
            }
        } else {
            for(int i = 0; i < studList.size(); i++) { // runs through the list
                if(studList.get(i).getLastName().equals(last)) { // sees if the element has a matching last name
                    // if so, updates student information
                    Student student = new Student();
                    parseUserInput(student, name);
                    student.setStuNumber(studList.get(i).getStuNumber());
                    student.setGPA(gpa);
                    studList.set(i, student);
                    edited = true; // indicates it's been edited
                }
            }
        }
        return edited;
    }

    public void clearList() {
        studList.clear(); // simple array list method; removes all students
    }

    public void printStudentList() {
        if(studList.size() > 0) {
            for(int i = 0; i < studList.size(); i++) { // runs through the list
                // prints the info of each student
                System.out.println(i+1 + ". Name: " + studList.get(i).getStudentName() + ", Student Number: " + studList.get(i).getStuNumber() + ", GPA: " + studList.get(i).getGPA());
            }
        } else {
            System.out.println("There are no students in your list!"); // if the list is empty
        }
    }

    public Student printStudent(int number, String last) {
        for(int i = 0; i < studList.size(); i++) { // runs through the list
            if(number != 0) {
                if(studList.get(i).getStuNumber() == number) { // sees if the element has a matching student number
                    // if so, returns the student at that element
                    return studList.get(i);
                }
            } else {
                if(studList.get(i).getLastName().equals(last)) { // sees if the element has a matching last name
                    // if so, returns the student at that element
                    return studList.get(i);
                }
            }
        }
        return null; // if the student doesn't exist
    }

    public void parseUserInput(Student s, String name) {
        // instance variables to make things shorter 
        int comma = name.indexOf(",");
        int space = name.indexOf(" ");
        if(comma != -1 && findSpace(name) == 2) { // in the format of last, first middle
            // set the name using substrings
            s.setFirstName(name.substring(comma + 2, name.indexOf(" ", comma + 2)));
            s.setMiddleName(name.substring(name.indexOf(" ", comma + 2) + 1));
            s.setLastName(name.substring(0, comma));
        } else if(comma == -1 && (findSpace(name) == 2)) { // in the format of first middle last
            // set the name using substrings
            s.setFirstName(name.substring(0, space));
            s.setMiddleName(name.substring(space + 1, name.indexOf(" ", space + 1)));
            s.setLastName(name.substring(name.indexOf(" ", space + 1) + 1));
        } else if(comma == -1) { // in the format of first last
            // set the name using substrings
            s.setFirstName(name.substring(0, space));
            s.setMiddleName("");
            s.setLastName(name.substring(name.indexOf(" ") + 1));
        }
    }

    public int findSpace(String name) {
        String editName = name.toLowerCase().trim(); // removes unnecessary spaces
        int count = 0; // how many times a space has appeared
        for(int i = 0; i < editName.length() - 1; i++) { // runs through list
            if(editName.substring(i, i + 1).equals(" ")) {
                count++; // adds one to the count each time a space appeared
            }
        }
        if(editName.substring(editName.length() - 1).equals(editName)) {
            count++; // final index
        }
        return count;
    }

    public void filterSearchStudentList(double minGPA, int minStuNum) {
        ArrayList<Student> filteredList = new ArrayList<Student>(); // creates new student array list
        for(int i = 0; i < studList.size(); i++) { // runs through the list
            if(minGPA != 0) {
                if(studList.get(i).getGPA() <= minGPA) { // sees if the element's GPA is less than or equal to the specified number
                    // if so, add that student to the list
                    filteredList.add(studList.get(i));
                }
            } else {
                if(studList.get(i).getStuNumber() <= minStuNum) { // sees if the element's student number is less than or equal to the specified number
                    // if so, add that student to the list
                    filteredList.add(studList.get(i));
                }
            }
        }
        if(filteredList.size() > 0) {
            // prints the info of each student
            if(minGPA!= 0) {
                System.out.println("Your list of students with a GPA less than or equal to " + minGPA + " are:");
            } else {
                System.out.println("Your list of students with a student number less than or equal to " + minStuNum + " are:");
            }
            for(int i = 0; i < filteredList.size(); i++) { // runs through the list
                System.out.println(i+1 + ". Name: " + filteredList.get(i).getStudentName() + ", Student Number: " + filteredList.get(i).getStuNumber() + ", GPA: " + filteredList.get(i).getGPA());
            }
        } else {
            // if no students fit the criteria
            System.out.println("Sorry, no such student exists.");
        }
    }

    public void callMergeSort() {
        if(studList.size() == 0) {
            System.out.print("Your list has no students in it!");
        } else {
            mergeSort(studList, studList.size());
            System.out.println("Here are your students, sorted by student number: ");
            printStudentList();
        }
    }

    public void mergeSort(ArrayList<Student> a, int n){ // uses merge sort
        if (n < 2){
            return;
        } // base case
        int mid = n/2;
        ArrayList<Student> l = new ArrayList<Student>(); // one half of array
        ArrayList<Student> r = new ArrayList<Student>(); // other half of array
        for(int i = 0; i < mid; i++){
            l.add(a.get(i)); // initializes array
        }
        for(int i = mid; i < n; i++){
            r.add(a.get(i)); // initializes array
        }

        // recursive part
        mergeSort(l, mid);
        mergeSort(r, n - mid);
        // to merge the smaller arrays
        merge(a, l, r, mid, n - mid);
    }

    public void merge(ArrayList<Student> a, ArrayList<Student> l, ArrayList<Student> r, int left, int right){
        // merge method for merge sort
        // instance variables to keep track of index within array
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left && j < right){
            // runs through array until reaching the end (middle)
            if(l.get(i).getStuNumber() <= r.get(j).getStuNumber()){
                a.set(k++, l.get(i++)); // adds the left value to the array
            } else {
                a.set(k++, r.get(j++)); // adds the right value to the array
            }
        }
        while(i < left) {
            a.set(k++, l.get(i++)); // incrementation
        }
        while(j < right) {
            a.set(k++, r.get(j++)); // incrementation
        }
    }

    public void callBinarySearch(int n) {
        if(studList.size() == 0) {
            System.out.print("Your list has no students in it!");
        } else {
            mergeSort(studList, studList.size());
            binarySearch(studList, n, 0, studList.size());
        }
    }

    public void binarySearch(ArrayList<Student> a, int n, int start, int end) {
        int index = (end-start)/2;
        if(a.get(index).getStuNumber() == n){
            System.out.println();
            System.out.println("The student number " + n + " corresponds to the following student:");
            System.out.println("Name: " + studList.get(index).getStudentName() + ", Student Number: " + n + ", GPA: " + studList.get(index).getGPA());
            return;
        }
        if(a.get(index).getStuNumber() < n){
            binarySearch(a, n, index, end);
        } else {
            binarySearch(a, n, 0, index);
        }
    }
}