package com.nhom5_TTCSN.QuanLyKhachSan.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String toLoginPage() {
        return "auth/login";
    }

    @GetMapping("/access-denied")
    public String denyAccess() {
        return "auth/deny";
    }
}