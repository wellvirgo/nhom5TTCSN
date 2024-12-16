package com.nhom5_TTCSN.QuanLyKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.ThuePhong;
import java.sql.Date;

@Repository
public interface RoomRentingRepository extends JpaRepository<ThuePhong, Long> {
    List<ThuePhong> findByNgayNhan(Date ngayNhan);
}
