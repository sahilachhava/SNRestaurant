import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameContent extends JPanel {
    Border mainBorder;
    ProductSection productBody;
    Cart productCart;
    JButton actionBtn;

    public FrameContent(Color primaryTheme){
        mainBorder = BorderFactory.createLineBorder(Color.WHITE, 3, true);

        productCart = new Cart(primaryTheme);
        productCart.setBounds(950, 43, 400, 460);
        productCart.setBackground(Color.WHITE);
        productCart.setOpaque(true);
        add(productCart);

        productBody = new ProductSection(primaryTheme);
        productBody.setBounds(25, 15, 875, 525);
        add(productBody);

        actionBtn = new JButton("Clear Cart");
        actionBtn.setBounds(960, 510, 170, 50);
        actionBtn.setForeground(Color.WHITE);
        actionBtn.setFont(new Font("Copperplate", Font.BOLD,22));
        actionBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        actionBtn.setBackground(new Color(33, 140, 116));
        actionBtn.setOpaque(true);
        add(actionBtn);
        actionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Products.cartProducts.removeAll(Products.cartProducts);
                Products.cartModel.getTableData().removeAll(Products.cartModel.getTableData());
                Products.cartModel.cartTotal = 0;
                CurrentCartItems.ourCart.updateTotalNow();
                JOptionPane.showMessageDialog(null, "Cart Cleared");
            }
        });

        actionBtn = new JButton("Place Order");
        actionBtn.setBounds(1170, 510, 170, 50);
        actionBtn.setForeground(Color.WHITE);
        actionBtn.setFont(new Font("Copperplate", Font.BOLD,22));
        actionBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        actionBtn.setBackground(new Color(33, 140, 116));
        actionBtn.setOpaque(true);
        add(actionBtn);
        actionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Products.cartProducts.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Cart is Empty");
                }else{
                    int orderID = Products.orderIndex + 101;
                    float orderTotal = Products.cartModel.cartTotal;
                    float orderTax = (float)(orderTotal * 0.15); //10% Tax
                    ArrayList<CurrentCartItems> allItems = new ArrayList<CurrentCartItems>();

                    allItems.addAll(Products.cartProducts);

                    Products.allOrders.add(new Orders(orderID, orderTotal, orderTax, allItems));
                    Products.orderIndex++;

                    Products.cartProducts.removeAll(Products.cartProducts);
                    Products.cartModel.getTableData().removeAll(Products.cartModel.getTableData());
                    Products.cartModel.cartTotal = 0;
                    CurrentCartItems.ourCart.updateTotalNow();

                    new OrderReceipt(primaryTheme, Products.orderIndex-1);
                }
            }
        });

        setBorder(mainBorder);
        setBackground(primaryTheme);
        setLayout(null);
    }
}
