package com.nhom5_TTCSN.QuanLyKhachSan.service;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.KhachHang;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.Phong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.ThuePhong;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.RoomRentingRepository;

@Service
public class RoomRentingService {
    private final RoomRentingRepository roomRentingRepository;
    private final RoomService roomService;

    public RoomRentingService(RoomRentingRepository roomRentingRepository, RoomService roomService) {
        this.roomRentingRepository = roomRentingRepository;
        this.roomService = roomService;
    }

    public ThuePhong save(ThuePhong thuePhong, String tenPhong, KhachHang khachHang, NhanVien nhanVien) {
        Phong phong = roomService.fetchRoomByName(tenPhong);
        thuePhong.setPhong(phong);
        thuePhong.setKhachHang(khachHang);
        thuePhong.setNhanVien(nhanVien);
        return roomRentingRepository.save(thuePhong);
    }
}
