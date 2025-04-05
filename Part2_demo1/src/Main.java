import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();

        // Thêm món ăn vào menu
        restaurant.addDishToMenu(new Dish(1, "Bò né đặc biệt", 75000));
        restaurant.addDishToMenu(new Dish(2, "Bánh mì bò né", 60000));
        restaurant.addDishToMenu(new Dish(3, "Trứng ốp la", 20000));
        restaurant.addDishToMenu(new Dish(4, "Cà phê sữa", 25000));
        restaurant.addDishToMenu(new Dish(5, "Nước cam ép", 30000));
        restaurant.addDishToMenu(new Dish(6, "Bò né phô mai", 70000));
        restaurant.addDishToMenu(new Dish(7, "Bò né pate", 65000));
        restaurant.addDishToMenu(new Dish(8, "Sữa đậu nành", 20000));
        restaurant.addDishToMenu(new Dish(9, "Bánh mì bơ đường", 15000));
        restaurant.addDishToMenu(new Dish(10, "Trà đào cam sả", 35000));

        while (true) {
            System.out.println("\n===== Quản lý Quán Bò Né =====");
            System.out.println("1️⃣ Xem menu");
            System.out.println("2️⃣ Đặt món");
            System.out.println("3️⃣ In hóa đơn");
            System.out.println("4️⃣ Thanh toán");
            System.out.println("5️⃣ Xem doanh thu");
            System.out.println("6️⃣ Thoát");
            System.out.print("➡ Chọn chức năng: ");
            int choice = scanner.nextInt()

            switch (choice) {
                case 1:
                    restaurant.showMenu();
                    break;
                case 2:
                    System.out.print("Nhập số bàn (0-11): ");
                    int tableNumber = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    restaurant.showMenu();
                    int id;
                    do {
                        System.out.print("Nhập id món: ");
                        id = scanner.nextInt();
                        restaurant.orderFood(tableNumber, id);
                    }while (id != 0);
                    break;
                case 3:
                    System.out.print("Nhập số bàn cần in hóa đơn: ");
                    tableNumber = scanner.nextInt();
                    restaurant.printBill(tableNumber);
                    break;
                case 4:
                    System.out.print("Nhập số bàn cần thanh toán: ");
                    tableNumber = scanner.nextInt();
                    restaurant.processPayment(tableNumber);
                    break;
                case 5:
                    restaurant.calculateTotalRevenue();
                    break;
                case 6:
                    System.out.println("Hẹn gặp lại!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
