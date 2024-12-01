package com.nhom5_TTCSN.QuanLyKhachSan.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maPhong;
    private String tenPhong;
    private String loaiPhong;
    private double giaPhong;
    private String tinhTrang;
    @Column(columnDefinition = "MEDIUMTEXT")
    private String moTa;

    @OneToMany(mappedBy = "phong")
    private List<DatPhong> datPhongs;

    @OneToMany(mappedBy = "phong")
    private List<ThuePhong> thuePhongs;

    public long getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(long maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

}
