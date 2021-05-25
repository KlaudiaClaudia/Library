package pl.klaudia.library.io.file;

import pl.klaudia.library.exception.NoSuchFileTypeException;
import pl.klaudia.library.io.ConsolePrinter;
import pl.klaudia.library.io.DataReader;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }
    public FileManager build() {
        printer.printLine("Select the data format:");
        FileType fileType = getFileType();
        switch (fileType) {
            case SERIAL:
                return new SerializableFileManager();
            default:
                throw new NoSuchFileTypeException("Unsupported data type");
        }
    }
        private FileType getFileType() {
            boolean typeOk = false;
            FileType result = null;
            do {
                printTypes();
                String type = reader.getString().toUpperCase();
                try {
                    result = FileType.valueOf(type);
                    typeOk = true;
                } catch (IllegalArgumentException e) {
                    printer.printLine("Unsupported data type, select again.");
                }
            } while (!typeOk);

            return result;
        }

        private void printTypes() {
            for (FileType value : FileType.values()) {
                printer.printLine(value.name());
            }
    }
}
