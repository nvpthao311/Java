package RestaurantManagement;

import ExcelWriteRead.ExcelWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rm {
    private List<Merchandise> items;
    private static int totalOfItems;

    public Rm(){
        this.items = new ArrayList<>();
        totalOfItems = 0;
    }

    public List<Merchandise> getItems() {
        return items;
    }

    public static int getTotalOfItems() {
        return totalOfItems;
    }

    public void AddItem (Merchandise item){
        items.add(item);
        totalOfItems++;
        System.out.println("Đã thêm thành công!!!");
    }

    public void RemoveItem (int id){
        for (Merchandise item : items){
            if(id == item.getId()){
                System.out.println(item.toString());
                items.remove(item);
                System.out.println("Đã xóa thành công!!!");
            }else {
                System.out.println("Không tồn tại sảm phẩm này!!!");
            }
        }
    }

//    public void editItem(int id, int state){
//        Scanner scanner = new Scanner();
//
//        for (Merchandise item : items){
//            if (id == item.getId()){
//                switch (state){
//                    case 1:
//                        System.out.println("Đổi tên sản phẩm từ " +item.getName()+ " thành: ");
//                        item.setName(scanner.next());
//                        break;
//                    case 2:
//                        System.out.println("");
//                }
//            }else {
//                System.out.println("Không tồn tại sản phẩm này!!!");
//            }
//        }
//        scanner.close();
//
//    }

}
