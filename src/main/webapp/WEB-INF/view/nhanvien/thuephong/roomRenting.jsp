<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <html lang=" en">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Thuê phòng</title>
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
                                    <h1 class="mt-4">Thuê phòng</h1>
                                    <ol class="breadcrumb mb-4">
                                        <li class="breadcrumb-item"><a href="/nhan-vien">Bảng điều khiển</a></li>
                                        <li class="breadcrumb-item active">Thuê phòng</li>
                                    </ol>
                                    <div class="mt-5">
                                        <div class="row">
                                            <div class="col-12 mx-auto">
                                                <div class="d-flex justify-content-between">
                                                    <h3>Danh sách phòng trống</h3>
                                                </div>
                                                <hr>
                                                <form:form method="post" action="/nhan-vien/thue-phong"
                                                    modelAttribute="khachHang">
                                                    <div class="d-flex">
                                                        <div class="col-md-4">
                                                            <select name="phongDuocChon" id="phongDuocChon"
                                                                class="form-select">
                                                                <c:forEach var="phong" items="${phongTrongs}">
                                                                    <option value="${phong.tenPhong}">
                                                                        ${phong.tenPhong} (${phong.loaiPhong})
                                                                    </option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="col-md-2"></div>
                                                        <div class="col-md-6">
                                                            <h3>Thông tin khách hàng</h3>
                                                            <div class="row">
                                                                <div class="mb-3 col-6">
                                                                    <label for="soCMND" class="form-label label">Số
                                                                        CMND/CCCD</label>
                                                                    <form:input type="text" path="soCMND" id="soCMND"
                                                                        name="soCMND" class="form-control" />
                                                                </div>
                                                                <div class="mb-3 col-6">
                                                                    <label for="tenKhachHang"
                                                                        class="form-label label">Tên
                                                                        khách hàng</label>
                                                                    <form:input type="text" path="tenKhachHang"
                                                                        id="tenKhachHang" name="tenKhachHang"
                                                                        class="form-control" />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3 col-6">
                                                                    <label for="soDienThoai" class="form-label label">Số
                                                                        điện thoại</label>
                                                                    <form:input type="text" path="soDienThoai"
                                                                        id="soDienThoai" name="soDienThoai"
                                                                        class="form-control" />
                                                                </div>
                                                                <div class="mb-3 col-6">
                                                                    <label for="gioiTinh" class="form-label label">Giới
                                                                        tính</label>
                                                                    <form:input type="text" path="gioiTinh"
                                                                        id="gioiTinh" name="gioiTinh"
                                                                        class="form-control" />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3">
                                                                    <label for="diaChi" class="form-label label">Địa
                                                                        chỉ</label>
                                                                    <form:input type="text" path="diaChi" id="diaChi"
                                                                        name="diaChi" class="form-control" />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3">
                                                                    <label for="email"
                                                                        class="form-label label">Email</label>
                                                                    <form:input type="email" path="email" id="email"
                                                                        name="email" class="form-control" />
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="mb-3 col-6">
                                                                    <label for="ngaySinh" class="form-label label">Ngày
                                                                        sinh</label>
                                                                    <form:input type="date" path="ngaySinh"
                                                                        id="ngaySinh" name="ngaySinh"
                                                                        class="form-control" />
                                                                </div>
                                                            </div>
                                                            <button type="submit" class="btn btn-warning mt-2 mb-4">Tiếp
                                                                tục</button>
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
                </body>

                </html>