package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maDichVu;
    private double tongChiPhi;

    @ManyToOne
    @JoinColumn(name = "maKhachHang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "maHangHoa")
    private HangHoa hangHoa;

    public long getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(long maDichVu) {
        this.maDichVu = maDichVu;
    }

    public double getTongChiPhi() {
        return tongChiPhi;
    }

    public void setTongChiPhi(double tongChiPhi) {
        this.tongChiPhi = tongChiPhi;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

}
