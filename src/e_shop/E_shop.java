package e_shop;

public class E_shop {

    public void example() {
        shoppingCart cart = new shoppingCart();
        cart.add(new Element(90, 6, "robin", "red", 2));
        cart.add(new Element(80, 30, "ring", "selver", 1));
        cart.add(new Element(30, 16, "earing", "pink", 1));
        cart.add(new Element(50, 18, "ring", "gold", 4));

        String c = cart.display();
        Element e = cart.delete(30);
        c += "\n\n\n ------------  itme deleted ------------\n";
        c+= e.display()+"\n";

        c+= "\n"+cart.display()+" \n ---------- \n\n";

        int totalPrice = cart.checkOut();
        c+= "\nyour total price is: " + totalPrice;
        cart.deleteAll();
        
        new Show(c).setVisible(true);
    }
}
