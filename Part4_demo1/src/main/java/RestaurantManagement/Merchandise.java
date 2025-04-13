package RestaurantManagement;

public class Merchandise {
    private int id;
    private String name;
    private int price;
    private DateMonthYear date;
    private int totalStock;
    private int currentStock;
    private int itemSold;

    @Override
    public String toString() {
        return "merchandise{" +
                "currentStock=" + currentStock +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", totalStock=" + totalStock +
                ", itemSold=" + itemSold +
                '}';
    }

    public void setAll(int id, String name, int price, DateMonthYear date, int totalStock, int currentStock, int itemSold){
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.totalStock = totalStock;
        this.currentStock = currentStock;
        this.itemSold = itemSold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DateMonthYear getDate() {
        return date;
    }

    public void setDate(DateMonthYear date) {
        this.date = date;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getItemSold() {
        return itemSold;
    }

    public void setItemSold(int itemSold) {
        this.itemSold = itemSold;
    }
}
