package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.Luong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.SalaryRepository;

@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public Luong save(double luongCoBan, NhanVien nhanVien) {
        Luong luong = new Luong();
        luong.setLuongCoBan(luongCoBan);
        luong.setNhanVien(nhanVien);
        return salaryRepository.save(luong);
    }

    public Luong save(Luong luong) {
        return salaryRepository.save(luong);
    }

    public List<Luong> fetchAllSalary() {
        return salaryRepository.findAll();
    }
}
