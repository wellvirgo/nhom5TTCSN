<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <html lang=" en">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Đặt phòng</title>
                    <!--link to bootstrap-->
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
                        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                        crossorigin="anonymous">
                    <!--css custom-->
                    <link href="/nhanvien/css/style.css" rel="stylesheet" />
                    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
                        crossorigin="anonymous"></script>
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
                                    <h1 class="mt-4">Đặt phòng</h1>
                                    <ol class="breadcrumb mb-4">
                                        <li class="breadcrumb-item"><a href="/nhan-vien">Bảng điều khiển</a></li>
                                        <li class="breadcrumb-item active">Đặt phòng</li>
                                    </ol>
                                    <div class="mt-5">
                                        <div class="row">
                                            <div class="col-12 mx-auto">
                                                <div class="d-flex justify-content-between">
                                                    <h3>Thông tin đặt phòng</h3>
                                                </div>
                                                <hr>
                                                <form:form method="post" action="/nhan-vien/hoan-tat-dat-phong"
                                                    modelAttribute="datPhong">
                                                    <div class="d-flex">
                                                        <div class="col-md-4">
                                                            <h3>Nhập thông tin đặt phòng</h3>
                                                            <div class="row">
                                                                <div class="mb-3 col-6">
                                                                    <label for="tenPhong"
                                                                        class="form-label label">Phòng</label>
                                                                    <input id="tenPhong" type="text" name="tenPhong"
                                                                        value="${phong.tenPhong}" class="form-control"
                                                                        readonly />
                                                                </div>
                                                                <div class="mb-3 col-6">
                                                                    <label for="giaPhong"
                                                                        class="form-label label">Giá</label>
                                                                    <input id="giaPhong" type="text" name="giaPhong"
                                                                        value="${phong.giaPhong}" class="form-control"
                                                                        readonly />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3">
                                                                    <label for="ngayNhan" class="form-label label">Ngày
                                                                        nhận</label>
                                                                    <form:input type="date" path="ngayNhan"
                                                                        id="ngayNhan" name="ngayNhan"
                                                                        class="form-control" required="required" />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3">
                                                                    <label for="ngayTra" class="form-label label">Ngày
                                                                        trả</label>
                                                                    <form:input type="date" path="ngayTra" id="ngayTra"
                                                                        name="ngayTra" class="form-control" />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3">
                                                                    <label for="soNguoi" class="form-label label">Số
                                                                        người</label>
                                                                    <form:input type="number" path="soNguoi"
                                                                        id="soNguoi" name="soNguoi" class="form-control"
                                                                        required="required" />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3">
                                                                    <label for="tongChiPhi"
                                                                        class="form-label label">Tổng chi phí</label>
                                                                    <form:input type="number" path="tongChiPhi"
                                                                        id="tongChiPhi" name="tongChiPhi"
                                                                        class="form-control" required="required" />

                                                                    <button type="button" class="btn mt-2 bg-secondary"
                                                                        onclick="calculateCost()">Tính</button>
                                                                </div>
                                                            </div>

                                                            <button type="submit" class="btn btn-warning mt-2 mb-4">Đặt
                                                                phòng</button>
                                                        </div>
                                                        <div class="col-md-2"></div>
                                                        <div class="col-md-6">
                                                            <h3>Thông tin khách hàng</h3>
                                                            <div class="row" style="display: none;">
                                                                <div class="mb-3 col-6">
                                                                    <label for="maKhachHang" class="form-label label">Mã
                                                                        khách hàng</label>
                                                                    <input type="text" id="maKhachHang"
                                                                        name="maKhachHang" class="form-control"
                                                                        value="${khachHang.maKhachHang}" readonly />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3 col-6">
                                                                    <label for="soCMND" class="form-label label">Số
                                                                        CMND/CCCD</label>
                                                                    <input type="text" id="soCMND" name="soCMND"
                                                                        class="form-control" value="${khachHang.soCMND}"
                                                                        readonly />
                                                                </div>
                                                                <div class="mb-3 col-6">
                                                                    <label for="tenKhachHang"
                                                                        class="form-label label">Tên
                                                                        khách hàng</label>
                                                                    <input type="text" id="tenKhachHang"
                                                                        name="tenKhachHang" class="form-control"
                                                                        value="${khachHang.tenKhachHang}" readonly />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3 col-6">
                                                                    <label for="soDienThoai" class="form-label label">Số
                                                                        điện thoại</label>
                                                                    <input type="text" id="soDienThoai"
                                                                        name="soDienThoai" class="form-control"
                                                                        value="${khachHang.soDienThoai}" readonly />
                                                                </div>
                                                                <div class="mb-3 col-6">
                                                                    <label for="gioiTinh" class="form-label label">Giới
                                                                        tính</label>
                                                                    <input type="text" id="gioiTinh" name="gioiTinh"
                                                                        class="form-control"
                                                                        value="${khachHang.gioiTinh}" readonly />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3">
                                                                    <label for="diaChi" class="form-label label">Địa
                                                                        chỉ</label>
                                                                    <input type="text" id="diaChi" name="diaChi"
                                                                        class="form-control" value="${khachHang.diaChi}"
                                                                        readonly />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3">
                                                                    <label for="email"
                                                                        class="form-label label">Email</label>
                                                                    <input type="email" id="email" name="email"
                                                                        class="form-control" value="${khachHang.email}"
                                                                        readonly />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3 col-6">
                                                                    <label for="ngaySinh" class="form-label label">Ngày
                                                                        sinh</label>
                                                                    <input type="date" id="ngaySinh" name="ngaySinh"
                                                                        class="form-control"
                                                                        value="${khachHang.ngaySinh}" readonly />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form:form>
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

                    <!--My scripts-->
                    <script>
                        const giaPhong = document.getElementById("giaPhong").value;
                        function calculateCost() {
                            const ngayNhan = document.getElementById("ngayNhan").value;
                            const ngayTra = document.getElementById("ngayTra").value;

                            if (!ngayNhan || !ngayTra) {
                                alert("Vui lòng chọn ngày nhận và ngày trả phòng.");
                                return;
                            }

                            const nhan = new Date(ngayNhan);
                            const tra = new Date(ngayTra);

                            if (nhan >= tra) {
                                alert("Ngày trả phòng phải sau ngày nhận phòng.");
                                return;
                            }

                            const thoiGianThue = Math.abs(nhan - tra);
                            const soNgayThue = Math.ceil(thoiGianThue / (1000 * 60 * 60 * 24));

                            const tongChiPhi = giaPhong * soNgayThue;
                            document.getElementById("tongChiPhi").value = tongChiPhi;
                            console.log(giaPhong);
                            console.log(soNgayThue);
                            console.log(tongChiPhi);
                        }
                    </script>
                </body>

                </html>