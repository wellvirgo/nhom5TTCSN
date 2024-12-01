package com.nhom5_TTCSN.QuanLyKhachSan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.KhachHang;

@Repository
public interface CustomerRepository extends JpaRepository<KhachHang, Long> {
    KhachHang findBySoCMND(String soCMND);
}