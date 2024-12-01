package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.DatPhong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.KhachHang;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.Phong;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.RoomBookingRepository;

@Service
public class RoomBookingService {

    private final RoomBookingRepository roomBookingRepository;
    private final RoomService roomService;

    public RoomBookingService(RoomBookingRepository roomBookingRepository, RoomService roomService) {
        this.roomBookingRepository = roomBookingRepository;
        this.roomService = roomService;
    }

    public DatPhong save(DatPhong datPhong, String tenPhong, KhachHang khachHang, NhanVien nhanVien) {
        Phong phong = roomService.fetchRoomByName(tenPhong);
        datPhong.setPhong(phong);
        datPhong.setKhachHang(khachHang);
        datPhong.setNhanVien(nhanVien);
        Date currentDate = new Date(System.currentTimeMillis());
        datPhong.setNgayDat(currentDate);
        return roomBookingRepository.save(datPhong);
    }

}
