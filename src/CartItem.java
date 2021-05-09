import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CartItem extends JPanel {
    JTable cartItems;
    Font itemFont;
    CartModel cartData;
    JScrollPane scrollPane;
    JPopupMenu popupMenu;

    public CartItem(){
        cartData = new CartModel();
        itemFont = new Font("Copperplate", Font.ITALIC,16);

        JMenuItem removeItem = new JMenuItem("Remove Item");
        popupMenu = new JPopupMenu();
        popupMenu.add(removeItem);
        add(popupMenu);

        cartItems = new JTable(cartData);
        cartItems.setRowHeight(25);
        cartItems.getColumnModel().getColumn(0).setMinWidth(230);
        cartItems.setFont(itemFont);
        cartItems.setTableHeader(null);

        scrollPane = new JScrollPane(cartItems);
        scrollPane.setBounds(5, 5, 375, 320);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane);

        cartItems.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int row  = cartItems.rowAtPoint(e.getPoint());
                cartItems.getSelectionModel().setSelectionInterval(row,row);

               if (e.getButton() == MouseEvent.BUTTON3){
                   popupMenu.show(popupMenu, e.getX(), e.getY());
               };
            }
        });

        removeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row  = cartItems.getSelectedRow();
                Products.cartModel.cartTotal -= Products.cartProducts.get(row).cartItemPrice;
                CurrentCartItems.ourCart.updateTotalNow();
                Products.cartProducts.remove(row);
                Products.cartModel.getTableData().remove(row);
                cartData.fireTableRowsDeleted(row,row);

                popupMenu.invalidate();
                remove(popupMenu);
                add(popupMenu);
                popupMenu.add(removeItem);
                popupMenu.revalidate();
                popupMenu.repaint();
            }
        });

        Products.cartTable = cartData;

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
    }
}
