import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Cart extends JPanel {
    Border mainBorder;
    JLabel cartTitle, line, itemName, itemQty, itemPrice;
    CartItem cartContent;
    Font titleFont;

    public Cart(Color primaryTheme){
        CurrentCartItems.ourCart = this;
        mainBorder = BorderFactory.createLineBorder(Color.WHITE, 3, true);
        titleFont = new Font("Copperplate", Font.BOLD,22);

        cartTitle = new JLabel("Cart");
        cartTitle.setBounds(150,15, 95, 25);
        cartTitle.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Color.BLACK));
        cartTitle.setFont(new Font("Copperplate", Font.BOLD,36));
        add(cartTitle);

        line = new JLabel();
        line.setBounds(0,50,400, 5);
        line.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Color.BLACK));
        add(line);

        itemName = new JLabel("Items");
        itemName.setFont(titleFont);
        itemName.setBounds(25, 60, 100, 20);
        add(itemName);

        itemQty = new JLabel("Qty");
        itemQty.setFont(titleFont);
        itemQty.setBounds(235, 60, 100, 20);
        add(itemQty);

        itemPrice = new JLabel("Price");
        itemPrice.setFont(titleFont);
        itemPrice.setBounds(300, 60, 100, 20);
        add(itemPrice);

        line = new JLabel();
        line.setBounds(0,80,400, 5);
        line.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Color.BLACK));
        add(line);

        cartContent = new CartItem();
        cartContent.setBounds(10, 90, 375, 330);
        cartContent.setBorder(null);
        add(cartContent);

        line = new JLabel();
        line.setBounds(0,420,400, 5);
        line.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Color.BLACK));
        add(line);

        itemName = new JLabel("Total Cart Value: ");
        itemName.setBounds(15, 430, 300, 20);
        itemName.setFont(new Font("Copperplate", Font.BOLD,18));
        add(itemName);

        itemName = new JLabel("$" + Products.cartModel.cartTotal);
        itemName.setBounds(310, 430, 100, 20);
        itemName.setFont(new Font("Copperplate", Font.BOLD,18));
        add(itemName);

        updateTotalNow();

        setBorder(mainBorder);
        setBackground(primaryTheme);
        setLayout(null);
    }

    public void updateTotalNow(){
        itemName.invalidate();
        remove(itemName);
        itemName = new JLabel("$" + Products.cartModel.cartTotal);
        itemName.setBounds(310, 430, 100, 20);
        itemName.setFont(new Font("Copperplate", Font.BOLD,18));
        add(itemName);
        itemName.revalidate();
        itemName.repaint();
    }
}
