import javax.swing.table.AbstractTableModel;
import java.util.*;

class CartModel extends AbstractTableModel {
    private List<CurrentCartItems> tableData = new LinkedList<CurrentCartItems>();
    private final String[] colNames = {
            "Name",
            "Qty",
            "Price",
    };
    public static float cartTotal = 0;

    public CartModel(){
        for(CurrentCartItems cartItem : Products.cartProducts){
            tableData.add(cartItem);
        }
        Products.cartModel = this;
    }

    public void addCartData(CurrentCartItems cartItem){
        tableData.add(cartItem);
        Products.cartIndex++;
    }

    public List<CurrentCartItems> getTableData(){
        return this.tableData;
    }

    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CurrentCartItems item = tableData.get(rowIndex);

        switch (columnIndex){
            case 0:
                return item.getName();
            case 1:
                return item.getQty();
            case 2:
                return "$" + item.getPrice();
        }
        return null;
    }
}
