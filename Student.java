import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String name;
    private int gradeLevel;
    private ArrayList<Course> classes;

    public Student(String name, int gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        classes = new ArrayList<>();
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
        double GPA = 0;
        for (int i = 0 ; i < classes.size(); i++) {
            int grade = classes.get(i).getGrade();
            if (grade > 89) {
                GPA += 4;
            }
            else if (grade > 79) {
                GPA += 3;
            }
            else if (grade > 69) {
                GPA += 2;
            }
            else if (grade > 59) {
                GPA += 1;
            }
        }
        return GPA / classes.size();
    }

    public Course getBestClass() {
        int greatest = classes.get(0).getGrade();
        int bestClassIndex = -1;
        for (int i = 1 ; i < classes.size(); i++) {
            int grade = classes.get(i).getGrade();
            if (grade > greatest) {
                greatest = grade;
                bestClassIndex = i;
            }
        }
        return classes.get(bestClassIndex);
    }

    public void addCourse(Course class_) {
        classes.add(class_);
    }

    public boolean removeCourse(Course class_) {
        for (int i = 0 ; i < classes.size(); i++) {
            if (class_ == classes.get(i)) {
                classes.remove(i);
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Name: " + name + "\n Grade Level: " + gradeLevel + "\n GPA: " + calculateGPA();
    }
}
