package homework.student.storage;

import homework.student.model.Student;
import homework.student.model.User;

import java.util.Scanner;

public class UserStorage {
    private static Scanner scanner = new Scanner(System.in);

    private User[] array = new User[10];
    private int size = -1;


    public void add(User user) {
        if (size == array.length) {
            extend();
        }
        array[++size] = user;
    }


    public void print() {
        for (int i = 0; i < size + 1; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }


    private void extend() {
        if (size == array.length) {
            User[] temp = new User[array.length + 10];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }

    public void delete(int index) {
        if (index < 0 || index > size) {
            System.out.println("invalid index");
        } else {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }


    public int getSize() {
        return size + 1;
    }

    public User getStudentByIndex(int indexName) {
        if (indexName < 0 || indexName >= size) {
            return null;
        }
        return array[indexName];
    }

    public User getUserByEmail(String email) {
        for (int i = 0; i <= size; i++) {
            return array[i];

        }
        return null;
    }
}


