<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <html lang=" en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Hóa đơn</title>
                <!--link to bootstrap-->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
                <!--css custom-->
                <link href="/nhanvien/css/style.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <!--header-->
                <jsp:include page="../layout/header.jsp" />
                <!--header-->

                <div id="layoutSidenav">
                    <!--sidebar-->
                    <jsp:include page="../layout/sidebar.jsp" />
                    <!--sidebar-->

                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Thông tin hóa đơn</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/nhan-vien">Bảng điều khiển</a></li>
                                    <li class="breadcrumb-item active">Hóa đơn</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="d-flex justify-content-between">
                                                <h3>Hóa đơn ${hoaDon.maHoaDon}</h3>
                                                <h5>Người lập hóa đơn: ${hoaDon.nhanVien.tenNhanVien}</h5>
                                            </div>
                                            <hr>
                                            <div class="d-flex">
                                                <div class="card col-6">
                                                    <div class="card-header">
                                                        Thông tin chi tiết
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Mã hóa đơn: ${hoaDon.maHoaDon}</li>
                                                        <li class="list-group-item">Ngày lập: ${hoaDon.ngayLap} </li>

                                                        <li class="list-group-item">
                                                            Phòng: ${hoaDon.thuePhong.phong.tenPhong}
                                                            (${hoaDon.thuePhong.phong.loaiPhong})
                                                        </li>
                                                        <li class="list-group-item">
                                                            Giá phòng:
                                                            <fmt:formatNumber
                                                                value="${hoaDon.thuePhong.phong.giaPhong} "
                                                                type="number" />
                                                            VND
                                                        </li>
                                                        <li class="list-group-item">Ngày nhận:
                                                            ${hoaDon.thuePhong.ngayNhan}
                                                        </li>
                                                        <li class="list-group-item">Ngày trả:
                                                            ${hoaDon.thuePhong.ngayTra}
                                                        </li>
                                                        <li class="list-group-item">
                                                            Tổng tiền:
                                                            <fmt:formatNumber value="${hoaDon.tongTien} "
                                                                type="number" />
                                                            VND
                                                        </li>
                                                        <li class="list-group-item">
                                                            Trạng thái thanh toán: ${hoaDon.trangThaiThanhToan}
                                                        </li>
                                                        <li class="list-group-item">
                                                            Thanh toán trước:
                                                            <fmt:formatNumber value="${hoaDon.thanhToanTruoc} "
                                                                type="number" />
                                                            VND
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="col-1"></div>
                                                <div class="card col-5">
                                                    <div class="card-header">
                                                        Thông tin khách hàng
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Mã khách hàng:
                                                            ${hoaDon.khachHang.maKhachHang}</li>
                                                        <li class="list-group-item">Tên khách hàng:
                                                            ${hoaDon.khachHang.tenKhachHang}</li>
                                                        <li class="list-group-item">Số điện thoại:
                                                            ${hoaDon.khachHang.soDienThoai}</li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                        <!--footer-->
                        <jsp:include page="../layout/footer.jsp" />
                        <!--footer-->
                    </div>
                </div>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/nhanvien/js/scripts.js"></script>
            </body>

            </html>