package com.nhom5_TTCSN.QuanLyKhachSan.controller.quanly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.Phong;
import com.nhom5_TTCSN.QuanLyKhachSan.service.RoomService;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/quan-ly/them-phong")
    public String viewAddRoomPage(Model model) {
        model.addAttribute("phongMoi", new Phong());
        return "quanly/phong/creation";
    }

    @PostMapping("/quan-ly/them-phong")
    public String addRoom(@ModelAttribute("phongMoi") Phong phongMoi) {
        roomService.create(phongMoi);
        return "redirect:/quan-ly/phong";
    }

    @GetMapping("/quan-ly/xem-phong/{id}")
    public String viewRoom(Model model, @PathVariable("id") long maPhong) {
        Phong phong = roomService.fetchById(maPhong);
        model.addAttribute("phong", phong);
        return "quanly/phong/detail";
    }

    @GetMapping("/quan-ly/cap-nhat-phong/{id}")
    public String viewRoomUpdatePage(Model model, @PathVariable("id") long maPhong) {
        Phong phong = roomService.fetchById(maPhong);
        model.addAttribute("phong", phong);
        return "quanly/phong/update";
    }

    @PostMapping("/quan-ly/cap-nhat-phong")
    public String updateRoom(@ModelAttribute("phong") Phong phong) {
        roomService.update(phong);
        return "redirect:/quan-ly/phong";
    }

    @GetMapping("/quan-ly/xoa-phong/{id}")
    public String viewDeletionPage(Model model, @PathVariable("id") long maPhong) {
        Phong phong = roomService.fetchById(maPhong);
        model.addAttribute("phong", phong);
        return "quanly/phong/deletion";
    }

    @PostMapping("/quan-ly/xoa-phong")
    public String delete(@ModelAttribute("phong") Phong phong) {
        roomService.delete(phong);
        return "redirect:/quan-ly/phong";
    }
}
