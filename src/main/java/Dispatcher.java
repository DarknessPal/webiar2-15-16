import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.*;

public class Dispatcher {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();
        boolean isStudyYearEnds = false;
        Group firstGroup = new Group();
        for (int i = 0; i < firstGroup.groupSize; i++) {
            firstGroup.students.add(new Student(faker));
        }
        for (int studentIndex = 0; studentIndex < firstGroup.groupSize; studentIndex++) {
            int marksCount = random.nextInt(12);
            for (int markIndex = 0; markIndex < marksCount; markIndex++) {
                firstGroup.getStudent(studentIndex).setMark(markIndex, random.nextInt(12));
            }
        }
        isStudyYearEnds = true;
        Group finalFirstGroup = null;
        if (isStudyYearEnds) {
            finalFirstGroup = StudyController.endsStudyYear(firstGroup);
            firstGroup = null;
        }
        System.out.println(finalFirstGroup.students);
    }
    static class Group {
        Random random = new Random();
        int groupSize;
        List<Student> students;
        Group() {
            this.groupSize = random.nextInt(30);
            this.students = new ArrayList<>();
        }
        public Student getStudent(int studentIndex) {
            return students.get(studentIndex);
        }
    }
    static class Student {
        String name;
        ArrayList<Integer> marks;
        Student(Faker faker) {
            this.name = faker.name().fullName();
            this.marks = new ArrayList<>();
        }
        @Override
        public String toString() {
            return name;
        }
        public void setMark(int markIndex, int mark) {
            this.marks.add(markIndex, mark);
        }
    }
    static class StudyController {
        public static Group endsStudyYear(Group g) {
            final Group firstGroup = g;
            firstGroup.students = Collections.unmodifiableList(firstGroup.students);
            return firstGroup;
        }
    }
}