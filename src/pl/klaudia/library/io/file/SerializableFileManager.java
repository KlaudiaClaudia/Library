package pl.klaudia.library.io.file;

import pl.klaudia.library.exception.DataExportException;
import pl.klaudia.library.exception.DataImportException;
import pl.klaudia.library.model.Library;

import java.io.*;

public class SerializableFileManager implements FileManager {

    private static final String FILE_NAME = "Library.lib";

    @Override
    public Library importData() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("File reading error " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Incompatible data type in the file" + FILE_NAME);
        }
    }

    @Override
    public void exportData(Library library) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ){
            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportException("No file " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Error writing data to the file " + FILE_NAME);
        }
    }
}
