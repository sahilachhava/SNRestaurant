import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Navigation extends JPanel {
    JButton navigationBtn;
    Font navigationFonts;
    Border navigationBorder, btnBorder;
    Color btnFontColor, btnBgColor;
    MainFrame myFrame;

    MouseListener navBtnListener = new MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent e) {
            e.getComponent().setForeground(new Color(255, 82, 82));
        }
        public void mouseExited(java.awt.event.MouseEvent e) {
            e.getComponent().setForeground(Color.BLACK);
        }
    };

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Home")){
                myFrame.dispose();
                new MainFrame("Home");
            }else if(e.getActionCommand().equals("Products")){
                myFrame.dispose();
                new MainFrame("Products");
            }else if(e.getActionCommand().equals("Orders")){
                myFrame.dispose();
                new MainFrame("Orders");
            }else if(e.getActionCommand().equals("About us")){
                myFrame.dispose();
                new MainFrame("AboutUS");
            }else{
                myFrame.dispose();
                JOptionPane.showMessageDialog(null, "System Shutdown Successfully");
                System.exit(0);
            }
        }
    };

    public Navigation(Color primaryTheme, MainFrame myFrame){
        this.myFrame = myFrame;
        navigationBorder = BorderFactory.createLineBorder(Color.WHITE, 3, true);
        btnBorder = BorderFactory.createLineBorder(Color.BLACK, 3, true);
        navigationFonts = new Font("Copperplate", Font.BOLD,36);
        btnBgColor = new Color(255,255,255);
        btnFontColor = new Color(0,0,0);

        navigationBtn = new JButton("Home");
        navigationBtn.setFont(navigationFonts);
        navigationBtn.setBounds(55,10,200,50);
        navigationBtn.addMouseListener(navBtnListener);
        navigationBtn.setBackground(btnBgColor);
        navigationBtn.setForeground(btnFontColor);
        navigationBtn.setOpaque(true);
        navigationBtn.setBorder(btnBorder);
        navigationBtn.addActionListener(actionListener);
        add(navigationBtn);

        navigationBtn = new JButton("Products");
        navigationBtn.setFont(navigationFonts);
        navigationBtn.setBounds(330,10,200,50);
        navigationBtn.addMouseListener(navBtnListener);
        navigationBtn.setBackground(btnBgColor);
        navigationBtn.setForeground(btnFontColor);
        navigationBtn.setOpaque(true);
        navigationBtn.setBorder(btnBorder);
        navigationBtn.addActionListener(actionListener);
        add(navigationBtn);

        navigationBtn = new JButton("Orders");
        navigationBtn.setFont(navigationFonts);
        navigationBtn.setBounds(605,10,200,50);
        navigationBtn.addMouseListener(navBtnListener);
        navigationBtn.setBackground(btnBgColor);
        navigationBtn.setForeground(btnFontColor);
        navigationBtn.setOpaque(true);
        navigationBtn.setBorder(btnBorder);
        navigationBtn.addActionListener(actionListener);
        add(navigationBtn);

        navigationBtn = new JButton("About us");
        navigationBtn.setFont(navigationFonts);
        navigationBtn.setBounds(880,10,200,50);
        navigationBtn.addMouseListener(navBtnListener);
        navigationBtn.setBackground(btnBgColor);
        navigationBtn.setForeground(btnFontColor);
        navigationBtn.setOpaque(true);
        navigationBtn.setBorder(btnBorder);
        navigationBtn.addActionListener(actionListener);
        add(navigationBtn);

        navigationBtn = new JButton("Exit");
        navigationBtn.setFont(navigationFonts);
        navigationBtn.setBounds(1155,10,200,50);
        navigationBtn.addMouseListener(navBtnListener);
        navigationBtn.setBackground(btnBgColor);
        navigationBtn.setForeground(btnFontColor);
        navigationBtn.setOpaque(true);
        navigationBtn.setBorder(btnBorder);
        navigationBtn.addActionListener(actionListener);
        add(navigationBtn);

        setBorder(navigationBorder);
        setBackground(primaryTheme);
        setLayout(null);
    }
}
