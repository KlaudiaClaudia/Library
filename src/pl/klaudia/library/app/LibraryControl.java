package pl.klaudia.library.app;

import pl.klaudia.library.io.DataReader;
import pl.klaudia.library.model.Book;
import pl.klaudia.library.model.Library;

public class LibraryControl {
    private final int exit = 0;
    private final int addBook = 1;
    private final int printBooks = 2;

    private DataReader dataReader = new DataReader();

    private Library library = new Library();

    public void controlLoop() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case addBook:
                    addBook();
                    break;
                case printBooks:
                    printBooks();
                    break;
                case exit:
                    exit();
                    break;
                default:
                    System.out.println("There is no such option, please re-enter: ");
            }
        } while (option != exit);
    }

    private void printOptions() {
        System.out.println("Select an option: ");
        System.out.println(exit + " - exit the program");
        System.out.println(addBook + " - add new book");
        System.out.println(printBooks + " - view available books");
    }
    private void addBook(){
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }
    private void printBooks(){
        library.printBooks();
    }
    private void exit(){
        System.out.println("End of program.");
        dataReader.close();
    }

}
