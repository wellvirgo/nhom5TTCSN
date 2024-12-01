package com.nhom5_TTCSN.QuanLyKhachSan.controller.nhanvien;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.DatPhong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.HoaDon;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.KhachHang;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.Phong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.ThuePhong;
import com.nhom5_TTCSN.QuanLyKhachSan.service.AccountService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.CustomerService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.EmployeeService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.InvoiceService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.RoomBookingService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.RoomRentingService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.RoomService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeRoomController {
    private final RoomService roomService;
    private final RoomBookingService roomBookingService;
    private final CustomerService customerService;
    private final AccountService accountService;
    private final EmployeeService employeeService;
    private final InvoiceService invoiceService;
    private final RoomRentingService roomRentingService;

    public EmployeeRoomController(RoomService roomService, RoomBookingService roomBookingService,
            CustomerService customerService, AccountService accountService, EmployeeService employeeService,
            InvoiceService invoiceService, RoomRentingService roomRentingService) {
        this.roomService = roomService;
        this.roomBookingService = roomBookingService;
        this.customerService = customerService;
        this.accountService = accountService;
        this.employeeService = employeeService;
        this.invoiceService = invoiceService;
        this.roomRentingService = roomRentingService;
    }

    @GetMapping("/nhan-vien/xem-phong/{id}")
    public String viewDetails(@PathVariable("id") long id, Model model) {
        Phong phong = roomService.fetchById(id);
        model.addAttribute("phong", phong);
        return "nhanvien/phong/detail";
    }

    @GetMapping("/nhan-vien/dat-phong")
    public String viewRoomBookingPage(Model model) {
        List<Phong> phongTrongs = roomService.fetchRoomByStatus("trống");
        model.addAttribute("phongTrongs", phongTrongs);
        model.addAttribute("khachHang", new KhachHang());
        return "nhanvien/datphong/roomBooking";
    }

    @PostMapping("/nhan-vien/dat-phong")
    public String inputCustomerBookingInformation(@ModelAttribute("khachHang") KhachHang khachHang,
            @RequestParam("phongDuocChon") String tenPhongDuocChon, Model model) {

        KhachHang khachHangDatPhong = customerService.handleCreateCustomer(khachHang);
        Phong phongDuocChon = roomService.fetchRoomByName(tenPhongDuocChon);
        model.addAttribute("khachHang", khachHangDatPhong);
        model.addAttribute("phong", phongDuocChon);
        model.addAttribute("datPhong", new DatPhong());
        return "nhanvien/datphong/finishRoomBooking";
    }

    @PostMapping("/nhan-vien/hoan-tat-dat-phong")
    public String finishBookingRoom(@RequestParam("tenPhong") String tenPhong,
            @RequestParam("maKhachHang") String maKhachHang,
            @ModelAttribute("datPhong") DatPhong datPhong, HttpServletRequest request,
            Model model) {
        HttpSession session = request.getSession(false);
        TaiKhoan taiKhoan = accountService.getTaiKhoanByTenTaiKhoan(session.getAttribute("tenTaiKhoan") + "");
        NhanVien nhanVien = employeeService.fetchEmployeeByAccount(taiKhoan);
        KhachHang khachHang = customerService.fetchCustomerById(Integer.valueOf(maKhachHang));
        roomBookingService.save(datPhong, tenPhong, khachHang, nhanVien);
        Phong phong = roomService.fetchRoomByName(tenPhong);
        roomService.updateStatus(phong, "được đặt");
        HoaDon hoaDon = invoiceService.create(nhanVien, khachHang, datPhong);
        model.addAttribute("hoaDon", hoaDon);
        return "nhanvien/hoadon/showBookingInvoice";
    }

    @GetMapping("/nhan-vien/thue-phong")
    public String viewRoomRentingPage(Model model) {
        List<Phong> phongTrongs = roomService.fetchRoomByStatus("trống");
        model.addAttribute("phongTrongs", phongTrongs);
        model.addAttribute("khachHang", new KhachHang());
        return "nhanvien/thuephong/roomRenting";
    }

    @PostMapping("/nhan-vien/thue-phong")
    public String inputCustomerRentingInformation(@ModelAttribute("khachHang") KhachHang khachHang,
            @RequestParam("phongDuocChon") String tenPhongDuocChon, Model model) {

        KhachHang khachHangDatPhong = customerService.handleCreateCustomer(khachHang);
        Phong phongDuocChon = roomService.fetchRoomByName(tenPhongDuocChon);
        model.addAttribute("khachHang", khachHangDatPhong);
        model.addAttribute("phong", phongDuocChon);
        model.addAttribute("thuePhong", new ThuePhong());
        return "nhanvien/thuephong/finishRoomRenting";
    }

    @PostMapping("/nhan-vien/hoan-tat-thue-phong")
    public String finishRentingRoom(@RequestParam("tenPhong") String tenPhong,
            @RequestParam("maKhachHang") String maKhachHang,
            @ModelAttribute("thuePhong") ThuePhong thuePhong, HttpServletRequest request,
            Model model) {
        HttpSession session = request.getSession(false);
        TaiKhoan taiKhoan = accountService.getTaiKhoanByTenTaiKhoan(session.getAttribute("tenTaiKhoan") + "");
        NhanVien nhanVien = employeeService.fetchEmployeeByAccount(taiKhoan);
        KhachHang khachHang = customerService.fetchCustomerById(Integer.valueOf(maKhachHang));
        roomRentingService.save(thuePhong, tenPhong, khachHang, nhanVien);
        Phong phong = roomService.fetchRoomByName(tenPhong);
        roomService.updateStatus(phong, "đang thuê");
        HoaDon hoaDon = invoiceService.create(nhanVien, khachHang, thuePhong);
        model.addAttribute("hoaDon", hoaDon);
        return "nhanvien/hoadon/showRentingInvoice";
    }
}
