package pl.klaudia.library.app;

import pl.klaudia.library.model.Book;

public class Library {
    public static void main(String[] args) {

        Book[] books = new Book[1000];

       books[0] = new Book("HP","SW",2007,500,"Greg","987654");
       books[1] = new Book("GH","SW",2007,500,"Greg");

        books[0].printInfo();
        books[1].printInfo();

    }
}
