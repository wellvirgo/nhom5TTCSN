package com.nhom5_TTCSN.QuanLyKhachSan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;

@Repository
public interface EmployeeRepository extends JpaRepository<NhanVien, Long> {
    NhanVien findByTaiKhoan(TaiKhoan taiKhoan);
}
