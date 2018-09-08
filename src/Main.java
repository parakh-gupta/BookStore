import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    public static BooksRecord booksRecord = new BooksRecord();
    public static Customer customer = new Customer();

    public static void main(String[] args) {
        try {
            menu();
        }
        catch(Exception e){
            System.out.println("Please try again!!!");
            quit();
        }
    }

    public static void menu() {
        System.out.println("\n*****************BOOK STORE *********************");
        System.out.println("1.Customer");
        System.out.println("2.Seller");
        System.out.println("3.Exit");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                customer();
                break;
            case 2:
                seller();
                break;
            case 3:
                quit();
                return;
            default:
                System.out.println("\nInvalid Option!");
                menu();
                return;
        }

    }


    public static void customer() {
        System.out.println("\n*****************BOOK STORE *********************");
        System.out.println("1.View all books");
        System.out.println("2.Search by Book Name");
        System.out.println("3.Search by Author");
        System.out.println("4.Search by Genre");
        System.out.println("5.Search by Language");
        System.out.println("6.Back");
        System.out.println("7.Exit");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                booksRecord.view();
                break;
            case 2:
                booksRecord.displayByName();
                break;
            case 3:

                booksRecord.displayByAuthor();
                break;
            case 4:
                booksRecord.displayByGenre();
                break;
            case 5:
                booksRecord.displayByLanguage();
                break;
            case 6:
                System.out.println("Back to Main Menu");
                menu();
                return;
            case 7:
                check();
                return;
            default:
                System.out.println("Invalid Option!");
                customer();
                return;
        }
        check();
    }
    public static void check(){
        System.out.println("\nDo you want to buy anything? (yes/no)");
        String ans = input.next();
        if (ans.equalsIgnoreCase("yes"))
            buy();
        else if (ans.equalsIgnoreCase("no")){
            if(!customer.cartEmpty()){
                System.out.println("\nWant to buy these books");
                customer.showItemInCart();
                System.out.println("\n Enter Yes/No");
                String answer = input.next();
                if(answer.equalsIgnoreCase("yes"))
                    customer.bill();
                else
                    quit();
            }
            else
                quit();

        }
        else
            check();
    }

    public static void buy() {
        {
            System.out.println("\n*****************BOOK STORE *********************");
            System.out.println("1.Add item to cart");
            System.out.println("2.Remove item from cart");
            System.out.println("3.Display items in cart");
            System.out.println("4.Bill");
            System.out.println("5.Back");
            System.out.println("6.Exit");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    Book book = new Book();
                    book = booksRecord.findBook();
                    if(book!=null) {
                        System.out.println("\nEnter number of copies book " + book.getBookName() + " you want to buy?");
                        int qty = input.nextInt();
                        customer.addItemToCart(book, qty);
                    }
                    else
                        System.out.println("No Book found.");
                    buy();
                    break;
                case 2:
                    customer.removeItemFromCart();
                    buy();
                    break;
                case 3:
                    customer.showItemInCart();
                    buy();
                    break;
                case 4:
                    customer.bill();
                    buy();
                    break;
                case 5:
                    customer();
                    return;
                case 6:
                    check();
                    return;
                default:
                    System.out.println("Invalid Option!");
                    buy();
                    return;
            }
        }

    }
    public static void seller() {
        System.out.println("\n*****************BOOK STORE *********************");
        System.out.println("1.Add Book");
        System.out.println("2.Remove Book");
        System.out.println("3.Update Book");
        System.out.println("4.Display Book");
        System.out.println("5.Back");
        System.out.println("6.Exit");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                addBook();
                seller();
                break;
            case 2:
                booksRecord.remove();
                seller();
                break;
            case 3:
                Book book = new Book();
                book = booksRecord.findBook();
                update(book);
                seller();
                break;
            case 4:
                booksRecord.view();
                seller();
                break;
            case 5:
                menu();
                return;
            case 6:
                quit();
                return;
            default:
                System.out.println("Invalid Option!");
                seller();
                return;
        }
    }


    public static void update(Book book) {
        System.out.println("\n*****************BOOK STORE *********************");
        System.out.println("1.Update ISBN");
        System.out.println("2.Update Book Name");
        System.out.println("3.Update Author's Name");
        System.out.println("4.Update Price");
        System.out.println("5.Update Language");
        System.out.println("6.Update Genre");
        System.out.println("7.Update Number of Pages");
        System.out.println("8.Back");
        int choice = input.nextInt();
        if (book != null) {
            switch (choice) {
                case 1:
                    System.out.println("\nEnter new ISBN");
                    book.setISBN(input.nextInt());
                    break;
                case 2:
                    System.out.println("\nEnter Book Name");
                    book.setBookName(input.next());
                case 3:
                    System.out.println("\nEnter Author's Name");
                    book.setAuthor(input.next());
                    break;
                case 4:
                    System.out.println("\nEnter Price");
                    book.setPrice(input.nextInt());
                    break;
                case 5:
                    System.out.println("\nEnter Language");
                    book.setLanguage(input.next());
                    break;
                case 6:
                    System.out.println("\nEnter Genre");
                    book.setGenre(input.next());
                    break;
                case 7:
                    System.out.println("\nEnter Number of Pages");
                    book.setPages(input.nextInt());
                    break;
                case 8:
                    seller();
                    return;
                default:
                    System.out.println("Invalid Option!");
                    update(book);
                    return;
            }
            book.bookRecordDisplay();
        }
        else
            System.out.println("No book found.");

    }

    public static void addBook() {
        Book newBook = new Book();
        System.out.println("\nEnter new ISBN");
        newBook.setISBN(input.nextInt());
        System.out.println("\nEnter Book Name");
        newBook.setBookName(input.next());
        System.out.println("\nEnter Author's Name");
        newBook.setAuthor(input.next());
        System.out.println("\nEnter Price");
        newBook.setPrice(input.nextInt());
        System.out.println("\nEnter Language");
        newBook.setLanguage(input.next());
        System.out.println("\nEnter Genre");
        newBook.setGenre(input.next());
        System.out.println("\nEnter Number of pages ");
        newBook.setPages(input.nextInt());
        booksRecord.add(newBook);
    }


    public  static void quit(){
        System.out.println("\nHave a nice day :)!! Thank You for visiting us");
        System.exit(0);
    }

}
