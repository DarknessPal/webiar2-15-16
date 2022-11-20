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
        System.out.println("Students' list");
        System.out.println(firstGroup.students);
 //       System.out.println("Marks");
        for (int studentIndex = 0; studentIndex < firstGroup.groupSize; studentIndex++) {
            int marksCount = random.nextInt(12);
 //           System.out.println(firstGroup.getStudent(studentIndex));
            for (int markIndex = 0; markIndex < marksCount; markIndex++) {
                firstGroup.getStudent(studentIndex).setMark(markIndex, random.nextInt(12));
            }
 //           System.out.println(firstGroup.getStudent(studentIndex).marks);
        }
        isStudyYearEnds = true;
        Group finalFirstGroup = null;
        if (isStudyYearEnds) {
            finalFirstGroup = StudyController.endsStudyYear(firstGroup);
            for (int studentIndex = 0; studentIndex < firstGroup.groupSize; studentIndex++) {
                finalFirstGroup.getStudent(studentIndex).isFinished = true;
                finalFirstGroup.getStudent(studentIndex).closeMark();
                finalFirstGroup.getStudent(studentIndex).init();
            }
        }
        ///////////// Break Test ///////////////////
        Student temp1 = finalFirstGroup.students.get(0);
        temp1.name = "You failed";
 //       temp1.marks = finalFirstGroup.students.setMark(1, 1);
        System.out.println("Closed group students' list");
        System.out.println(finalFirstGroup.students);

        //////// Set a new mark ////////
//        finalFirstGroup.getStudent(0).setMark(0, 0);
//        System.out.println(finalFirstGroup.getStudent(0).marks);
        ///////////// End of Break Test /////////////////
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
        private String name;
        private final String finalName = init();;
        boolean isFinished = false;
        List<Integer> marks;
        Student(Faker faker) {
            this.name = faker.name().fullName();
            this.marks = new ArrayList<>();
        }
        String init() {
            System.out.println(this.name);
            return this.name;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            if (!isFinished) {
                this.name = name;
            } else{
                this.name = null;
                System.out.println("Can't set name in final group");
            }
        }
        @Override
        public String toString() {
            return name;
        }
        public void setMark(int markIndex, int mark) {
            this.marks.add(markIndex, mark);
        }
        public void closeMark() {
            this.marks = Collections.unmodifiableList(marks);
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