import java.util.ArrayList;
class ShoppingCart {
    private ItemOrder ItemOrder;
    private ArrayList<ItemOrder> orderList;
    public ShoppingCart(ItemOrder ItemOrder) {
        orderList = new ArrayList<ItemOrder>();
        this.ItemOrder = ItemOrder;
    }
    public void addArrayList(ItemOrder ItemOrder){
        orderList.add(ItemOrder);
    }
    public ArrayList<ItemOrder> getArrayList(){
        return orderList;
    }
}