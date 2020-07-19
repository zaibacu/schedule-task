package lt.sda.models;

import java.util.*;
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

    public boolean cleanup(){
        return studentList.removeIf(s -> s.getAge() <= 20);
    }

    public void addStudent(Student student) throws MaximumNumberOfStudentsReached{
        if(studentList.size() == STUDENTS_LIMIT)
            throw new MaximumNumberOfStudentsReached();
        if(trainer != null){
            student.setTrainer(trainer);
            trainer.addStudent(student);
        }
        this.studentList.add(student);
    }

    public Set<Student> getStudentList(){
        return Collections.unmodifiableSet(studentList);
    }

    public List<Student> getStudentListSorted(){
        return studentList
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public long getStudentCountWithoutPriorKnowledge(){
        return studentList
                    .stream()
                    .filter(s -> !s.hasPriorKnowledge())
                    .count();
    }

    public int getStudentCount(){
        return studentList.size();
    }

    @Override
    public String toString(){
        return String.format(
                "<Group name: %s studentCount: %d studentsWithoutPreviousJavaKnowledge: %d>",
                name, getStudentCount(), getStudentCountWithoutPriorKnowledge()
        );
    }
}
