import lt.sda.models.Group;
import lt.sda.models.MaximumNumberOfStudentsReached;
import lt.sda.models.Student;
import lt.sda.models.Trainer;

import java.rmi.StubNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Trainer> trainerList = Arrays.asList(
                new Trainer("Trainer1", "TrainerA", "2002-01-01"),
                new Trainer("Trainer2", "TrainerB", "2003-01-01"),
                new Trainer("Trainer3", "TrainerC", "2004-01-01")
        );

        List<Group> groupList = Arrays.asList(
                new Group("Java01"),
                new Group("Java02"),
                new Group("Java03"),
                new Group("Java04")
        );
        Random rand = new Random();
        Stack<Student> students = new Stack<>();

        for(int i = 0; i<15; i++){
            String firstName = String.format("Student%d", i+1);
            String lastName = String.format("Student%c", (char)(65 + i));
            String birthDate = String.format("199%d-01-01", rand.nextInt(9));
            //LocalDate randomDate = LocalDate.of(1990 + rand.nextInt(9), 1, 1);
            students.add(new Student(firstName, lastName, birthDate, rand.nextBoolean()));
        }

        // Assign random trainer to each group
        for(Group g : groupList){
            // Trainer t = trainerList.get(rand.nextInt(trainerList.size()));
            Trainer t = Utils.getRandom(trainerList);
            g.setTrainer(t);
        }

        // Assign student to random group
        while(students.size() > 0){
            Student s = students.pop();
            Group g = Utils.getRandom(groupList);
            try{
                g.addStudent(s);
            }
            catch (MaximumNumberOfStudentsReached mex){
                students.push(s);
            }
        }

        // Print all student alphabetically
        for(Group g : groupList){
            System.out.println(g.getName());
            System.out.println("--------------------------");
            for(Student s : g.getStudentListSorted()){
                System.out.println(s);
            }
            System.out.println("--------------------------");
        }

        // Print group with most students
        Group withMostStudents = groupList
                .stream()
                .sorted((o1, o2) -> {
                    return Integer.compare(o2.getStudentList().size(), o1.getStudentList().size());
                })
                .findFirst()
                .get();

        System.out.printf("%s is with most students\n", withMostStudents.getName());

        // Print all students younger than 25
        Set<Student> youngStudents = groupList
                .stream()
                .map(g -> g.getStudentList())
                .flatMap(Collection::stream)
                .filter(s -> s.getAge() <= 25)
                .collect(Collectors.toSet());

        System.out.println("Young students");
        for(Student s : youngStudents){
            System.out.println(s);
        }

        // List all students under trainer
        for(Trainer t : trainerList){
            System.out.printf("Trainer: %s\n", t);
            for(Student s : t.getStudents()){
                System.out.println(s);
            }
        }
    }
}
