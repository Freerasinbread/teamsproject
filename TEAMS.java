import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TEAMS{
    static ArrayList<Student> students;
    static ArrayList<Teacher> teachers;
    static ArrayList<Course> courses;

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        
        //Load the data if available ### DO NOT CHANGE THIS PART
        try {
            students = (ArrayList<Student>)loadData("students");
        }
        catch(Exception e){
            students = new ArrayList<>();
        }
        try {
            teachers = (ArrayList<Teacher>)loadData("teachers");
        }
        catch(Exception e){
            teachers = new ArrayList<>();
        }
        try {
            courses = (ArrayList<Course>)loadData("courses");
        }
        catch(Exception e){
            courses = new ArrayList<>();
        }


        //############## MAIN MENU STARTS HERE ##############
        int ans = -1;

        while(ans != 0){
            System.out.println("---------Menu---------");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Course");
            System.out.println("4. Edit Student");
            System.out.println("5. List Students");
            System.out.println("6. List Courses");
            System.out.println("7. Search for Student");
            System.out.println("0. Exit");
            ans = sc.nextInt();
            sc.nextLine();

            if (ans == 1) {
                System.out.println("Add Student");
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Grade Level: ");
                int gradeLevel = sc.nextInt();
                sc.nextLine();

                Student newStudent = new Student(name, gradeLevel);
                students.add(newStudent);
            }
            else if (ans == 2) {
                System.out.println("Add Teacher");
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Years of Experience: ");
                int yearsExperience = sc.nextInt();
                sc.nextLine();

                Teacher newTeacher = new Teacher(name, yearsExperience);
                teachers.add(newTeacher);
            }
            else if (ans == 3) {
                boolean current = false;

                System.out.println("Add Course");
                System.out.print("Subject: ");
                String subject = sc.nextLine();
                System.out.print("Teacher Name: ");
                String teacherName = sc.nextLine();
                System.out.print("Are Students Taking This Course: ");
                String strCurrent = sc.nextLine();

                if (strCurrent.toLowerCase() == "yes") {
                    current = true;
                }

                boolean a = false;
                for (int i = 0 ; i < teachers.size(); i++) {
                    if (teacherName == teachers.get(i).getName()) {
                        System.out.println("YAY");
                        Course newCourse = new Course(subject, teachers.get(i), current);
                        courses.add(newCourse);
                        a = true;
                    }

                    else {
                        System.out.println(teacherName.toUpperCase());
                        System.out.println(teachers.get(i).getName().toUpperCase());
                    }
                }

                if (!a) {
                    System.out.println("Failed");
                }
                else {
                    System.out.println("Successful");
                }
            }
            else if (ans == 4) {
                System.out.println("4. Edit Student");
            }
            else if (ans == 5) {
                System.out.println("5. List Students");
            }
            else if (ans == 6) {
                System.out.println("6. List Courses");
            }
            else if (ans == 7) {
                System.out.println("7. Search for Student");
            }
            else if (ans == 0) {
                System.out.println("0. Exit");
            }
            else {
                System.out.println("Invalid Option");
            }
        }
        

    }

    //#### DO NOT CHANGE THIS FUNCTION ####
    public static void saveData()throws Exception{
        FileOutputStream f1 = new FileOutputStream("students");
        ObjectOutputStream os = new ObjectOutputStream(f1);
        os.writeObject(students);
        os.close();
        f1.close();

        FileOutputStream f2 = new FileOutputStream("courses");
        os = new ObjectOutputStream(f2);
        os.writeObject(courses);
        os.close();
        f2.close();

        FileOutputStream f3 = new FileOutputStream("teachers");
        os = new ObjectOutputStream(f3);
        os.writeObject(teachers);
        os.close();
        f3.close();
    }

    //#### DO NOT CHANGE THIS FUNCTION ####
    public static Object loadData(String name) throws Exception{
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new  ObjectInputStream(fis);   
        Object o = ois.readObject();
        ois.close();
        fis.close();
        return o;
    }
}