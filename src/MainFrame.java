import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    JLabel textLabel;
    Navigation navBar;
    FrameContent mainBody;
    DisplayProducts productScreen;
    DisplayOrders orderScreen;
    AboutUS aboutScreen;
    Color primaryTheme = new Color(64, 64, 122);
    //Color primaryTheme = new Color(32,63,255);
    MainFrame mainFrame = this;

    public MainFrame(String screenName){
        Products.getMainObject = mainFrame;
        textLabel = new JLabel("S.N. Fast Food Corner");
        textLabel.setBorder(BorderFactory.createMatteBorder(0,0,3,0, Color.WHITE));
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Copperplate", Font.BOLD,75));
        textLabel.setBounds(300,5, 890, 70);
        add(textLabel);

        navBar = new Navigation(primaryTheme, mainFrame);
        navBar.setBounds(20,90, 1400,70);
        add(navBar);

        if(screenName == "Home"){
            homeScreen();
        }else if(screenName == "Products"){
            productScreen();
        }else if(screenName == "Orders"){
            orderScreen();
        }else if(screenName == "AboutUS"){
            aboutScreen();
        }

        setLayout(null);
        setSize(1440,820);
        getContentPane().setBackground(primaryTheme);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void homeScreen(){
        mainBody = new FrameContent(primaryTheme);
        mainBody.setBounds(20, 180, 1400, 575);
        add(mainBody);
    }

    public void productScreen(){
        productScreen = new DisplayProducts(primaryTheme);
        productScreen.setBounds(20, 180, 1400, 575);
        add(productScreen);
    }

    public void orderScreen(){
        orderScreen = new DisplayOrders(primaryTheme);
        orderScreen.setBounds(20, 180, 1400, 575);
        add(orderScreen);
    }

    public void aboutScreen(){
        aboutScreen = new AboutUS(primaryTheme);
        aboutScreen.setBounds(20, 180, 1400, 575);
        add(aboutScreen);
    }
}
