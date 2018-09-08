import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private List<Cart> cart;
    private double totalPrice;

    public Customer() {
        this.cart = new ArrayList<Cart>();
        this.totalPrice = 0;
    }


    public void addItemToCart(Book book, int qty) {
        Cart temp = presentInCart(book.getBookName());
        if (temp!=null) {
            System.out.println("\n"+book.getBookName()+" already present in cart");
            temp.setQuantity(temp.getQuantity()+qty);
        }
        else {
            this.cart.add(new Cart(book, qty));
        }
            System.out.println("\n" + qty + " copies of " + book.getBookName() + " is added to your cart");
    }



    public void removeItemFromCart(){
        if(!cartEmpty()) {
            Scanner input = new Scanner(System.in);
           System.out.println("Enter name of book you want remove from cart ");
           String name = input.nextLine();
                Cart temp = presentInCart(name);
                if (temp!=null) {
                    cart.remove(cart.indexOf(temp));
                    System.out.println(temp.getBook() + "has been removed from cart");
                } else
                    System.out.println("No book found!!");
        }
        else
            System.out.println("Cart is empty.");
    }

    public void showItemInCart(){
        if(!cartEmpty()) {
            for(int j=0; j<70;j++)
                System.out.print("-");
            System.out.print("\n| SNO |\t\t\t NAME\t\t\t|  PRICE  | QUANTITY |\n");
            for(int j=0; j<70;j++)
                System.out.print("-");
            for (int i = 0; i < cart.size(); i++) {
                Cart temp = cart.get(i);
                System.out.print("\n| "+ (i + 1) + "  ");
                System.out.print("\t  "+temp.getBook().getBookName());
                for(int j =0; j< (40-temp.getBook().getBookName().length());j++)
                    System.out.print(" ");
                System.out.print(temp.getBook().getPrice()+"\t\t");
                System.out.print(temp.getQuantity()+"   |\n");
            }
            for(int j=0; j<70;j++)
                System.out.print("-");
            System.out.println();
        }
        else
            System.out.println("Cart is empty.");
    }

    public void calculate(){
        for (int i=0; i<cart.size(); i++) {
            Cart temp = cart.get(i);
            totalPrice = totalPrice + temp.getBook().getPrice()*temp.getQuantity();
        }
    }

    public void bill(){
        if(!cartEmpty()) {
            for(int j=0; j<65;j++) {
                System.out.print("-");
                if(j==30)
                    System.out.print("BILL");
            }
            System.out.println();
            showItemInCart();
            calculate();
            System.out.println("\t\t\t\t\tTotal Price : " + totalPrice);
            cart = new ArrayList<Cart>();
            System.out.println("Cart is empty now!!!!");
        }
        else
            System.out.println("Cart is empty.");
    }

    public boolean cartEmpty(){
        if(cart.size()>0)
            return false;
        else
            return true;

    }

    public Cart presentInCart(String name) {
        for (int i = 0; i < cart.size(); i++) {
            Cart temp = cart.get(i);
            if (temp.getBook().getBookName().equalsIgnoreCase(name))
                return temp;
        }
        return  null;
    }
}

