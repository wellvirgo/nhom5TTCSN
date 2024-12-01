<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Tính năng</div>
                    <a class="nav-link" href="/quan-ly">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Bảng điều khiển
                    </a>

                    <a class="nav-link" href="/quan-ly/phong">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Phòng
                    </a>

                    <a class="nav-link" href="/quan-ly/nhan-vien">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Nhân viên
                    </a>

                    <a class="nav-link" href="/quan-ly/tai-khoan">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Tài khoản
                    </a>

                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages"
                        aria-expanded="false" aria-controls="collapsePages">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Báo cáo-thống kê
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>

                    <div class="collapse" id="collapsePages" aria-labelledby="headingTwo"
                        data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                                data-bs-target="#pagesCollapseAuth" aria-expanded="false"
                                aria-controls="pagesCollapseAuth">
                                Xem báo cáo-thống kê
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne"
                                data-bs-parent="#sidenavAccordionPages">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/quan-ly/bao-cao/doanh-thu">Doanh thu</a>
                                    <a class="nav-link" href="/quan-ly/bao-cao/luong-nhan-vien">Lương nhân viên</a>
                                </nav>
                            </div>
                        </nav>
                    </div>


                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">Đăng nhập bởi: ${sessionScope.tenTaiKhoan}</div>
                </div>
        </nav>
    </div>