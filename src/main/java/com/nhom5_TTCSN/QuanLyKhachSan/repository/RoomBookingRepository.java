package com.nhom5_TTCSN.QuanLyKhachSan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.DatPhong;
import java.sql.Date;

@Repository
public interface RoomBookingRepository extends JpaRepository<DatPhong, Long> {
    List<DatPhong> findByNgayNhan(Date ngayNhan);
}
