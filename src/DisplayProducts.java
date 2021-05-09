import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class DisplayProducts extends JPanel {
    Border mainBorder;
    ProductList products;

    public DisplayProducts(Color primaryTheme){
        mainBorder = BorderFactory.createLineBorder(Color.WHITE, 3, true);

        products = new ProductList(primaryTheme, "Burgers", true);
        products.setBounds(30,20, 650, 250);
        add(products);

        products = new ProductList(primaryTheme, "Pizza", true);
        products.setBounds(30,295, 650, 250);
        add(products);

        products = new ProductList(primaryTheme, "Pasta", true);
        products.setBounds(720,20, 650, 250);
        add(products);

        products = new ProductList(primaryTheme, "Shakes", true);
        products.setBounds(720,295, 650, 250);
        add(products);

        setBorder(mainBorder);
        setBackground(primaryTheme);
        setLayout(null);
    }
}
