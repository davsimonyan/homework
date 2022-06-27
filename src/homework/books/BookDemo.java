package homework.books;

import java.util.Scanner;

public class BookDemo implements Commands {
    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();

    public static void main(String[] args) {
        bookStorage.add(new Book("Vardananq", "Derenik Demirjyan", 450, 6, "history"));
        bookStorage.add(new Book("Samvel", "Raffi", 400, 4, "history"));
        bookStorage.add(new Book("Romeo & Juliet", "William Shakespeare", 750.50, 5, "drama"));

        boolean run = true;
        while (run) {
            System.out.println("please input " + EXIT + " for exit");
            System.out.println("please input " + ADD_BOOK + " for add book");
            System.out.println("please input " + ADD_PRINT_ALL_BOOKS + " for print all books");
            System.out.println("please input " + ADD_PRINT_BOOKS_AUTHOR_NAME + " for print Books by AuthorName");
            System.out.println("please input " + ADD_PRINT_BOOKS_BY_GENRE + " for print Books by Genre");
            System.out.println("please input " + ADD_PRINT_BOOKS_BY_PRICE_RANGE + " for print books by price range");
            System.out.println("please input " + PRINT_ARRAY + " for print array");

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
}
