import java.io.Serializable;

class CurrentCartItems extends Products implements Serializable {
    private static final long serialVersionUID = -1115239867237033577L;
    String cartItemName;
    int cartItemQuantity;
    float cartItemPrice;
    public static Cart ourCart;


    public CurrentCartItems(String displayName, int displayQty, float displayPrice){
        this.cartItemName = displayName;
        this.cartItemQuantity = displayQty;
        this.cartItemPrice = displayPrice;
    }

    public String getName(){
        return this.cartItemName;
    }
    public int getQty(){
        return this.cartItemQuantity;
    }
    public void setQty(int newQty){
        this.cartItemQuantity = newQty;
    }
    public void setPrice(float newPrice){
        this.cartItemPrice = newPrice;
    }
    public float getPrice(){
        return this.cartItemPrice;
    }
}