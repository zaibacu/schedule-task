package lt.sda.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Trainer extends Person implements Authorizable {
    private Set<Student> students = new HashSet<>();

    public Trainer(String firstName, String lastName, LocalDate dateOfBirth){
        super(firstName, lastName, dateOfBirth);
    }

    public Trainer(String firstName, String lastName, String dateOfBirth){
        super(firstName, lastName, dateOfBirth);
    }

    @Override
    public boolean isAuthorized() {
        return true;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public Set<Student> getStudents(){
        return students;
    }
}
