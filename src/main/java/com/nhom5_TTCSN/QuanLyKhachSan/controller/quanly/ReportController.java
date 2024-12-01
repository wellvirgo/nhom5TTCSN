package com.nhom5_TTCSN.QuanLyKhachSan.controller.quanly;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.DoanhThu;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.Luong;
import com.nhom5_TTCSN.QuanLyKhachSan.service.RevenueService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.SalaryService;

@Controller
public class ReportController {

    private final RevenueService revenueService;
    private final SalaryService salaryService;

    public ReportController(RevenueService revenueService, SalaryService salaryService) {
        this.revenueService = revenueService;
        this.salaryService = salaryService;
    }

    @GetMapping("quan-ly/bao-cao/doanh-thu")
    public String showRevenue(Model model) {
        List<DoanhThu> doanhThus = revenueService.fetchAllRevenue();
        model.addAttribute("doanhThus", doanhThus);
        return "quanly/baocao/showRevenue";
    }

    @GetMapping("quan-ly/bao-cao/luong-nhan-vien")
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
}
