import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ProductList extends JPanel {
    Border normalBorder;
    TitledBorder mainBorder;
    JLabel productName, productPrice;
    Color fontColor;
    Font textFont;

    //Getting all products
    Products.Burgers[] allBurgers = Products.Burgers.values();
    Products.Pizza[] allPizza = Products.Pizza.values();
    Products.Pasta[] allPasta = Products.Pasta.values();
    Products.Shakes[] allShakes = Products.Shakes.values();

    //Mouse Hover Effect
    MouseListener hoverEffect = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            e.getComponent().setForeground(Color.RED);
            e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            String itemName, productType;
            int itemQty = 0;
            float itemPrice = 0;
            boolean isExists = false;

            productType = ((TitledBorder)((ProductList)((JLabel)e.getComponent()).getParent()).getBorder()).getTitle();
            itemName = ((JLabel)e.getComponent()).getText();

            if(productType == "Burgers"){
                for(Products.Burgers burger : allBurgers){
                    if(burger.getBurgerName() == itemName){
                        itemPrice = burger.getBurgerPrice();
                        itemQty = 1;
                        break;
                    }
                }
            }else if(productType == "Pizza"){
                for(Products.Pizza pizza : allPizza){
                    if(pizza.getPizzaName() == itemName){
                        itemPrice = pizza.getPizzaPrice();
                        itemQty = 1;
                        break;
                    }
                }
            }else if(productType == "Pasta"){
                for(Products.Pasta pasta : allPasta){
                    if(pasta.getPastaName() == itemName){
                        itemPrice = pasta.getPastaPrice();
                        itemQty = 1;
                        break;
                    }
                }
            }else{
                for(Products.Shakes shake : allShakes){
                    if(shake.getShakeName() == itemName){
                        itemPrice = shake.getShakePrice();
                        itemQty = 1;
                        break;
                    }
                }
            }

            for(CurrentCartItems cartItem : Products.cartModel.getTableData()) {
                if(cartItem.getName() == itemName) {
                    cartItem.setQty(cartItem.getQty() + 1);
                    cartItem.setPrice(cartItem.getPrice() + itemPrice);
                    Products.cartModel.cartTotal += itemPrice;
                    isExists = true;
                }
            }

            if(!isExists){
                CurrentCartItems newItem = new CurrentCartItems(itemName, itemQty, itemPrice);
                Products.cartProducts.add(newItem);
                Products.cartModel.addCartData(newItem);
                Products.cartModel.cartTotal += itemPrice;
            }
           CurrentCartItems.ourCart.updateTotalNow();
            Products.cartTable.fireTableDataChanged();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            e.getComponent().setForeground(fontColor);
        }
    };

    public ProductList(Color primaryTheme, String productType, boolean isProductPage){
        fontColor = new Color(255,255,255);
        textFont = new Font("Copperplate", Font.BOLD,22);
        if(isProductPage){
            textFont = new Font("Copperplate", Font.BOLD,24);
        }
        normalBorder = BorderFactory.createLineBorder(Color.WHITE, 3, true);
        mainBorder = BorderFactory.createTitledBorder(normalBorder, productType);
        mainBorder.setTitleFont(textFont);
        mainBorder.setTitleColor(Color.WHITE);

        if(productType == "Burgers"){
            int sizeSetup = 1;
            for(Products.Burgers burger: allBurgers){
                productName = new JLabel(burger.getBurgerName());
                productName.setBounds(20,(35 * sizeSetup),300, 25);
                if(isProductPage){
                    productName.setBounds(30,(40 * sizeSetup),350, 25);
                }
                productName.setForeground(fontColor);
                productName.setFont(textFont);
                productName.addMouseListener(hoverEffect);
                add(productName);

                productPrice = new JLabel("$" + String.valueOf(burger.getBurgerPrice()));
                productPrice.setBounds(350,(35 * sizeSetup),100, 25);
                if(isProductPage){
                    productPrice.setBounds(550,(40 * sizeSetup),100, 25);
                }
                productPrice.setForeground(fontColor);
                productPrice.setFont(textFont);
                add(productPrice);

                sizeSetup++;
            }
        }else if(productType == "Pizza"){
            int sizeSetup = 1;
            for(Products.Pizza pizza: allPizza){
                productName = new JLabel(pizza.getPizzaName());
                productName.setBounds(20,(35 * sizeSetup),300, 25);
                if(isProductPage){
                    productName.setBounds(30,(40 * sizeSetup),350, 25);
                }
                productName.setForeground(fontColor);
                productName.addMouseListener(hoverEffect);
                productName.setFont(textFont);
                add(productName);

                productPrice = new JLabel("$" + String.valueOf(pizza.getPizzaPrice()));
                productPrice.setBounds(350,(35 * sizeSetup),100, 25);
                if(isProductPage){
                    productPrice.setBounds(550,(40 * sizeSetup),100, 25);
                }
                productPrice.setForeground(fontColor);
                productPrice.setFont(textFont);
                add(productPrice);

                sizeSetup++;
            }
        }else if(productType == "Pasta"){
            int sizeSetup = 1;
            for(Products.Pasta pasta: allPasta){
                productName = new JLabel(pasta.getPastaName());
                productName.setBounds(20,(35 * sizeSetup),300, 25);
                if(isProductPage){
                    productName.setBounds(30,(40 * sizeSetup),350, 25);
                }
                productName.setForeground(fontColor);
                productName.setFont(textFont);
                productName.addMouseListener(hoverEffect);
                add(productName);

                productPrice = new JLabel("$" + String.valueOf(pasta.getPastaPrice()));
                productPrice.setBounds(350,(35 * sizeSetup),100, 25);
                if(isProductPage){
                    productPrice.setBounds(550,(40 * sizeSetup),100, 25);
                }
                productPrice.setForeground(fontColor);
                productPrice.setFont(textFont);
                add(productPrice);

                sizeSetup++;
            }
        }else{
            int sizeSetup = 1;
            for(Products.Shakes shake: allShakes){
                productName = new JLabel(shake.getShakeName());
                productName.setBounds(20,(35 * sizeSetup),300, 25);
                if(isProductPage){
                    productName.setBounds(30,(40 * sizeSetup),350, 25);
                }
                productName.setForeground(fontColor);
                productName.setFont(textFont);
                productName.addMouseListener(hoverEffect);
                add(productName);

                productPrice = new JLabel("$" + String.valueOf(shake.getShakePrice()));
                productPrice.setBounds(350,(35 * sizeSetup),100, 25);
                if(isProductPage){
                    productPrice.setBounds(550,(40 * sizeSetup),100, 25);
                }
                productPrice.setForeground(fontColor);
                productPrice.setFont(textFont);
                add(productPrice);

                sizeSetup++;
            }
        }

        setBorder(mainBorder);
        setBackground(primaryTheme);
        setLayout(null);
    }
}
