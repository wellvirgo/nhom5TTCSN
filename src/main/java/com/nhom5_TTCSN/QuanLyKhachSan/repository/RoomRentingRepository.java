package com.nhom5_TTCSN.QuanLyKhachSan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.ThuePhong;

@Repository
public interface RoomRentingRepository extends JpaRepository<ThuePhong, Long> {

}
