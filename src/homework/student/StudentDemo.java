package homework.student;

import java.util.Scanner;

public class StudentDemo {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentStorage studentStorage = new StudentStorage();

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("please input 0 exit");
            System.out.println("please input 1 for add student");
            System.out.println("please input 2 for print all student");
            System.out.println("please input 3 for delete student by index");
            System.out.println("please input 4 for print student by lesson");
            System.out.println("please input 5 for print students count");
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 0:
                    run = false;
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentStorage.print();
                    break;
                case 3:
                    studentStorage.print();
                    System.out.println("please choose student index");
                    int index = Integer.parseInt(scanner.nextLine());
                    studentStorage.delete(index);
                    break;
                case 4:
                    System.out.println("please imput lesson name");
                    String lessonName = scanner.nextLine();
                    studentStorage.printStudentByLessonName(lessonName);
                    break;
                case 5:
                    System.out.println("students count:");
                    System.out.println(studentStorage.getSize());
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }


    }

    private static void addStudent() {
        System.out.println("Please inout student's name");
        String name = scanner.nextLine();
        System.out.println("Please inout student's surname");
        String surname = scanner.nextLine();
        System.out.println("Please inout student's age");
        String ageStr = scanner.nextLine();
        System.out.println("Please inout student's phoneNumber");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please inout student's city");
        String city = scanner.nextLine();
        System.out.println("Please inout student's lesson");
        String lesson = scanner.nextLine();


        int age = Integer.parseInt(ageStr);

        Student student = new Student(name, surname, age, phoneNumber, city, lesson);
        studentStorage.add(student);
        System.out.println("student created");

    }
}
