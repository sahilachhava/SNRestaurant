import java.util.ArrayList;

class Orders {
    int orderID;
    float orderTotal;
    float orderTax;
    ArrayList<CurrentCartItems> allItems;

    public Orders(int orderID, float orderTotal, float orderTax, ArrayList<CurrentCartItems> items){
        this.orderID = orderID;
        this.orderTotal = orderTotal;
        this.orderTax = orderTax;
        this.allItems = items;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public float getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(float orderTax) {
        this.orderTax = orderTax;
    }

    public ArrayList<CurrentCartItems> getAllItems() {
        return allItems;
    }

    public void setAllItems(ArrayList<CurrentCartItems> allItems) {
        this.allItems = allItems;
    }
}
