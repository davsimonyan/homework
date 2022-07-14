package homework.student.command;

public interface Commands {

    int LOGOUT = 0;
    int ADD_STUDENTS = 1;
    int ADD_PRINT_ALL_STUDENTS = 2;
    int DELETE_STUDENT_BY_INDEX = 3;
    int PRINT_STUDENT_BY_INDEX = 4;
    int PRINT_STUDENT_COUNT = 5;
    int CHANGE_STUDENT_LESSON = 6;
    int ADD_LESSON = 7;
    int PRINT_ALL_LESSON = 8;

    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;

    static void printAdminCommands() {
        System.out.println("please input " + LOGOUT + " for logout");
        System.out.println("please input " + ADD_STUDENTS + " for add student");
        System.out.println("please input " + ADD_PRINT_ALL_STUDENTS + " for print all student");
        System.out.println("please input " + DELETE_STUDENT_BY_INDEX + " for delete student by index");
        System.out.println("please input " + PRINT_STUDENT_BY_INDEX + " for print student by lesson");
        System.out.println("please input " + PRINT_STUDENT_COUNT + " for print students count");
        System.out.println("please choose " + CHANGE_STUDENT_LESSON + " for change student's lesson");
        System.out.println("please choose " + ADD_LESSON + " for add lesson");
        System.out.println("please choose " + PRINT_ALL_LESSON + " for print all lesson");
    }

    static void printLoginCommands() {
        System.out.println("please input " + EXIT + " exit");
        System.out.println("please input " + LOGIN + " for login");
        System.out.println("please input " + REGISTER + " for register");
    }
    static void printUserCommands() {
        System.out.println("please input " + LOGOUT + " for logout");
        System.out.println("please input " + ADD_STUDENTS + " for add student");
        System.out.println("please input " + ADD_PRINT_ALL_STUDENTS + " for print all student");
        System.out.println("please input " + PRINT_STUDENT_COUNT + " for print students count");
        System.out.println("please choose " + CHANGE_STUDENT_LESSON + " for change student's lesson");
        System.out.println("please choose " + PRINT_ALL_LESSON + " for print all lesson");
    }
}
