package homework.student;

import homework.student.command.Commands;

import homework.student.model.Lesson;
import homework.student.model.Student;
import homework.student.model.User;
import homework.student.model.UserType;
import homework.student.storage.LessonStorage;
import homework.student.storage.StudentStorage;
import homework.student.storage.UserStorage;

import java.util.Scanner;

public class StudentDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentStorage studentStorage = new StudentStorage();
    private static LessonStorage lessonStorage = new LessonStorage();
    private static UserStorage userStorage = new UserStorage();

    public static void main(String[] args) {
        initData();

        boolean run = true;
        while (run) {
            Commands.printLoginCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.err.println("Invalid command");
            }
        }

    }

    private static void login() {
        System.out.println("Please input email,password");
        String emailPasswordStr = scanner.nextLine();
        String[] emailPassword = emailPasswordStr.split(",");
        User user = userStorage.getUserByEmail(emailPassword[0]);
        if (user == null) {
            System.out.println("User with " + emailPassword[0] + " does not exists!");
        } else {
            if (user.getPassword().equals(emailPassword[1])) {
                if (user.getUserType() == UserType.ADMIN) {
                    loginAdmin();
                } else  if ((user.getUserType() == UserType.USER)){
                    loginUser();
                }

            } else {
                System.out.println("Password is wrong!");
            }

        }
    }

    private static void loginUser() {
        boolean run = true;
        while (run) {
            Commands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_STUDENTS:
                    addStudent();
                    break;
                case ADD_PRINT_ALL_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENT_COUNT:
                    System.out.println("student count" + studentStorage.getSize());
                    break;
                case PRINT_ALL_LESSON:
                    lessonStorage.print();
                    break;


                default:
                    System.err.println("Invalid command");
            }
        }
    }

    private static void register() {
        System.out.println("please input name,surname,email,password");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        if (userData.length < 4) {
            System.out.println("Please input correct data!");
        } else {
            if (userStorage.getUserByEmail(userData[0]) == null) {
                User user = new User();
                user.setName(userData[0]);
                user.setSurname(userData[1]);
                user.setEmail(userData[2]);
                user.setPassword(userData[3]);
                user.setUserType(UserType.USER);
                userStorage.add(user);
                System.out.println("User created");
            } else {
                System.out.println("user with " + userData[0] + " already exists!");
            }
        }
    }

    private static void loginAdmin() {
        boolean run = true;
        while (run) {
            Commands.printAdminCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_STUDENTS:
                    addStudent();
                    break;
                case ADD_PRINT_ALL_STUDENTS:
                    studentStorage.print();
                    break;
                case DELETE_STUDENT_BY_INDEX:
                    deleteByIndex();
                    break;
                case PRINT_STUDENT_BY_INDEX:
                    printStudentByLessonName();
                    break;
                case PRINT_STUDENT_COUNT:
                    System.out.println("student count" + studentStorage.getSize());
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLessonName();
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case PRINT_ALL_LESSON:
                    lessonStorage.print();
                    break;


                default:
                    System.err.println("Invalid command");
            }
        }
    }

    private static void initData() {
        User user = new User("admin", "admin", "admin@gmail.com", "admin", UserType.ADMIN);
        Lesson java = new Lesson("java", "teacher", 5, 514);
        Lesson mysql = new Lesson("mysql", "teacher", 5, 514);
        Lesson php = new Lesson("php", "teacher", 5, 514);
        lessonStorage.add(java);
        lessonStorage.add(mysql);
        lessonStorage.add(php);
        studentStorage.add(new Student("Poxos", "Poxosyan", 19, "098765432", "Gyumri", java));
        studentStorage.add(new Student("Petros", "Petrosyan", 19, "098765432", "Gyumri", mysql));
        studentStorage.add(new Student("Martiros", "Martirosyan", 19, "098765432", "Gyumri", php));
    }

    private static void addLesson() {
        System.out.println("Please input lesson name");
        String lessonName = scanner.nextLine();
        System.out.println("Please input lesson teacherName");
        String teacherName = scanner.nextLine();
        System.out.println("Please input lesson duration by month");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input lesson price");
        double price = Double.parseDouble(scanner.nextLine());

        Lesson lesson = new Lesson(lessonName, teacherName, duration, price);
        lessonStorage.add(lesson);
        System.out.println("lesson created!");
    }

    private static void changeStudentLessonName() {
        studentStorage.print();
        System.out.println("please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        Student student = studentStorage.getStudentByIndex(index);
        if (student == null) {
            System.out.println("Wrong Index!!!");
            changeStudentLessonName();
        } else {
            if (lessonStorage.getSize() != 0) {
                lessonStorage.print();
                System.out.println("please choose lesson index");
                int lessonIndex = Integer.parseInt(scanner.nextLine());
                Lesson lesson = lessonStorage.getLessonByIndex(lessonIndex);
                if (lesson != null) {
                    student.setLesson(lesson);
                    System.out.println("lesson changed!");
                }
            }
        }
    }

    private static void printStudentByLessonName() {
        System.out.println("please input lesson name");
        String lessonName = scanner.nextLine();
        studentStorage.printStudentByLessonName(lessonName);
    }

    private static void deleteByIndex() {
        studentStorage.print();
        System.out.println("please choose student index");
        int index = Integer.parseInt(scanner.nextLine());
        studentStorage.delete(index);
    }

    private static void addStudent() {
        if (lessonStorage.getSize() != 0) {
            lessonStorage.print();
            System.out.println("please choose lesson index");
            int lessonIndex = Integer.parseInt(scanner.nextLine());
            Lesson lesson = lessonStorage.getLessonByIndex(lessonIndex);
            if (lesson == null) {
                System.out.println("Please choose correct index!!!");
                addStudent();
            } else {
                System.out.println("Please input student's name");
                String name = scanner.nextLine();
                System.out.println("Please input student's surname");
                String surname = scanner.nextLine();
                System.out.println("Please input student's phoneNumber");
                String phoneNumber = scanner.nextLine();
                System.out.println("Please input student's city");
                String city = scanner.nextLine();
                System.out.println("Please input student's age");
                int age = Integer.parseInt(scanner.nextLine());

                Student student = new Student(name, surname, age, phoneNumber, city, lesson);
                studentStorage.add(student);
                System.out.println("student created");
            }
        }


    }
}
