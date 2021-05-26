package pl.klaudia.library.app;

import pl.klaudia.library.exception.DataExportException;
import pl.klaudia.library.exception.DataImportException;
import pl.klaudia.library.exception.NoSuchOptionException;
import pl.klaudia.library.io.ConsolePrinter;
import pl.klaudia.library.io.DataReader;
import pl.klaudia.library.io.file.FileManager;
import pl.klaudia.library.io.file.FileManagerBuilder;
import pl.klaudia.library.model.Book;
import pl.klaudia.library.model.Library;
import pl.klaudia.library.model.Magazine;
import pl.klaudia.library.model.Publication;
import pl.klaudia.library.model.comparator.AlphabeticalTitleComparator;

import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;

public class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileManager fileManager;

    private Library library;

    LibraryControl(){
        fileManager = new FileManagerBuilder(printer, dataReader).build();
        try {
            library = fileManager.importData();
            printer.printLine("Imported data from a file");
        } catch (DataImportException e) {
            printer.printLine(e.getMessage());
            printer.printLine("New base initiated.");
            library = new Library();
        }
    }

    void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
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
                case DELETE_BOOK:
                    deleteBook();
                    break;
                case DELETE_MAGAZINE:
                    deleteMagazine();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("There is no such option, please re-enter: ");
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ", try again:");
            } catch (InputMismatchException ignored) {
                printer.printLine("You entered a value that is not a number, please enter it again:");
            }
        }
        return option;
    }

    private void printOptions() {
        printer.printLine("Select option: ");
        for (Option option : Option.values()) {
            System.out.println(option.toString());
        }
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addPublication(book);
        } catch (InputMismatchException e) {
            printer.printLine("Book creation failed, invalid data");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Capacity reached, no more book can be added");
        }
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addPublication(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Magazine creation failed, invalid data");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Capacity reached, no more magazine can be added");
        }
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);
    }
    private Publication[] getSortedPublications() {
        Publication[] publications = library.getPublications();
        Arrays.sort(publications, new AlphabeticalTitleComparator());
        return publications;
    }
    private void deleteMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            if (library.removePublication(magazine))
                printer.printLine("UMagazine deleted.");
            else
                printer.printLine("No specified magazine.");
        } catch (InputMismatchException e) {
            printer.printLine("Magazine creation failed, invalid data");
        }
    }

    private void deleteBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            if (library.removePublication(book))
                printer.printLine("Book deleted.");
            else
                printer.printLine("No specified book.");
        } catch (InputMismatchException e) {
            printer.printLine("Book creation failed, invalid data");
        }
    }

    private void exit() {
        try {
            fileManager.exportData(library);
            printer.printLine("Successful data export to file");
        } catch (DataExportException e) {
            printer.printLine(e.getMessage());
        }
        printer.printLine("End of program.");
        dataReader.close();
    }

    private enum Option{
        EXIT(0, "Exit the program"),
        ADD_BOOK(1, "Add new book"),
        ADD_MAGAZINE(2,"Add new magazine"),
        PRINT_BOOKS(3, "View available books"),
        PRINT_MAGAZINES(4, "View available magazines"),
        DELETE_BOOK(5, "Delete book"),
        DELETE_MAGAZINE(6, "Delete magazine");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }
        @Override
        public String toString() {
            return value + "-" + description;
        }
        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            }catch (ArrayIndexOutOfBoundsException e){
                throw new NoSuchOptionException("No option for id " + option);
            }
        }
    }

}
