package Aplication;


import ExcelWriteRead.ExcelReader;
import ExcelWriteRead.ExcelWriter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import static RestaurantManagement.DateMonthYear.setDate;

public class Main {
    static File excelFile = Paths.get("").resolve("DanhSachHang.xlsx").toFile();


    public static void main(String[] args) throws IOException, InvalidFormatException {
        int[] state = {0,0};

        while (true){
            System.out.println("Chức Năng");
            System.out.println("1. Coi danh sách các món hàng.");
            System.out.println("2. Tra cứu trong danh sách.");
            System.out.println("3. Chỉnh sửa danh sách.");
            System.out.println("4. Tạo hóa đơn.");
            System.out.println("5. Đặt danh sách món ăn mặc định.");
            System.out.println("6: Thoát!");
            System.out.println("Nhập số chức năng mong muốn: ");

            Scanner scanner = new Scanner(System.in);
            try {
                state[0] = scanner.nextInt();
                if ( state[0] < 0 || 6 < state[0] ){
                    System.out.println("Yêu cầu nhập số trong khoảng từ 1 - 6 !!!");
                    continue;
                }
            }catch (Exception e){
                System.out.println("Yêu cầu nhập số trong khoảng từ 1 - 6 !!!");
                continue;
            }

            switch (state[0]){
                case 1:
                    printListItem();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    createDefineFile();
                    break;
                case 6:
                    System.out.println("Bye~~~~");
                    return;
            }
            System.out.println("*******************************************************************");

        }


    }

    public static void createDefineFile() throws IOException {
        ExcelWriter writer = new ExcelWriter(excelFile);

        writer.createHeaderRow(0,"Mã sản phẩm","Tên sản phẩm", "Giá bán", "Hạn sử dụng", "Tổng số lượng nhập", "Số hàng tồn", "Số hàng đã bán");
        writer.CreateContentRow(1, 1, "Mì gói", 5000, setDate(15,12,2025), 10000, 7852);
        writer.CreateContentRow(2, 2, "Phở gói", 8000, setDate(22,7,2026), 10000, 859);
        writer.CreateContentRow(3, 3, "Cháo gói", 3000, setDate(21,5,2025), 10000, 3852);
        writer.CreateContentRow(4, 4, "Hủ tiếu gói", 6000, setDate(30,10,2027), 10000, 1552);
        writer.CreateContentRow(5, 5, "Dầu gội", 125000, setDate(23,2,2027), 1000, 578);
        writer.CreateContentRow(6, 6, "Sữa tắm", 185000, setDate(4,8,2027), 1000, 36);
        writer.CreateContentRow(7, 7, "Bột giặt", 195000, setDate(18,9,2028), 1000, 157);
        writer.CreateContentRow(8, 9, "Nước xả", 175000, setDate(12,12,2025), 1000, 854);
        writer.CreateContentRow(9, 10, "BimBim", 12000, setDate(28,4,2025), 1000, 915);

        writer.WriteWorkBookToExcelFile();
    }



    public static void printListItem() throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader(excelFile);
        reader.readFromExcelFile();
    }

}