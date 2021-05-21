package pl.klaudia.library.app;

import pl.klaudia.library.io.DataReader;
import pl.klaudia.library.model.Book;
import pl.klaudia.library.model.Library;
import pl.klaudia.library.model.Magazine;

public class LibraryControl {

    private DataReader dataReader = new DataReader();

    private Library library = new Library();

    void controlLoop() {
        Option option;

        do {
            printOptions();
            option = Option.createFromInt(dataReader.getInt());
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
        } while (option != Option.EXIT);
    }

    private void printOptions() {
        System.out.println("Select option: ");
        for (Option option: Option.values()) {
            System.out.println(option);
        }
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
