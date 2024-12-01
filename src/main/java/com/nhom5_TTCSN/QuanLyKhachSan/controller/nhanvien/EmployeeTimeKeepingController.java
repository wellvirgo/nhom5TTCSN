package com.nhom5_TTCSN.QuanLyKhachSan.controller.nhanvien;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.Luong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.service.EmployeeService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.SalaryService;

@Controller
public class EmployeeTimeKeepingController {
    private final EmployeeService employeeService;
    private final SalaryService salaryService;

    public EmployeeTimeKeepingController(EmployeeService employeeService, SalaryService salaryService) {
        this.employeeService = employeeService;
        this.salaryService = salaryService;
    }

    @PostMapping("/nhan-vien/cham-cong")
    public String doTimeKeeping(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        NhanVien nhanVienChamCong = employeeService.fetchEmployeeById(nhanVien.getMaNhanVien());
        Luong luong = nhanVienChamCong.getLuong();
        luong.setNgayCong(luong.getNgayCong() + 1);
        luong.setTongLuong(luong.getLuongCoBan() * luong.getNgayCong());
        salaryService.save(luong);
        return "redirect:/nhan-vien";
    }

}
