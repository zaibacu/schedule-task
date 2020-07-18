package lt.sda.models;

import java.time.LocalDate;

public class Student extends Person {
    private Trainer trainer;
    private final boolean hasPriorKnowledge;

    public Student(String firstName, String lastName, LocalDate dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
        this.hasPriorKnowledge = false;
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, boolean hasPriorKnowledge) {
        super(firstName, lastName, dateOfBirth);
        this.hasPriorKnowledge = hasPriorKnowledge;
    }

    public Student(String firstName, String lastName, String dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
        this.hasPriorKnowledge = false;
    }

    public Student(String firstName, String lastName, String dateOfBirth, boolean hasPriorKnowledge) {
        super(firstName, lastName, dateOfBirth);
        this.hasPriorKnowledge = hasPriorKnowledge;
    }

    public boolean hasPriorKnowledge(){
        return hasPriorKnowledge;
    }

    public Trainer getTrainer(){
        return trainer;
    }

    public void setTrainer(Trainer trainer){
        this.trainer = trainer;
    }
}
