package com.nhom5_TTCSN.QuanLyKhachSan.controller.nhanvien;

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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeDashBoardController {
    private final RoomService roomService;
    private final AccountService accountService;
    private final EmployeeService employeeService;

    public EmployeeDashBoardController(RoomService roomService, AccountService accountService,
            EmployeeService employeeService) {
        this.roomService = roomService;
        this.accountService = accountService;
        this.employeeService = employeeService;
    }

    @GetMapping("/nhan-vien")
    public String toDashBoard(Model model) {
        List<Phong> phongs = roomService.fetchAll();
        model.addAttribute("phongs", phongs);
        return "nhanvien/dashboard";
    }

    @GetMapping("/nhan-vien/phong")
    public String viewRooms(Model model) {
        List<Phong> phongs = roomService.fetchAll();
        model.addAttribute("phongs", phongs);
        return "nhanvien/phong/show";
    }

    @GetMapping("/nhan-vien/cham-cong")
    public String toTimeKeeping(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        TaiKhoan taiKhoan = accountService.getTaiKhoanByTenTaiKhoan(session.getAttribute("tenTaiKhoan") + "");
        NhanVien nhanVien = employeeService.fetchEmployeeByAccount(taiKhoan);
        model.addAttribute("nhanVien", nhanVien);
        return "nhanvien/chamcong/show";
    }
}
