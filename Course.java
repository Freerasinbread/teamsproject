import java.io.Serializable;

public class Course implements Serializable, Cloneable {
    private String subject;
    private Teacher teacher;
    private int grade;
    private boolean current;
    
    public Course(String subject, Teacher teacher, int grade, boolean current) {
        this.subject = subject;
        this.teacher = teacher;
        this.grade = grade;
        this.current = current;
    }
    public Course(String subject, Teacher teacher, boolean current) {
        this.subject = subject;
        this.teacher = teacher;
        this.grade = -1;
        this.current = current;
    }

    public String getSubject() {
        return subject;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public int getGrade() {
        return grade;
    }
    public boolean getCurrent() {
        return current;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String toString() {
        if (grade == -1) {
            return "Subject by Teacher " + teacher.getName();
        }
        return "Subject by Teacher " + teacher.getName() + " Grade: " + grade;
    }

    public Course clone() {
        try {
            return (Course) super.clone();
        }
        catch (Exception e) {
        }
        return null;
    }
}
