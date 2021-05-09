import com.qoppa.pdfWriter.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

class OrderReceipt extends JDialog implements Printable {
    JLabel txtLabel;
    JTable itemTable;
    JScrollPane scrollPane;
    JButton printReceipt, closeReceipt;
    Orders currentOrder;
    String[] columnNames = {"Item", "Qty", "Price"};
    String[][] allItems;
    OrderReceipt myReceipt = this;

    public OrderReceipt(Color primaryTheme, int orderIndex){
        currentOrder = Products.allOrders.get(orderIndex);

        allItems = new String[currentOrder.getAllItems().size()][3];
        int index = 0;
        int tableHeight = 0;
        for(CurrentCartItems item : currentOrder.getAllItems()){
            allItems[index] = new String[]{
                    item.getName(),
                    String.valueOf(item.getQty()),
                    String.valueOf(item.getPrice())
            };
            index++;
            tableHeight += 25;
        }

        txtLabel = new JLabel("Order Receipt #" + currentOrder.getOrderID());
        txtLabel.setFont(new Font("Copperplate", Font.BOLD, 28));
        txtLabel.setBorder(BorderFactory.createMatteBorder(0,0,3,0,Color.WHITE));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(50, 25, 290, 50);
        add(txtLabel);

        txtLabel = new JLabel("Items");
        txtLabel.setFont(new Font("Copperplate", Font.BOLD,18));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(35, 100, 100, 20);
        add(txtLabel);

        txtLabel = new JLabel("Qty");
        txtLabel.setFont(new Font("Copperplate", Font.BOLD,18));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(260, 100, 100, 20);
        add(txtLabel);

        txtLabel = new JLabel("Price");
        txtLabel.setFont(new Font("Copperplate", Font.BOLD,18));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(320, 100, 100, 20);
        add(txtLabel);

        txtLabel = new JLabel();
        txtLabel.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Color.WHITE));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(35, 125, 330, 5);
        add(txtLabel);

        itemTable = new JTable(allItems, columnNames);
        itemTable.setFont(new Font("Copperplate", Font.ITALIC, 18));
        itemTable.setRowHeight(25);
        itemTable.getColumnModel().getColumn(0).setMinWidth(230);
        itemTable.setForeground(Color.WHITE);
        itemTable.setTableHeader(null);
        itemTable.setBorder(BorderFactory.createLineBorder(primaryTheme));
        itemTable.setBackground(primaryTheme);
        itemTable.setShowVerticalLines(false);
        itemTable.setShowHorizontalLines(false);
        itemTable.setOpaque(true);
        itemTable.setEnabled(false);

        scrollPane = new JScrollPane(itemTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBackground(primaryTheme);
        scrollPane.setOpaque(true);
        scrollPane.setBorder(BorderFactory.createLineBorder(primaryTheme));
        scrollPane.setBounds(30, 135, 350, tableHeight);
        add(scrollPane);

        tableHeight += 135;

        txtLabel = new JLabel();
        txtLabel.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Color.WHITE));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(35, (tableHeight+20), 330, 5);
        add(txtLabel);

        tableHeight += 20;

        txtLabel = new JLabel("Base Total:");
        txtLabel.setFont(new Font("Copperplate", Font.ITALIC, 18));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(35, (tableHeight+30), 125, 20);
        add(txtLabel);

        txtLabel = new JLabel("$" + currentOrder.getOrderTotal());
        txtLabel.setFont(new Font("Copperplate", Font.ITALIC, 18));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(300, (tableHeight+30), 125, 20);
        add(txtLabel);

        tableHeight += 30;

        txtLabel = new JLabel("Tax:");
        txtLabel.setFont(new Font("Copperplate", Font.ITALIC, 18));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(35, (tableHeight+30), 125, 20);
        add(txtLabel);

        txtLabel = new JLabel("$" + currentOrder.getOrderTax());
        txtLabel.setFont(new Font("Copperplate", Font.ITALIC, 18));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(300, (tableHeight+30), 125, 20);
        add(txtLabel);

        tableHeight += 30;

        txtLabel = new JLabel("Total Amount:");
        txtLabel.setFont(new Font("Copperplate", Font.ITALIC, 18));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(35, (tableHeight+30), 150, 20);
        add(txtLabel);

        txtLabel = new JLabel("$" + (currentOrder.getOrderTotal() + currentOrder.getOrderTax()));
        txtLabel.setFont(new Font("Copperplate", Font.ITALIC, 18));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(300, (tableHeight+30), 125, 20);
        add(txtLabel);

        tableHeight += 30;

        txtLabel = new JLabel();
        txtLabel.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Color.WHITE));
        txtLabel.setForeground(Color.WHITE);
        txtLabel.setBounds(35, (tableHeight+50), 330, 5);
        add(txtLabel);

        tableHeight += 50;

        closeReceipt = new JButton("Close");
        closeReceipt.setFont(new Font("Copperplate", Font.ITALIC, 22));
        closeReceipt.setForeground(Color.BLACK);
        closeReceipt.setBackground(new Color(33, 140, 116));
        closeReceipt.setOpaque(true);
        closeReceipt.setBounds(35, (tableHeight+50), 150, 35);
        add(closeReceipt);
        closeReceipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        printReceipt = new JButton("Print");
        printReceipt.setFont(new Font("Copperplate", Font.ITALIC, 22));
        printReceipt.setForeground(Color.BLACK);
        printReceipt.setBackground(new Color(33, 140, 116));
        printReceipt.setOpaque(true);
        printReceipt.setBounds(215, (tableHeight+50), 150, 35);
        add(printReceipt);
        printReceipt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    PDFPrinterJob printer = (PDFPrinterJob)PDFPrinterJob.getPrinterJob ();
                    printer.setPrintable (new OrderReceipt(primaryTheme, orderIndex));
                    printer.setCopies (1);
                    printer.print("./Orders/"+currentOrder.getOrderID()+".pdf");
                    dispose();
                    JOptionPane.showMessageDialog(null, "Receipt Printed Successfully");
                }
                catch (Throwable t)
                {
                    t.printStackTrace();
                }
            }
        });

        tableHeight += 50;

        setLayout(null);
        setSize(400,tableHeight+100);
        setLocation(500, 100);
        getContentPane().setBackground(primaryTheme);
        setVisible(true);
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex == 0){
            graphics.translate(100,10);
            myReceipt.print(graphics);
            myReceipt.dispose();
            return Printable.PAGE_EXISTS;
        }else{
            return Printable.NO_SUCH_PAGE;
        }
    }
}
