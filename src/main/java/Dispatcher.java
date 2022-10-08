import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Dispatcher {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Group firstGroup = new Group();
        for (int i = 0; i < firstGroup.groupSize; i++){
            firstGroup.students.add(new Student(faker));
 //           System.out.println(name);
        }
        for (int i = 0; i < firstGroup.groupSize; i++) {
            System.out.println(firstGroup.students.get(i));
        }
//        System.out.println("//////");
        for (int studentIndex = 0; studentIndex < firstGroup.groupSize; studentIndex++){
 //           for (int markIndex = 0; markIndex < firstGroup.students(studentIndex).marks; markIndex++) {
                String temp = String.valueOf(firstGroup.students.get(studentIndex));
//            System.out.println(temp);
/*                Random random = new Random();
                firstGroup.getStudent(studentIndex).setMark(markID, random.integer());
                int studentMark = random.nextInt(12);
                System.out.print(studentMark + " ");*/
 //               firstGroup.students[markIndex].marks[markIndex] = studentMark;
//            }
        }

//        List<Student> firstGroupStudents = (List<Student>) Collections.unmodifiableList(firstGroup.students);
    }

    static class Group {
        Random random = new Random();
        int groupSize;
        ArrayList <Student> students;

        Group() {
            this.groupSize = random.nextInt( 30);
            this.students = new ArrayList<Student> ();
        }

        public Object getStudent(int studentIndex) {
            return students.get(studentIndex);
        }
    }

    static class Student {
        Random random = new Random();
        static String name;
        int marksCount;
 //       int marks [];
        ArrayList <Integer> marks;

        Student(Faker faker) {
            this.name = faker.name().fullName();
//            this.name = name;
            this.marksCount = random.nextInt( 12);
//            this.marks = new int [marksCount];
            this.marks = new ArrayList <Integer> ();
        }
        @Override
        public String toString(){
            return Student.name;
        }
    }
}