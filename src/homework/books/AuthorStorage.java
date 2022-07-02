package homework.books;

import homework.student.model.Lesson;
import homework.student.model.Student;

public class AuthorStorage {

    private static Author author = new Author();

    private Author[] array = new Author[10];
    private int size = -1;


    public void add(Author author) {
        if (size == array.length) {
            extend();
        }
        array[++size] = author;
    }


    public void print() {
        for (int i = 0; i < size + 1; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }


    private void extend() {
        if (size == array.length) {
            Author[] temp = new Author[array.length + 10];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }

    public Author getAuthorByIndex(int indexName) {
        if (indexName < 0 || indexName >= size) {
            return null;
        }
        return array[indexName];
    }

    public int getSize() {
        return size + 1;
    }


}
