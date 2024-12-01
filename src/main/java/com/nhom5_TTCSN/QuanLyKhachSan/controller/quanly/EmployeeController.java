package com.nhom5_TTCSN.QuanLyKhachSan.controller.quanly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.service.EmployeeService;
import com.nhom5_TTCSN.QuanLyKhachSan.service.UpFileService;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    private final UpFileService upFileService;

    private EmployeeController(EmployeeService employeeService, UpFileService upFileService) {
        this.employeeService = employeeService;
        this.upFileService = upFileService;
    }

    @GetMapping("/quan-ly/them-nhan-vien")
    public String toAddPage(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        return "quanly/nhanvien/creation";
    }

    @PostMapping("/quan-ly/them-nhan-vien")
    public String create(@ModelAttribute("nhanVien") NhanVien nhanVien,
            @RequestParam("avatarFile") MultipartFile file, @RequestParam("luongCoBan") double luongCoBan) {
        String linkImage = upFileService.handleUpFile(file, "avatars");
        nhanVien.setLinkAnhNhanVien(linkImage);
        employeeService.save(nhanVien, luongCoBan);
        return "redirect:/quan-ly/nhan-vien";
    }

    @GetMapping("/quan-ly/thong-tin-nhan-vien/{id}")
    public String viewDetails(@PathVariable("id") long id, Model model) {
        NhanVien nhanVien = employeeService.fetchEmployeeById(id);
        model.addAttribute("nhanVien", nhanVien);
        return "quanly/nhanvien/detail";
    }

    @GetMapping("/quan-ly/cap-nhat-nhan-vien/{id}")
    public String toUpdatePage(Model model, @PathVariable("id") long id) {
        NhanVien nhanVien = employeeService.fetchEmployeeById(id);
        model.addAttribute("nhanVien", nhanVien);
        return "quanly/nhanvien/update";
    }

    @PostMapping("/quan-ly/cap-nhat-nhan-vien")
    public String update(@ModelAttribute("nhanVien") NhanVien nhanVien,
            @RequestParam("avatarFile") MultipartFile file) {
        if (!file.isEmpty()) {
            String linkImage = upFileService.handleUpFile(file, "avatars");
            nhanVien.setLinkAnhNhanVien(linkImage);
        }
        employeeService.update(nhanVien);
        return "redirect:/quan-ly/thong-tin-nhan-vien/" + nhanVien.getMaNhanVien();
    }

    @GetMapping("/quan-ly/xoa-nhan-vien/{id}")
    public String toDeletionPage(@PathVariable("id") long maNhanVien, Model model) {
        NhanVien nhanVien = employeeService.fetchEmployeeById(maNhanVien);
        model.addAttribute("nhanVien", nhanVien);
        return "quanly/nhanvien/deletion";
    }

    @PostMapping("/quan-ly/xoa-nhan-vien")
    public String delete(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        employeeService.delete(nhanVien);
        return "redirect:/quan-ly/nhan-vien";
    }
}
