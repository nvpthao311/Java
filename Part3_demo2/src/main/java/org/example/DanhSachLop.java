package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachLop {
    Scanner scanner = new Scanner(System.in);
    private List<HocSinh> hocSinh;

    public DanhSachLop(){
        this.hocSinh = new ArrayList<>();
    }

    public  void ThemHocSinh(HocSinh hs){
        hocSinh.add(hs);
    }

    public void ThemHocSinh() {
        HocSinh hs = new HocSinh();

        System.out.println("Nhap thong tin sinh vien can them!!!");
        System.out.println("Ma sinh vien: ");
        hs.setMaSinhVien(scanner.nextInt());

        System.out.println("Ten sinh vien: ");
        hs.setHoVaTen(scanner.next());

        System.out.println("Ngay sinh: ");
        hs.setNgaySinh(scanner.nextInt());

        System.out.println("Diem trung binh: ");
        hs.setDiemTrungBinh(scanner.nextInt());

        hocSinh.add(hs);
    }

    public void CoRong() {
        boolean empty = hocSinh.isEmpty();

        if(empty){
            System.out.println("Danh sach hoc dinh hien dang TRONG");
        }else {
            System.out.println("Danh sach Sinh vien hien dang co " + hocSinh.size() + " hoc sinh.");
        }
    }

    public void TongSoSinhVien(){
        System.out.println("Danh sach Sinh vien hien dang co " + hocSinh.size() + " hoc sinh.");
    }

    public void LamRongDanhSach(){
        hocSinh.clear();
        System.out.println("Da lam rong danh sach sinh vien.");
    }

    public void TraMaSV(){
        System.out.println("Nhap ma sinh vien can tra: ");
        int msv = scanner.nextInt();

        for (HocSinh hs : hocSinh){
            if (hs.getMaSinhVien() == msv) {
                System.out.println("Co ton tai!!!");
                System.out.println("|Ma so sinh vien: " + hs.getMaSinhVien() + " |Ten: " + hs.getHoVaTen() + " |Ngay sinh: " + hs.getNgaySinh() + " |Diem trung binh: " + hs.getDiemTrungBinh());
                return;
            }
        }
        System.out.println("Khong ton tai!!!");
    }

    public void XoaSinhVien() {
        System.out.println("Ban muon xoa sinh vien o thu tu so:");
        hocSinh.remove(scanner.nextInt());
        System.out.println("Da xoa thanh cong!!!");
    }

    public void TraTen(){
        System.out.println("Nhap ten can tra: ");
        String ten = scanner.next();

        for (HocSinh hs : hocSinh){
            if (hs.getHoVaTen() == ten) {
                System.out.println("Co ton tai!!!");
                System.out.println("|Ma so sinh vien: " + hs.getMaSinhVien() + " |Ten: " + hs.getHoVaTen() + " |Ngay sinh: " + hs.getNgaySinh() + " |Diem trung binh: " + hs.getDiemTrungBinh());
            }
        }
    }

    public void XuatDanhSach(){
        System.out.println("Danh sach sinh vien.");

        for (int i=0; i < hocSinh.size(); i++){
            HocSinh hs = hocSinh.get(i);
            System.out.println("|Ma so sinh vien: " + hs.getMaSinhVien() + " |Ten: " + hs.getHoVaTen() + " |Ngay sinh: " + hs.getNgaySinh() + " |Diem trung binh: " + hs.getDiemTrungBinh());
        }

    }



}
