package altonassignment4;
import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {
    
    public int compare(Student s1, Student s2) {
        return Integer.compare(s2.getGrade(), s1.getGrade()); // Descending order
    }
}
