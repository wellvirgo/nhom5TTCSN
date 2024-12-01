package com.nhom5_TTCSN.QuanLyKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.Phong;

@Repository
public interface RoomRepository extends JpaRepository<Phong, Long> {
    List<Phong> findByTinhTrang(String tinhTrang);

    Phong findByTenPhong(String tenPhong);
}
