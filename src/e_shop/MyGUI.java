package e_shop;

//import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;//
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyGUI {

    JButton add, delete, display, example;
    JTextField color, name, number, price, quantity;
    JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
    JFrame fram;

    shoppingCart cart;
    public static String trash = "";

    public MyGUI() {

        cart = new shoppingCart();
        jLabel1 = new JLabel();
        number = new JTextField();
        jLabel2 = new JLabel();
        name = new JTextField();
        jLabel3 = new JLabel();
        price = new JTextField();
        jLabel4 = new JLabel();
        color = new JTextField();
        jLabel5 = new JLabel();
        quantity = new JTextField();
        example = new JButton();
        add = new JButton();
        display = new JButton();
        delete = new JButton();


        fram = new JFrame();

        fram.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fram.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Number:");
        fram.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 20));
        fram.getContentPane().add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 70, -1));

        jLabel2.setText("Name:");
        fram.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 20));
        fram.getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 110, -1));

        jLabel3.setText("Price:");
        fram.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 20));
        fram.getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 70, -1));

        jLabel4.setText("Color:");
        fram.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 20));
        fram.getContentPane().add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 100, -1));

        jLabel5.setText("Quantity:");
        fram.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));
        fram.getContentPane().add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 70, -1));

        //...................................................................................................
        example.setText("Example");
        fram.getContentPane().add(example, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        example.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //new E_shop().example();

                try {
                    File f = new File("Example1.jpg");
                    Image img = ImageIO.read(f);
                    ImageIcon icon = new ImageIcon(img);
                    NewJFrame ff = new NewJFrame();
                    ff.lblimage.setIcon(icon);
                    ff.setMinimumSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
                    ff.setVisible(true);

                } catch (Exception ex) {
                    Logger.getLogger(MyGUI.class.getName()).log(Level.SEVERE, null, ex);

                }

            }
        });
//        

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    int num = Integer.parseInt(number.getText());
                    int pri = Integer.parseInt(price.getText());
                    int q = Integer.parseInt(quantity.getText());
                    String nam = name.getText();
                    String col = color.getText();
                    cart.add(new Element(num, pri, nam, col, q));
                    JOptionPane.showMessageDialog(fram, "Added Success");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(fram, e.getMessage());
                }

            }
        });
        fram.getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    int num = Integer.parseInt(number.getText());

                    Element e = cart.delete(num);
                    if (trash.isEmpty()) {
                        trash += "\n\n\n ----------------------------- Deleted Items -----------------------------\n\n\n";
                        trash += "Number\tPrice\tName\tColor\tQuantity\n";
                        trash += "---------------------------------------------------------------------------------------\n";
                    }

                    trash += e.display() + "\n";

                    JOptionPane.showMessageDialog(fram, "Deleted Successfull");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(fram, e.getMessage());
                }

            }
        });

        fram.getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        display.setText("Display");
        display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                String c = cart.display();
                c += "\n--------------- Total Price = " + cart.checkOut() + " -----------------------------------------\n\n";
                if (!trash.isEmpty()) {
                    c += trash;
                }

                new Show(c).setVisible(true);

            }
        });

        fram.getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        fram.pack();
        fram.setVisible(true);

    }

    public static void main(String args[]) {
        new MyGUI();
    }

}
