package pl.klaudia.library.model;

public class Library {

    private final int maxBooks = 100;
    private Book[] books = new Book[maxBooks];
    private int booksNumber;

    public void addBook(Book book){
        if (booksNumber < maxBooks){
            books[booksNumber] = book;
            booksNumber ++;
        }else {
            System.out.println("The maximum number of books has been reached");
        }
    }
    public void printBooks(){
        if (booksNumber== 0){
            System.out.println("No books in the library");
        }
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();

        }
    }

}
