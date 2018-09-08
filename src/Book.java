public class Book {

    private long ISBN;
    private String bookName;
    private String author;
    private double price;
    private String language;
    private String genre;
    private int pages;

    public Book()
    {
        this(0,null,null,0.0,null,null,0);
    }

    public Book(long ISBN, String bookName, String author, double price, String language, String genre, int pages) {
        setISBN(ISBN);
        setBookName(bookName);
        setAuthor(author);
        setPrice(price);
        setLanguage(language);
        setGenre(genre);
        setPages(pages);
    }


    public long getISBN()
    {
        return ISBN;
    }

    public void setISBN(long ISBN) {

        this.ISBN = ISBN;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language) {

        this.language = language;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;

    }

    public int getPages()
    {
        return pages;
    }

    public void setPages(int pages) {

        this.pages = pages;
    }


    public void bookRecordDisplay() {
        System.out.println("\n....................................................");
        System.out.println(" ISBN             : "+getISBN());
        System.out.println(" NAME             : "+getBookName());
        System.out.println(" AUTHOR           : "+getAuthor());
        System.out.println(" PRICE            : "+getPrice());
        System.out.println(" LANGUAGE         : "+getLanguage());
        System.out.println(" GENRE            : "+getGenre());
        System.out.println(" NUMBER OF PAGES  : "+getPages());
        System.out.println("....................................................\n");
    }


}

