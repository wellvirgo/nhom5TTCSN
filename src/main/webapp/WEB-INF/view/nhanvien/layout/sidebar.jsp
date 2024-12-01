<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Tính năng</div>
                    <a class="nav-link" href="/nhan-vien">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Bảng điều khiển
                    </a>

                    <a class="nav-link" href="/nhan-vien/phong">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Phòng
                    </a>

                    <a class="nav-link" href="/nhan-vien">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Thông tin khách thuê phòng
                    </a>

                    <a class="nav-link" href="/tai-khoan">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Thông tin khách đặt phòng
                    </a>

                    <a class="nav-link" href="/nhan-vien/cham-cong">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Chấm công
                    </a>

                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">Đăng nhập bởi: ${sessionScope.tenTaiKhoan}</div>
                </div>
        </nav>
    </div>