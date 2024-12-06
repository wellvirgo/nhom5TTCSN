package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.Luong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final SalaryService salaryService;

    public EmployeeService(EmployeeRepository employeeRepository,
            SalaryService salaryService) {
        this.employeeRepository = employeeRepository;
        this.salaryService = salaryService;
    }

    public List<NhanVien> fetchListEmployee() {
        return employeeRepository.findAll();
    }

    public NhanVien save(NhanVien nhanVien) {
        return employeeRepository.save(nhanVien);
    }

    public NhanVien save(NhanVien nhanVien, Double luongCoBan) {
        Luong luong = new Luong();
        luong.setLuongCoBan(luongCoBan);
        nhanVien.setLuong(luong);
        salaryService.save(luong);
        return employeeRepository.save(nhanVien);
    }

    public NhanVien fetchEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public NhanVien update(NhanVien nhanVien) {
        NhanVien nhanVienCapNhat = fetchEmployeeById(nhanVien.getMaNhanVien());
        nhanVienCapNhat.setSoCMND(nhanVien.getSoCMND());
        nhanVienCapNhat.setTenNhanVien(nhanVien.getTenNhanVien());
        nhanVienCapNhat.setSoDienThoai(nhanVien.getSoDienThoai());
        nhanVienCapNhat.setEmail(nhanVien.getEmail());
        nhanVienCapNhat.setNgaySinh(nhanVien.getNgaySinh());
        nhanVienCapNhat.setGioiTinh(nhanVien.getGioiTinh());
        nhanVienCapNhat.setChucVu(nhanVien.getChucVu());
        nhanVienCapNhat.setCaLam(nhanVien.getCaLam());
        nhanVienCapNhat.setDiaChi(nhanVien.getDiaChi());
        if (nhanVien.getLinkAnhNhanVien() != null) {
            nhanVienCapNhat.setLinkAnhNhanVien(nhanVien.getLinkAnhNhanVien());
        }

        Luong luong = nhanVienCapNhat.getLuong();
        luong.setLuongCoBan(nhanVien.getLuong().getLuongCoBan());
        nhanVienCapNhat.setLuong(luong);
        return employeeRepository.save(nhanVienCapNhat);
    }

    public void delete(NhanVien nhanVien) {
        employeeRepository.delete(nhanVien);
    }

    public NhanVien fetchEmployeeByAccount(TaiKhoan taiKhoan) {
        return employeeRepository.findByTaiKhoan(taiKhoan);
    }
}
