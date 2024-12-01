package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.Phong;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.RoomRepository;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Phong> fetchAll() {
        return roomRepository.findAll();
    }

    public Phong create(Phong phong) {
        phong.setTinhTrang("trống");
        return roomRepository.save(phong);
    }

    public Phong fetchById(long id) {
        return roomRepository.findById(id)
                .orElseThrow();
    }

    public Phong update(Phong phong) {
        Phong phongCapNhat = fetchById(phong.getMaPhong());
        phongCapNhat.setTenPhong(phong.getTenPhong());
        phongCapNhat.setLoaiPhong(phong.getLoaiPhong());
        phongCapNhat.setGiaPhong(phong.getGiaPhong());
        phongCapNhat.setMoTa(phong.getMoTa());
        phongCapNhat.setTinhTrang(phong.getTinhTrang());

        return roomRepository.save(phongCapNhat);
    }

    public void delete(Phong phong) {
        roomRepository.delete(phong);
    }

    public List<Phong> fetchRoomByStatus(String status) {
        return roomRepository.findByTinhTrang(status);
    }

    public Phong fetchRoomByName(String name) {
        return roomRepository.findByTenPhong(name);
    }

    public Phong updateStatus(Phong phong, String status) {
        phong.setTinhTrang(status);
        return roomRepository.save(phong);
    }
}
