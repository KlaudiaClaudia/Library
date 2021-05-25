package pl.klaudia.library.io.file;

import pl.klaudia.library.model.Library;

public interface FileManager {
    Library importData();
    void exportData (Library library);
}
