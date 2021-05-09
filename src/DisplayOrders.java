import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class DisplayOrders extends JPanel {
    Border mainBorder;
    Font titleFont;
    JTable orderTable;
    JScrollPane scrollPane;

    String[] columnNames = {"Order ID", "Total Items", "Base Total", "Tax", "Total Amount", "View Receipt"};
    String[][] allOrders;


    public DisplayOrders(Color primaryTheme){
        mainBorder = BorderFactory.createLineBorder(Color.WHITE, 3, true);
        titleFont = new Font("Copperplate", Font.BOLD,24);

        allOrders = new String[Products.allOrders.size()][5];
        int index = 0;
        int tableHeight = 0;
        for(Orders order : Products.allOrders){
            allOrders[index] = new String[]{
                    String.valueOf(order.getOrderID()),
                    String.valueOf(order.getAllItems().size()),
                    String.valueOf(order.getOrderTotal()),
                    String.valueOf(order.getOrderTax()),
                    String.valueOf(order.getOrderTotal() + order.getOrderTax()),
                    "Show",
            };
            index++;
            tableHeight += 30;
        }

        orderTable = new JTable(allOrders, columnNames);
        orderTable.setFont(new Font("Copperplate", Font.ITALIC, 22));
        orderTable.setRowHeight(30);
        orderTable.setIntercellSpacing(new Dimension(5, 5));
        orderTable.setForeground(Color.WHITE);
        orderTable.setBorder(BorderFactory.createLineBorder(primaryTheme));
        orderTable.setBackground(primaryTheme);
        orderTable.setShowVerticalLines(false);
        orderTable.setShowHorizontalLines(false);
        orderTable.setEnabled(false);
        orderTable.setOpaque(true);
        orderTable.getTableHeader().setFont(titleFont);
        orderTable.getTableHeader().setBackground(primaryTheme);
        orderTable.getTableHeader().setOpaque(true);
        orderTable.getTableHeader().setForeground(Color.WHITE);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        orderTable.getTableHeader().setDefaultRenderer(centerRenderer);
        for(int i = 0; i < orderTable.getColumnCount(); i++){
            orderTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        DefaultTableCellRenderer lastColumnRenderer = new DefaultTableCellRenderer();
        lastColumnRenderer.setForeground(new Color(33, 140, 116));
        lastColumnRenderer.setToolTipText("Click to see Order Receipt");
        lastColumnRenderer.setHorizontalAlignment(JLabel.CENTER);
        lastColumnRenderer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        orderTable.getColumnModel().getColumn(5).setCellRenderer(lastColumnRenderer);

        scrollPane = new JScrollPane(orderTable, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(primaryTheme);
        scrollPane.setOpaque(true);
        scrollPane.setBorder(BorderFactory.createLineBorder(primaryTheme));
        scrollPane.setBounds(30, 20, 1300, tableHeight+20);
        add(scrollPane);

        orderTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int tableRow = orderTable.rowAtPoint(e.getPoint());
                int tableColumn = orderTable.columnAtPoint(e.getPoint());

                if(tableColumn == 5){
                    new OrderReceipt(primaryTheme, tableRow);
                }
            }
        });

        setBorder(mainBorder);
        setBackground(primaryTheme);
        setLayout(null);
    }
}
