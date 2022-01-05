package e_shop;

import javax.swing.JOptionPane;

public class shoppingCart {

    protected Element head;
    protected int size;

    public shoppingCart() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void add(Element e) {
        e.setNext(head);
        head = e;
        size++;
    }
// end add

    public Element delete(int num) {
        Element current = head;
        Element previous = head;

        while (current.getNext() != null) {
            if (current.getNumber() == num) {
                previous.setNext(current.getNext());
                current.setNext(null);
                return current;
            } else {
                previous = current;
                current = current.getNext();
            }//end if-else 
        }//end while 
        return null;
    }//end delete

    public int checkOut() {
        Element current = head;
        int price, totalPrice = 0;
        while (current != null) {
            price = current.getPrice() * current.getQuantity();
            totalPrice += price;
            current = current.getNext();

        }//end while 

        return totalPrice;
    }//end checkOut 

    public void deleteAll() {
        if (isEmpty()) {
            System.out.println("list is Empty");
        } else {
            head = null;
            System.out.println("thank you for your payment " + "... shopping list was deleted ");
        } //end deleteAll
    }

    public String display() {
        Element current = head;
        String content = "";
        content += "Number\tPrice\tName\tColor\tQuantity\n";
        content +="---------------------------------------------------------------------------------------\n";

        while (current != null) {
            content += current.display();
            current = current.getNext();
            content += "\n";
        }
        return content;
    }
}// end class ShoppingCart 

