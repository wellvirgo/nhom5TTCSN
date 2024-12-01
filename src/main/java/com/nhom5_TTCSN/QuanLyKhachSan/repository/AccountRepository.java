package com.nhom5_TTCSN.QuanLyKhachSan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;

@Repository
public interface AccountRepository extends JpaRepository<TaiKhoan, Long> {

    TaiKhoan findByTenTaiKhoan(String tenTaiKhoan);
}
