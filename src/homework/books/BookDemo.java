package homework.books;

import homework.books.commands.Commands;
import homework.books.model.Author;
import homework.books.model.Book;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;

import java.util.Scanner;

public class BookDemo implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();
    private static Author author = new Author();

    public static void main(String[] args) {
        bookStorage.add(new Book("Vardananq", "Derenik Demirjyan", 450, 6, "history"));
        bookStorage.add(new Book("Samvel", "Raffi", 400, 4, "history"));
        bookStorage.add(new Book("Romeo & Juliet", "William Shakespeare", 750.50, 5, "drama"));

        authorStorage.add(new Author("Poxos", "Poxosyan", "poxos@mail.ru", "Male"));
        authorStorage.add(new Author("Martiros", "Martirosyan", "martiros@mail.ru", "Male"));
        authorStorage.add(new Author("Malena", "Maloyan", "malena@mail.ru", "Female"));
        boolean run = true;
        while (run) {
            Commands.printCommands();
            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_PRINT_ALL_BOOKS:
                    bookStorage.printBooks();
                    break;
                case ADD_PRINT_BOOKS_AUTHOR_NAME:
                    String authorName = scanner.nextLine();
                    bookStorage.PrintBooksByGenre(authorName);
                    break;
                case ADD_PRINT_BOOKS_BY_GENRE:
                    String genre = scanner.nextLine();
                    bookStorage.PrintBooksByPriceRange(genre);
                    break;
                case ADD_PRINT_BOOKS_BY_PRICE_RANGE:
                    String priceStr = scanner.nextLine();
                    String priceStr1 = scanner.nextLine();
                    int price = Integer.parseInt(priceStr);
                    int price1 = Integer.parseInt(priceStr1);
                    bookStorage.booksByPriceRange(price, price1);
                    break;
                case PRINT_ARRAY:
                    bookStorage.print();
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case PRINT_ARRAY_AUTHOR:
                    authorStorage.print();
                    break;
                default:
                    System.err.println("Invalid command");
            }
        }
    }

    private static void addBook() {
        System.out.println("Please input books title");
        String title = scanner.nextLine();
        System.out.println("Please input author name");
        String authorName = scanner.nextLine();
        System.out.println("Please input price ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input count");
        String countStr = scanner.nextLine();
        System.out.println("Please input genre");
        String genre = scanner.nextLine();

        int count = Integer.parseInt(countStr);
        Book book = new Book(title, authorName, price, count, genre);
        bookStorage.add(book);
    }


    private static void addAuthor() {
        System.out.println("Please input author name");
        String name = scanner.nextLine();
        System.out.println("Please input author surname");
        String surname = scanner.nextLine();
        System.out.println("Please input author email");
        String email = scanner.nextLine();
        System.out.println("Please input gender");
        String gender = genderAuthor();

        Author author = new Author(name, surname, email, gender);
        authorStorage.add(author);
    }

    private static String genderAuthor() {

        authorStorage.print();
        System.out.println("1 Male | 2 Female");
        int index = Integer.parseInt(scanner.nextLine());
        if (index != 1 && index != 2) {
            System.out.println("Invalid commands");
            genderAuthor();
        } else if (index == 1) {
            author.setGender("Male");
        } else {
            author.setGender("Female");
        }
        return author.getGender();
    }
}

