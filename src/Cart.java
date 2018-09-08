public class Cart  {
    private Book book;
    private int quantity;


    public Cart(Book book, int quantity) {
        setBook(book);
        setQuantity(quantity);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
