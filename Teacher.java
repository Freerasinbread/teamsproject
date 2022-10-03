import java.io.Serializable;
import java.util.ArrayList;

public class Teacher implements Serializable {
    private String name;
    private int yearsExperience;

    public Teacher(String name, int yearsExperience) {
        this.name = name;
        this.yearsExperience = yearsExperience;
    }

    public String getName() {
        return name;
    }
    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }
}
