package com.nhom5_TTCSN.QuanLyKhachSan.controller.quanly;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.DoanhThu;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.Luong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NgayLam;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.service.AccountService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.EmployeeService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.RevenueService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.SalaryService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.WorkingDayService;

@Controller
public class ReportController {

    private final RevenueService revenueService;
    private final SalaryService salaryService;
    private final EmployeeService employeeService;

    public ReportController(RevenueService revenueService, SalaryService salaryService,
            EmployeeService employeeService, AccountService accountService, WorkingDayService workingDayService) {
        this.revenueService = revenueService;
        this.salaryService = salaryService;
        this.employeeService = employeeService;
    }

    @GetMapping("/quan-ly/bao-cao/doanh-thu")
    public String showRevenue(Model model) {
        List<DoanhThu> doanhThus = revenueService.fetchAllRevenue();
        model.addAttribute("doanhThus", doanhThus);
        return "quanly/baocao/showRevenue";
    }

    @GetMapping("/quan-ly/bao-cao/luong-nhan-vien")
    public String showEmployeeSalary(Model model) {
        List<Luong> luongNhanViens = salaryService.fetchAllSalary();
        double quyLuong = 0;
        for (Luong luong : luongNhanViens) {
            quyLuong += luong.getTongLuong();
        }
        model.addAttribute("luongs", luongNhanViens);
        model.addAttribute("quyLuong", quyLuong);
        return "quanly/baocao/showEmployeeSalary";
    }

    @GetMapping("/quan-ly/bao-cao/ngay-lam-viec/{id}")
    public String viewListWorkingDayOfEmployee(Model model, @PathVariable("id") long maNhanVien) {
        NhanVien nhanVien = employeeService.fetchEmployeeById(maNhanVien);
        List<NgayLam> ngayLams = nhanVien.getNgayLams();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("ngayLamViecs", ngayLams);
        model.addAttribute("dateFormat", dateFormat);
        return "quanly/baocao/showWorkingDay";
    }
}
