import java.util.ArrayList;
import java.util.Scanner;

public class BooksRecord {
    private ArrayList<Book> books;

    BooksRecord() {
        this.books = new ArrayList<Book>();
        books.add(new Book(817223498, "The Alchemist", "Paul Coelho", 288, "English", "Fiction",208));
        books.add(new Book(552159719, "The Da Vinci Code", "Dan Brown", 330, "English", "Novel",592));
        books.add(new Book(1904233651, "Twilight - The Saga", "Stephenie Meyer", 282, "English", "Fiction",434));
        books.add(new Book(938261654, "Gone With The Wind", "Margaret Mitchell", 325, "English", "Fiction",952));
        books.add(new Book(817234564, "Think and Grow Rich", "Napoleon Hill", 108, "English", "Business",272));
        books.add(new Book(553296981, "The Diary of a Young Girl", "Anne Frank", 115, "English", "Literature",280));
        books.add(new Book(817223539, "The PILGRIMAGE", "Paul Coelho", 209, "English", "Fiction",240));
        books.add(new Book(817223540, "VALKYRIES", "Paul Coelho", 220, "English", "Fiction",256));
        books.add(new Book(817223514, "The Fifth Mountain", "Paul Coelho", 220, "English", "Fiction",256));
        books.add(new Book(818328092, "The Zahir", "Paul Coelho", 180, "Hindi", "Fiction",320));
        books.add(new Book(316027650, "Eclipse", "Stephenie Meyer", 425, "English", "Fiction",224));
        books.add(new Book(1904233880, "New Moon", "Stephenie Meyer", 300, "English", "Fiction",434));
        books.add(new Book(817028432, "Godan", "Premchand", 165, "Hindi", "Novel",320));
        books.add(new Book(817483159, "Nirmala", "Premchand", 125, "Hindi", "Novel",160));
        books.add(new Book(552150738, "Angels And Demons", "Dan Brown", 260, "English", "Novel",624));
    }



    public void add(Book newBook) {
            books.add(newBook);
            System.out.println("\n\tAdded a new Book");
            newBook.bookRecordDisplay();
    }

    public void remove() {
        Book book = findBook();
        if (book != null) {
            int i = books.indexOf(book);
            System.out.println(book.getBookName()+" is removed");
            books.remove(i);
        }
        else
            System.out.println("No book found.");
    }


    public void view() {
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            book.bookRecordDisplay();
        }
    }

    public Book findBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter Book Name");
        String name = input.nextLine();
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getBookName().equalsIgnoreCase(name)) {
                book.bookRecordDisplay();
                return book;
            }
        }
        return null;

    }

    public void displayByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nPlease enter Book Name");
        String findName = input.nextLine();
        int k=0;
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getBookName().equalsIgnoreCase(findName)) {
                book.bookRecordDisplay();
                k++;
            }
        } if(k==0){
                System.out.println("NO book found");
                displayByName();
            }

    }

    public void displayByAuthor() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nPlease enter Author's Name");
        String findAuthor = input.nextLine();
        int k=0;
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getAuthor().equalsIgnoreCase(findAuthor)) {
                book.bookRecordDisplay();
                k++;
            }
        }
            if(k==0){
                System.out.println("NO book found");
                displayByAuthor();
            }

    }

    public void displayByLanguage() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nPlease enter Language");
        String findLanguage = input.nextLine();
        int k=0;
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getLanguage().equalsIgnoreCase(findLanguage)) {
                book.bookRecordDisplay();
                k++;
            }
        }
            if(k==0){
                System.out.println("No book found");
                displayByLanguage();
            }
    }

    public void displayByGenre() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nPlease enter Genre");
        String findGenre = input.nextLine();
        int k=0;
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getGenre().equalsIgnoreCase(findGenre)) {
                book.bookRecordDisplay();
                k++;
            }
        }
        if(k==0) {
            System.out.println("No book found");
            displayByGenre();
        }

    }

}