package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DanhSachLop danhSachLop = new DanhSachLop();

        danhSachLop.ThemHocSinh(new HocSinh().setAll(125485, "thi", 25122015, 8));
        danhSachLop.ThemHocSinh(new HocSinh().setAll(121212, "mach", 25122015, 5));
        danhSachLop.ThemHocSinh(new HocSinh().setAll(131313, "lan", 25122015, 9));
        danhSachLop.ThemHocSinh(new HocSinh().setAll(542152, "tuan", 25122015, 9));
        danhSachLop.ThemHocSinh(new HocSinh().setAll(415178, "nhung", 25122015, 6));
        danhSachLop.ThemHocSinh(new HocSinh().setAll(859689, "minh", 25122015, 7));

        while (true) {
            System.out.println("===========================================================");
            System.out.println("Danh sach cac chuc nang");
            System.out.println("1. Them sinh vien vao danh sach.");
            System.out.println("2. Kiem tra danh sach co trong hay khong.");
            System.out.println("3. Lay so luong sinh vien trong danh sach");
            System.out.println("4. Lam rong danh sach sinh vien.");
            System.out.println("5. kiem tra sinh vien bang ma sinh vien");
            System.out.println("6. Xoa mot sinh vien ra khoi danh sach.");
            System.out.println("7. Tim kiem tat ca cac sinh vien dua tren Ten.");
            System.out.println("8. Xuat ra danh sach sinh vien co diem tu cao xuong thap.");
            System.out.println("9. Thoat khoi chuong trinh.");
            System.out.println("============================================================");

            int state = scanner.nextInt();
            switch (state) {
                case 1:
                    danhSachLop.ThemHocSinh();
                    break;
                case 2:
                    danhSachLop.CoRong();
                    break;
                case 3:
                    danhSachLop.TongSoSinhVien();
                    break;
                case 4:
                    danhSachLop.LamRongDanhSach();
                    break;
                case 5:
                    danhSachLop.TraMaSV();
                    break;
                case 6:
                    danhSachLop.XoaSinhVien();
                    break;
                case 7:
                    danhSachLop.TraTen();
                    break;
                case 8:
                    danhSachLop.XuatDanhSach();
                    break;
                case 9:
                    System.out.println("BYE");
                    return;
                default:
                    System.out.println("Gia tri nay khong hop le vui long nhap lai!!!");
                    break;
            }
        }
    }
}

