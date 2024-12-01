package com.nhom5_TTCSN.QuanLyKhachSan.controller.quanly;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.Phong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;
import com.nhom5_TTCSN.QuanLyKhachSan.service.AccountService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.EmployeeService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.RoomService;

@Controller
public class DashBoardController {

    private final RoomService roomService;
    private final EmployeeService employeeService;
    private final AccountService accountService;

    public DashBoardController(RoomService roomService, EmployeeService employeeService,
            AccountService accountService) {
        this.roomService = roomService;
        this.employeeService = employeeService;
        this.accountService = accountService;
    }

    @GetMapping("/quan-ly")
    public String viewDashBoard() {
        return "quanly/dashboard";
    }

    @GetMapping("/quan-ly/phong")
    public String viewListRoom(Model model) {
        List<Phong> rooms = roomService.fetchAll();
        model.addAttribute("phongs", rooms);
        return "quanly/phong/show";
    }

    @GetMapping("/quan-ly/nhan-vien")
    public String viewListEmployee(Model model) {
        List<NhanVien> employees = employeeService.fetchListEmployee();
        model.addAttribute("nhanViens", employees);
        return "quanly/nhanvien/show";
    }

    @GetMapping("quan-ly/tai-khoan")
    public String viewListAccount(Model model) {
        List<TaiKhoan> taiKhoans = accountService.fetchListAccount();
        model.addAttribute("taiKhoans", taiKhoans);
        return "quanly/taikhoan/show";
    }
}
