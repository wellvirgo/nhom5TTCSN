package com.nhom5_TTCSN.QuanLyKhachSan.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;
import com.nhom5_TTCSN.QuanLyKhachSan.service.AccountService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private AccountService accountService;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    protected String determineTargetUrl(final Authentication authentication) {
        Map<String, String> roleTargetUrlMap = new HashMap<>();
        roleTargetUrlMap.put("ROLE_CHU-KHACH-SAN", "/quan-ly");
        roleTargetUrlMap.put("ROLE_LE-TAN", "/nhan-vien");

        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (final GrantedAuthority grantedAuthority : authorities) {
            String authorityName = grantedAuthority.getAuthority();
            if (roleTargetUrlMap.containsKey(authorityName)) {
                return roleTargetUrlMap.get(authorityName);
            }
        }

        throw new IllegalStateException();
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, Authentication authentication) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        String tenTaiKhoan = authentication.getName();
        TaiKhoan taiKhoan = accountService.getTaiKhoanByTenTaiKhoan(tenTaiKhoan);
        if (taiKhoan != null) {
            session.setAttribute("tenTaiKhoan", taiKhoan.getTenTaiKhoan());
        }
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
        clearAuthenticationAttributes(request, authentication);
    }

}
