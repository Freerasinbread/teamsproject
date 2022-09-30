import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String name;
    private int gradeLevel;
    private ArrayList<Course> classes;
    private String favoriteTeacher;

    public Student(String name, int gradeLevel, ArrayList<Course> classes, String favoriteTeacher) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.classes = classes;
        this.favoriteTeacher = favoriteTeacher;
    }

    public String getName() {
        return name;
    }
    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double calculateGPA() {

    }

    public Course getBestClass() {

    }

    public void addCourse(Course class) {

    }

    public boolean removeCourse(Course class) {
        
    }
}
