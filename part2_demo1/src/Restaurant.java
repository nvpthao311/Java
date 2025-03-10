import java.util.ArrayList;
import java.util.List;

class Dish {
    private int idDish ;
    private String name;
    private double price;

    public Dish(int idDish, String name, double price) {
        this.idDish = idDish;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return idDish;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.printf("%-3d | %-20s | %.2f$\n", idDish, name, price);
    }
}

class Table {
    private int tableNumber;
    private boolean isFull;
    private List<Dish> orderedDishes;
    private boolean isPaid;

    public Table(int tableNumber){
        this.tableNumber = tableNumber;
        this.isFull = false;
        this.orderedDishes = new ArrayList<>();
        this.isPaid = false;
    }

    public void orderDish(Dish dish) {
        orderedDishes.add(dish);
        System.out.println("✔ Món " + dish.getName() + " đã được thêm vào bàn " + tableNumber);
    }

    public double calculateTotal() {
        double total = 0;
        for (Dish dish : orderedDishes) {
            total += dish.getPrice();
        }
        return total;
    }

    public void printBill() {
        System.out.println("***********************************************************************");
        System.out.println("🔹 Hóa đơn bàn " + tableNumber + "\n\n");
        System.out.printf("Name %-16s| Price %n", "", "");
        for (Dish dish : orderedDishes) {
            dish.display();
        }
        System.out.println("💰 Tổng tiền: " + calculateTotal() + " VND");
    }

    public void markAsPaid() {
        isPaid = true;
        System.out.println("💵 Bàn " + tableNumber + " đã thanh toán!");
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void markAsFull() {
        isFull = true;
        System.out.println("💵 Bàn " + tableNumber + " đã có khách!");
    }

    public boolean isFull() {
        return isFull;
    }

    public void resetTable(){
        if (isFull && isPaid) {
            this.isFull = false;
            this.orderedDishes = new ArrayList<>();
            this.isPaid = false;
            System.out.println("Bàn đã được reset!");
        } else {
            System.out.println("Không thể reset bàn! Chưa thanh toán hoặc bàn đang trống.");
        }
    }
}

class Restaurant {
    private List<Table> tables;
    private List<Dish> menu;
    private static double totalRevenue = 0;

    public Restaurant() {
        tables = new ArrayList<>();
        menu = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            tables.add(new Table(i));
        }
    }

    public void addDishToMenu(Dish dish) {
        menu.add(dish);
    }

    public void showMenu() {
        System.out.println("\n📜 MENU:");
        for (Dish dish : menu) {
            dish.display();
        }
    }

    public void orderFood(int tableNumber, int idDish) {
        Table table = tables.get(tableNumber);
        table.markAsFull();
        for (Dish dish : menu) {
            if (dish.getId() == idDish) {
                table.orderDish(dish);
                return;
            }
        }
        System.out.println("❌ Món ăn không tồn tại trong menu!");
    }

    public void printBill(int tableNumber) {
        tables.get(tableNumber).printBill();
    }

    public void processPayment(int tableNumber) {
        tables.get(tableNumber).markAsPaid();
        calculateTotalRevenue(tableNumber);
    }

    public void calculateTotalRevenue(int tableNumber) {
        totalRevenue += tables.get(tableNumber).calculateTotal();
    }

    public void calculateTotalRevenue(){
        System.out.println("\n💰 Tổng doanh thu hôm nay: " + totalRevenue + " VND");
    }


}








