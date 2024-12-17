package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.NgayLam;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.WorkingDayRepository;

@Service
public class WorkingDayService {
    private final WorkingDayRepository workingDayRepository;

    public WorkingDayService(WorkingDayRepository workingDayRepository) {
        this.workingDayRepository = workingDayRepository;
    }

    public NgayLam create(NhanVien nhanVien) {
        Date date = new Date(System.currentTimeMillis());
        NgayLam ngayLam = new NgayLam();
        ngayLam.setNhanVien(nhanVien);
        ngayLam.setNgayLam(date);
        return workingDayRepository.save(ngayLam);
    }
}
