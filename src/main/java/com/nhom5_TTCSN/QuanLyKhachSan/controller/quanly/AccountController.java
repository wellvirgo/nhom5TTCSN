package com.nhom5_TTCSN.QuanLyKhachSan.controller.quanly;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;
import com.nhom5_TTCSN.QuanLyKhachSan.service.AccountService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.EmployeeService;

@Controller
public class AccountController {
    private final AccountService accountService;
    private final EmployeeService employeeService;
    private final PasswordEncoder passwordEncoder;

    public AccountController(AccountService accountService, EmployeeService employeeService,
            PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/quan-ly/them-tai-khoan")
    public String toCreationPage(Model model) {
        model.addAttribute("taiKhoan", new TaiKhoan());
        return "quanly/taikhoan/creation";
    }

    @PostMapping("/quan-ly/them-tai-khoan")
    public String create(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan) {
        NhanVien nhanVien = employeeService.fetchEmployeeById(taiKhoan.getNhanVien().getMaNhanVien());
        String hashPassword = passwordEncoder.encode(taiKhoan.getMatKhau());
        taiKhoan.setMatKhau(hashPassword);
        accountService.save(taiKhoan);
        nhanVien.setTaiKhoan(taiKhoan);
        employeeService.save(nhanVien);
        return "redirect:/quan-ly/tai-khoan";
    }

    @GetMapping("/quan-ly/cap-nhat-tai-khoan/{id}")
    public String toUpdatePage(@PathVariable("id") long id, Model model) {
        TaiKhoan taiKhoan = accountService.fetchAccountById(id);
        model.addAttribute("taiKhoan", taiKhoan);
        return "quanly/taikhoan/update";
    }

    @PostMapping("/quan-ly/cap-nhat-tai-khoan")
    public String update(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan) {
        TaiKhoan taiKhoanCapNhat = accountService.fetchAccountById(taiKhoan.getMaTaiKhoan());
        String oldPassword = taiKhoanCapNhat.getMatKhau();
        if (!taiKhoan.getMatKhau().equals(oldPassword)) {
            String hashPassword = passwordEncoder.encode(taiKhoan.getMatKhau());
            taiKhoanCapNhat.setMatKhau(hashPassword);
        }
        taiKhoanCapNhat.setVaiTro(taiKhoan.getVaiTro());
        accountService.save(taiKhoan);
        return "redirect:/quan-ly/cap-nhat-tai-khoan/" + taiKhoan.getMaTaiKhoan();
    }

    @GetMapping("/quan-ly/xoa-tai-khoan/{id}")
    public String toDeletionPage(@PathVariable("id") long id, Model model) {
        TaiKhoan taiKhoan = accountService.fetchAccountById(id);
        model.addAttribute("taiKhoan", taiKhoan);
        return "quanly/taikhoan/deletion";
    }

    @PostMapping("/quan-ly/xoa-tai-khoan")
    public String delete(@ModelAttribute("taiKhoan") TaiKhoan taiKhoan) {
        TaiKhoan taiKhoanXoa = accountService.fetchAccountById(taiKhoan.getMaTaiKhoan());
        accountService.delete(taiKhoanXoa);
        return "redirect:/quan-ly/tai-khoan";
    }

    @GetMapping("/quan-ly/xem-tai-khoan/{id}")
    public String viewDetails(@PathVariable("id") long id, Model model) {
        TaiKhoan taiKhoan = accountService.fetchAccountById(id);
        NhanVien nhanVien = employeeService.fetchEmployeeByAccount(taiKhoan);
        model.addAttribute("taiKhoan", taiKhoan);
        model.addAttribute("nhanVien", nhanVien);
        return "quanly/taikhoan/detail";
    }
}
