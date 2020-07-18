package lt.sda.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Group {
    private static final int STUDENTS_LIMIT = 5;
    private final String name;
    private Trainer trainer;
    private Set<Student> studentList = new HashSet<>();

    public Group(String name){
        this.name = name;
    }

    public void setTrainer(Trainer trainer){
        this.trainer = trainer;
    }

    public String getName(){
        return name;
    }

    public void addStudent(Student student) throws MaximumNumberOfStudentsReached{
        if(studentList.size() == STUDENTS_LIMIT)
            throw new MaximumNumberOfStudentsReached();
        student.setTrainer(trainer);
        trainer.addStudent(student);
        this.studentList.add(student);
    }

    public Set<Student> getStudentList(){
        return studentList;
    }

    public List<Student> getStudentListSorted(){
        return studentList
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
