package com.nhom5_TTCSN.QuanLyKhachSan.controller.nhanvien;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.NgayLam;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.Phong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;
import com.nhom5_TTCSN.QuanLyKhachSan.service.AccountService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.EmployeeService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.RoomService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.WorkingDayService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeDashBoardController {
    private final RoomService roomService;
    private final AccountService accountService;
    private final EmployeeService employeeService;
    private final WorkingDayService workingDayService;

    public EmployeeDashBoardController(RoomService roomService, AccountService accountService,
            EmployeeService employeeService, WorkingDayService workingDayService) {
        this.roomService = roomService;
        this.accountService = accountService;
        this.employeeService = employeeService;
        this.workingDayService = workingDayService;
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
        HttpSession session = request.getSession(false);
        TaiKhoan taiKhoan = accountService.getTaiKhoanByTenTaiKhoan(session.getAttribute("tenTaiKhoan") + "");
        NhanVien nhanVien = employeeService.fetchEmployeeByAccount(taiKhoan);
        Date currentDate = new Date(System.currentTimeMillis());
        List<NgayLam> ngayLams = nhanVien.getNgayLams();
        boolean check = ngayLams.stream()
                .filter(ngayLam -> ngayLam.getNgayLam().getDate() == currentDate.getDate())
                .toList()
                .isEmpty();
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("ngayHienTai", currentDate);
        model.addAttribute("check", check);
        return "nhanvien/chamcong/show";
    }

    @GetMapping("/nhan-vien/notification")
    public String notifyForEmployee() {
        return "nhanvien/Notification";
    }

    @GetMapping("/nhan-vien/loc-theo-ngay")
    public String filterByTime(Model model, @RequestParam("ngayCanTim") String ngayCanTim) {
        Date date = Date.valueOf(ngayCanTim);
        List<Phong> phongs = roomService.filterRoomByDate(date);
        model.addAttribute("phongs", phongs);
        model.addAttribute("ngayCanTim", ngayCanTim);
        return "nhanvien/dashboard";
    }
}
