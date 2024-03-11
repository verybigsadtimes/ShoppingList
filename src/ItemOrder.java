class ItemOrder {
    private Item item;
    private int amnt;
    public ItemOrder(Item item, int amnt) {
        this.item = item;
        this.amnt = amnt;
    }
    public Item getItem() {
        return item;
    }
    public int getAmnt() {
        return amnt;
    }
    public void setAmnt(int Amnt){this.amnt = Amnt;}

}