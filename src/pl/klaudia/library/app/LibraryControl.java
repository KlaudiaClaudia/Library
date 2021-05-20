package pl.klaudia.library.app;

import pl.klaudia.library.io.DataReader;
import pl.klaudia.library.model.Book;
import pl.klaudia.library.model.Library;
import pl.klaudia.library.model.Magazine;

public class LibraryControl {
    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int ADD_MAGAZINE = 2;
    private static final int PRINT_BOOKS = 3;
    private static final int PRINT_MAGAZINES = 4;

    private DataReader dataReader = new DataReader();

    private Library library = new Library();

    public void controlLoop() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("There is no such option, please re-enter: ");
            }
        } while (option != EXIT);
    }

    private void printOptions() {
        System.out.println("Select an option: ");
        System.out.println(EXIT + " - exit the program");
        System.out.println(ADD_BOOK + " - add new book");
        System.out.println(ADD_MAGAZINE + " - add new magazine");
        System.out.println(PRINT_BOOKS + " - view available books");
        System.out.println(PRINT_MAGAZINES + " - view available magazines");
    }
    private void addBook(){
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }
    private void printBooks(){
        library.printBooks();
    }
    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }
    private void printMagazines() {
        library.printMagazines();
    }
    private void exit(){
        System.out.println("End of program.");
        dataReader.close();
    }


}
