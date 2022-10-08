import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.*;

public class Dispatcher {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();

        Group firstGroup = new Group();
        for (int i = 0; i < firstGroup.groupSize; i++){
            firstGroup.students.add(new Student(faker));
        }
 /*       for (int i = 0; i < firstGroup.groupSize; i++) {
            System.out.println(firstGroup.students.get(i));
        }*/
        for (int studentIndex = 0; studentIndex < firstGroup.groupSize; studentIndex++){
            String temp = String.valueOf(firstGroup.students.get(studentIndex));
            System.out.println(temp);
            int marksCount = random.nextInt(12);
            for (int markIndex = 0; markIndex < marksCount; markIndex++) {
            firstGroup.getStudent(studentIndex).setMark(markIndex, random.nextInt(12));
//                System.out.println(firstGroup.getStudent(studentIndex));
            }
        }
//        List<Student> firstGroupStudents = (List<Student>) Collections.unmodifiableList(firstGroup.students);
    }
     static class Group {
        Random random = new Random();
        int groupSize;
        ArrayList <Student> students;
        Group() {
            this.groupSize = random.nextInt( 30);
            this.students = new ArrayList<> ();
        }
        public Object getStudent(int studentIndex) {
            return students.get(studentIndex);
        }
    }
    static class Student{
        String name;
        ArrayList <Integer> marks;

        Student(Faker faker) {
            this.name = faker.name().fullName();
            this.marks = new ArrayList <> ();
        }
        @Override
        public String toString(){
            return name;
        }
        void setMark (int markIndex, int mark) {
            this.marks.add(markIndex, mark);
        }
    }
}