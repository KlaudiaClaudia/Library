package pl.klaudia.library.app;

import pl.klaudia.library.exception.NoSuchOptionException;

enum Option {
    EXIT(0, "Exit the program"),
    ADD_BOOK(1, "Add new book"),
    ADD_MAGAZINE(2,"Add new magazine"),
    PRINT_BOOKS(3, "View available books"),
    PRINT_MAGAZINES(4, "View available magazines");

    private int value;
    private String description;

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

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
