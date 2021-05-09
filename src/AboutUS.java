import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class AboutUS extends JPanel {
    Border mainBorder;
    JLabel paragraph;
    Font paraFont;

    public AboutUS(Color primaryTheme){
        mainBorder = BorderFactory.createLineBorder(Color.WHITE, 3, true);
        paraFont = new Font("Copperplate", Font.ITALIC,36);

        String firstPara = "<html><p style='text-indent:75px;text-align:justify;'>There’s nothing cookie-cutter " +
                "about" +
                " " +
                "<span style='color:rgb(32, 191, 107);font-weight:bold;'>S.N. Fast Food Cornor.</span> Not " +
                "our pizzas" +
                ". " +
                "Not our" +
                " " +
                "people. And definitely not the way we live life. Around here, we don’t settle for anything less than" +
                " food we’re proud to serve. And we don’t just clock in. Not when we can also become our best, make " +
                "friends, and have fun while we’re at it. We’re the pizza company that lives life unboxed.</p></html>";

        paragraph = new JLabel(firstPara);
        paragraph.setFont(paraFont);
        paragraph.setForeground(Color.WHITE);
        paragraph.setBounds(50, 0, 1300, 300);
        add(paragraph);

        paragraph = new JLabel("Developed By:");
        paragraph.setFont(paraFont);
        paragraph.setForeground(Color.WHITE);
        paragraph.setBounds(50, 325, 1300, 30);
        add(paragraph);

        paragraph = new JLabel("Name 1");
        paragraph.setFont(paraFont);
        paragraph.setForeground(Color.WHITE);
        paragraph.setBounds(50, 360, 700, 30);
        add(paragraph);

        paragraph = new JLabel("Roll No");
        paragraph.setFont(paraFont);
        paragraph.setForeground(Color.WHITE);
        paragraph.setBounds(980, 360, 1300, 30);
        add(paragraph);

        paragraph = new JLabel("Name 2");
        paragraph.setFont(paraFont);
        paragraph.setForeground(Color.WHITE);
        paragraph.setBounds(50, 400, 700, 30);
        add(paragraph);

        paragraph = new JLabel("Roll No");
        paragraph.setFont(paraFont);
        paragraph.setForeground(Color.WHITE);
        paragraph.setBounds(980, 400, 1300, 30);
        add(paragraph);

        paragraph = new JLabel("Thank you, Visit Again!");
        paragraph.setFont(new Font("Copperplate", Font.ITALIC,48));
        paragraph.setForeground(Color.WHITE);
        paragraph.setBounds(450, 500, 1300, 30);
        add(paragraph);

        setBorder(mainBorder);
        setBackground(primaryTheme);
        setLayout(null);
    }
}
