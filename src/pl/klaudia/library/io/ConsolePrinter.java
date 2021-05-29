package pl.klaudia.library.io;

import pl.klaudia.library.model.Book;
import pl.klaudia.library.model.LibraryUser;
import pl.klaudia.library.model.Magazine;
import pl.klaudia.library.model.Publication;

import java.util.Collection;

public class ConsolePrinter {
    public void printBooks(Collection <Publication> publications) {
        int counter = 0;
        for (Publication publication : publications) {
            if(publication instanceof Book) {
                printLine(publication.toString());
                counter++;
            }
        }
        if (counter == 0)
            printLine("No books in library");
    }

    public void printMagazines(Collection <Publication> publications) {
        int counter = 0;
        for (Publication publication : publications) {
            if(publication instanceof Magazine) {
                printLine(publication.toString());
                counter++;
            }
        }
        if (counter == 0)
            printLine("No magazines in library");
    }
    public void printUsers(Collection<LibraryUser> users) {
        for (LibraryUser user : users) {
            printLine(user.toString());
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }
}
