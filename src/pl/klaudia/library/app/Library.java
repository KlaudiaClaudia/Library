package pl.klaudia.library.app;

import pl.klaudia.library.model.Book;

public class Library {
    public static void main(String[] args) {

        Book book = new Book("HP","SW",2007,500,"Greg","987654");
        Book book1 = new Book("GH","SW",2007,500,"Greg");

        book.printInfo();
        book1.printInfo();

    }
}
