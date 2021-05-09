import javax.swing.*;
import java.awt.*;

public class ProductSection extends JPanel {
    ProductList products;

    public ProductSection(Color primaryTheme){

        products = new ProductList(primaryTheme, "Burgers", false);
        products.setBounds(0,20, 425, 225);
        add(products);

        products = new ProductList(primaryTheme, "Pizza", false);
        products.setBounds(0,270, 425, 225);
        add(products);

        products = new ProductList(primaryTheme, "Pasta", false);
        products.setBounds(450,20, 425, 225);
        add(products);

        products = new ProductList(primaryTheme, "Shakes", false);
        products.setBounds(450,270, 425, 225);
        add(products);

        setBackground(primaryTheme);
        setLayout(null);
    }
}
