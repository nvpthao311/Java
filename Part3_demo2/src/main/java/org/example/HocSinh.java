package org.example;

public class HocSinh {
    private int maSinhVien;
    private String hoVaTen;
    private int ngaySinh;
    private  int diemTrungBinh;

    public HocSinh setAll(int maSinhVien, String hoVaTen, int ngaySinh, int diemTrungBinh){
        this.maSinhVien = maSinhVien;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.diemTrungBinh = diemTrungBinh;
        return null;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public void setNgaySinh(int ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiemTrungBinh(int diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public int getNgaySinh() {
        return ngaySinh;
    }

    public int getDiemTrungBinh() {
        return diemTrungBinh;
    }

}
