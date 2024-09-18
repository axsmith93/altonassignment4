package altonassignment4;

public class Student { //sets properties 
    private String studentID;
    private String studentName;
    private String course;
    private int grade;  

    public Student(String studentID, String studentName, String course, int grade) { // initializes values
        this.studentID = studentID;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;
    }
    
    @Override
    public String toString () {
    	return studentID + "," + studentName + "," + course + "," + grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }
}