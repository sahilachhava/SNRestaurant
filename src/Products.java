import java.util.ArrayList;
import java.util.List;

public class Products {
    public static CartModel cartModel;
    public static List<CurrentCartItems> cartProducts = new ArrayList<CurrentCartItems>();
    public static List<Orders> allOrders = new ArrayList<Orders>();
    public static int orderIndex = 0;
    public static int cartIndex = 0;
    public static MainFrame getMainObject;
    public static CartModel cartTable;

    //Burgers
    public enum Burgers {
        Cheese_Burger("Cheese Burger", 12),
        Double_Patty("Double Patty Burger", 14),
        Garlic_Lovers_Burger("Garlic Lover's Burger", 25),
        Turkey_Burger("Turkey Burger", 32),
        Chicken_Burger("Chicken Burger", 35);

        private String burgerName;
        private int burgerPrice;

        private Burgers(String displayName, int displayPrice){
            this.burgerName = displayName;
            this. burgerPrice = displayPrice;
        }

        public String getBurgerName(){
            return this.burgerName;
        }

        public int getBurgerPrice(){
            return this.burgerPrice;
        }
    }

    //Pizzas
    public enum Pizza {
        Margherita_Pizza("Margherita Pizza", 16),
        Cheese_Pizza("Cheese Pizza", 18),
        Veggie_Pizza("Veggie Pizza", 12),
        BBQ_Chicken_Pizza("BBQ Chicken Pizza", 25),
        Farm_House("Farm House Pizza", 20);

        private String pizzaName;
        private int pizzaPrice;

        private Pizza(String displayName, int displayPrice){
            this.pizzaName = displayName;
            this.pizzaPrice = displayPrice;
        }

        public String getPizzaName(){
            return this.pizzaName;
        }

        public int getPizzaPrice(){
            return this.pizzaPrice;
        }
    }

    //Pasta's
    public enum Pasta {
        Macaroni("Macaroni Pasta", 8),
        Spaghetti("Spaghetti Pasta", 14),
        Penne("Penne Pasta", 10),
        Farfalle("Farfalle Pasta", 15),
        Fusilli("Fusilli Pasta", 12);

        private String pastaName;
        private int pastaPrice;

        private Pasta(String displayName, int displayPrice){
            this.pastaName = displayName;
            this.pastaPrice = displayPrice;
        }

        public String getPastaName(){
            return this.pastaName;
        }

        public int getPastaPrice(){
            return this.pastaPrice;
        }
    }

    //Shakes
    public enum Shakes {
        Mango("Mango Shake", 12),
        Oreo("Oreo Shake", 20),
        KitKat("Kit-Kat Shake", 22),
        Vanilla("Vanilla Shake", 10),
        Chocalate("Chocalate Shake", 25);

        private String shakeName;
        private int shakePrice;

        private Shakes(String displayName, int displayPrice){
            this.shakeName = displayName;
            this.shakePrice = displayPrice;
        }

        public String getShakeName(){
            return this.shakeName;
        }

        public int getShakePrice(){
            return this.shakePrice;
        }
    }
}


