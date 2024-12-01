package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class KhoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maKho;
    private String tenKho;
    private String diaChi;
    private String moTa;

    @OneToMany(mappedBy = "khoHang")
    private List<HangHoa> hangHoas;

    public long getMaKho() {
        return maKho;
    }

    public void setMaKho(long maKho) {
        this.maKho = maKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<HangHoa> getHangHoas() {
        return hangHoas;
    }

    public void setHangHoas(List<HangHoa> hangHoas) {
        this.hangHoas = hangHoas;
    }

}
