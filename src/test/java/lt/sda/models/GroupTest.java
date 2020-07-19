package lt.sda.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupTest {
    @Test
    public void testDistinctStudent() throws MaximumNumberOfStudentsReached{
        Group group = new Group("Test group");

        Student student = new Student("Test", "Test", "2000-01-01");

        group.addStudent(student);
        assertEquals(1, group.getStudentList().size());

        group.addStudent(student);
        group.addStudent(student);
        assertEquals(1, group.getStudentList().size());
    }

    @Test
    public void testDistinctStudentCornerCase() throws MaximumNumberOfStudentsReached{
        Group group = new Group("Test group");

        Student s1 = new Student("Test", "Test", "2000-01-01");
        Student s2 = new Student("Test", "Test", "2000-01-01");

        group.addStudent(s1);
        assertEquals(1, group.getStudentList().size());

        group.addStudent(s2);
        group.addStudent(s2);
        assertEquals(1, group.getStudentList().size());
    }

    @Test(expected = MaximumNumberOfStudentsReached.class)
    public void testStudentsLimit() throws MaximumNumberOfStudentsReached{
        Group group = new Group("Test group");
        for(int i = 0; i<6; i++){
            Student s = new Student("Test" + i, "Test", "2000-01-01");
            group.addStudent(s);
        }

    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void testBreakTheSystem() throws MaximumNumberOfStudentsReached{
        Group group = new Group("Test group");
        for(int i = 0; i<5; i++){
            Student s = new Student("Test" + i, "Test", "2000-01-01");
            group.addStudent(s);
        }

        group.getStudentList().add(new Student("Hacker", "hacker1", "1900-01-01"));

        assertEquals(5, group.getStudentList().size());
    }
}
