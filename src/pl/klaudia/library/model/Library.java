package pl.klaudia.library.model;

public class Library {

    private static final int MAX_PUBLICATIONS = 2000;
    private int publicationNumber;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];


    public void addBook(Book book){
        if (publicationNumber < MAX_PUBLICATIONS){
            publications[publicationNumber] = book;
            publicationNumber ++;
        }else {
            System.out.println("The maximum number of books has been reached");
        }
    }
    public void printBooks(){
        int countBooks = 0;
        for (int i = 0; i < publicationNumber; i++) {
            if (publications[i]instanceof Book){
                publications[i].printInfo();
                countBooks++;
            }
        }
        if (countBooks==0){
            System.out.println("No books in the library");
        }
    }
    public void addMagazine(Magazine magazine) {
        if(publicationNumber < MAX_PUBLICATIONS) {
            publications[publicationNumber] = magazine;
            publicationNumber++;
        } else {
            System.out.println("The maximum number of magazines has been reached");
        }

    }

    public void printMagazines() {
        int countMagazines =0;
        for (int i = 0; i <publicationNumber ; i++) {
            if (publications[i]instanceof Magazine){
                publications[i].printInfo();
                countMagazines++;
            }
        }
        if (countMagazines==0){
            System.out.println("No magazines in the library");
        }
    }

}
