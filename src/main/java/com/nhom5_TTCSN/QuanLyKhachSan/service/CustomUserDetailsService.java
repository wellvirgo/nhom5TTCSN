package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountService accountService;

    public CustomUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = accountService.getTaiKhoanByTenTaiKhoan(username);
        if (taiKhoan == null) {
            throw new UsernameNotFoundException("User name not found");
        }
        return new User(
                taiKhoan.getTenTaiKhoan(),
                taiKhoan.getMatKhau(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + taiKhoan.getVaiTro())));
    }

}
