package pl.klaudia.library.io;

import pl.klaudia.library.model.Book;
import pl.klaudia.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }
    public String getString(){
        return sc.nextLine();
    }

    public void close(){
        sc.close();
    }

    public int getInt(){
        try{
            return sc.nextInt();
        }finally {
           sc.nextLine();
        }
    }
    public Book readAndCreateBook(){
        printer.printLine("Title: ");
        String title = sc.nextLine();
        printer.printLine("Author: ");
        String author = sc.nextLine();
        printer.printLine("Publisher: ");
        String publisher = sc.nextLine();
        printer.printLine("ISBN: ");
        String isbn = sc.nextLine();
        printer.printLine("Release date: ");
        int releaseDate = sc.nextInt();
        sc.nextLine();
        printer.printLine("Number of pages: ");
        int pages = sc.nextInt();
        sc.nextLine();

        return new Book(title,author,releaseDate,pages,publisher,isbn);
    }
    public Magazine readAndCreateMagazine(){
        printer.printLine("Title: ");
        String title = sc.nextLine();
        printer.printLine("Publisher: ");
        String publisher = sc.nextLine();
        printer.printLine("Language: ");
        String language = sc.nextLine();
        printer.printLine("Publication year: ");
        int year = getInt();
        printer.printLine("Month: ");
        int month = getInt();
        printer.printLine("Day: ");
        int day = getInt();
        return new Magazine(title,publisher,language,year,month,day);
    }

}
