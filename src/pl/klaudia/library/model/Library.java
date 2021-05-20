package pl.klaudia.library.model;

public class Library {

    private static final int MAX_BOOKS = 100;
    private static final int MAX_MAGAZINES = 1000;
    private Book[] books = new Book[MAX_BOOKS];
    private Magazine[] magazines = new Magazine[MAX_MAGAZINES];
    private int booksNumber;
    private int magazinesNumber;

    public void addBook(Book book){
        if (booksNumber < MAX_BOOKS){
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
    public void addMagazine(Magazine magazine) {
        if(magazinesNumber < MAX_MAGAZINES) {
            magazines[magazinesNumber] = magazine;
            magazinesNumber++;
        } else {
            System.out.println("The maximum number of magazines has been reached");
        }

    }

    public void printMagazines() {
        if (magazinesNumber == 0) {
            System.out.println("No magazines in the library");
        }
        for (int i = 0; i < magazinesNumber; i++) {
            magazines[i].printInfo();
        }
    }

}
