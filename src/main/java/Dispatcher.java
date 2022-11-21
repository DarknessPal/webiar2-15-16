import com.github.javafaker.Faker;

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
            }
        }
        ///////////// Break Test ///////////////////
        Student temp1 = finalFirstGroup.students.get(0);
        temp1.setName("You failed");
 //       temp1.marks = finalFirstGroup.students.setMark(1, 1);
        System.out.println("Closed group students' list");
        System.out.println(finalFirstGroup.students);

        //////// Set a new mark ////////
//        finalFirstGroup.getStudent(0).setMark(0, 0);
//        System.out.println(finalFirstGroup.getStudent(0).marks);
        ///////////// End of Break Test /////////////////
    }
}