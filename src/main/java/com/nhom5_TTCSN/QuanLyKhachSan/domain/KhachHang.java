package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "khach_hang", uniqueConstraints = @UniqueConstraint(columnNames = { "soCMND" }))
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maKhachHang;
    private String tenKhachHang;
    private String soCMND;
    private String soDienThoai;
    private String gioiTinh;
    private String diaChi;
    private String email;
    private Date ngaySinh;

    @OneToMany(mappedBy = "khachHang")
    private List<DatPhong> datPhongs;

    @OneToMany(mappedBy = "khachHang")
    private List<ThuePhong> thuePhongs;

    @OneToMany(mappedBy = "khachHang")
    private List<DichVu> dichVus;

    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> hoaDons;

    public long getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(long maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public List<DatPhong> getDatPhong() {
        return datPhongs;
    }

    public void setDatPhong(List<DatPhong> datPhong) {
        this.datPhongs = datPhong;
    }

    public List<DatPhong> getDatPhongs() {
        return datPhongs;
    }

    public void setDatPhongs(List<DatPhong> datPhongs) {
        this.datPhongs = datPhongs;
    }

    public List<ThuePhong> getThuePhongs() {
        return thuePhongs;
    }

    public void setThuePhongs(List<ThuePhong> thuePhongs) {
        this.thuePhongs = thuePhongs;
    }

    public List<DichVu> getDichVus() {
        return dichVus;
    }

    public void setDichVus(List<DichVu> dichVus) {
        this.dichVus = dichVus;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

}
