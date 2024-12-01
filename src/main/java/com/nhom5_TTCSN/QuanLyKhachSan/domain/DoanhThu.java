package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class DoanhThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maDoanhThu;
    private double tongDoanhThuDuTinh;
    private double tongDoanhThuThuc;

    @OneToMany(mappedBy = "doanhThu")
    private List<HoaDon> hoaDons;

    public long getMaDoanhThu() {
        return maDoanhThu;
    }

    public void setMaDoanhThu(long maDoanhThu) {
        this.maDoanhThu = maDoanhThu;
    }

    public double getTongDoanhThuDuTinh() {
        return tongDoanhThuDuTinh;
    }

    public void setTongDoanhThuDuTinh(double tongDoanhThuDuTinh) {
        this.tongDoanhThuDuTinh = tongDoanhThuDuTinh;
    }

    public double getTongDoanhThuThuc() {
        return tongDoanhThuThuc;
    }

    public void setTongDoanhThuThuc(double tongDoanhThuThuc) {
        this.tongDoanhThuThuc = tongDoanhThuThuc;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

}
