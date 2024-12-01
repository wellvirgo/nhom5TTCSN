<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Thêm tài khoản</title>
                <!--link to bootstrap-->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
                <!--css custom-->
                <link href="/quanly/css/style.css" rel="stylesheet" />
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
                        <div class="container mt-5">
                            <div class="row">
                                <div class="col-12 mx-auto">
                                    <form:form method="post" action="/quan-ly/them-tai-khoan" modelAttribute="taiKhoan"
                                        enctype='multipart/form-data'>
                                        <h2 class="mb-3 text-primary">Nhập thông tin</h2>

                                        <div class="row">
                                            <div class="mb-3 col-6">
                                                <label for="maNhanVien" class="form-label label">Mã nhân viên</label>
                                                <form:input type="text" path="nhanVien.maNhanVien" id="maNhanVien"
                                                    name="maNhanVien" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="mb-3 col-6">
                                                <label for="tenTaiKhoan" class="form-label label">Tên tài khoản</label>
                                                <form:input type="text" path="tenTaiKhoan" id="tenTaiKhoan"
                                                    name="tenTaiKhoan" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="mb-3 col-6">
                                                <label for="matKhau" class="form-label label">Mật khẩu</label>
                                                <form:input type="text" path="matKhau" id="matKhau" name="matKhau"
                                                    class="form-control" />
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="mb-3 col-6">
                                                <label for="vaiTro" class="form-label label">Vai trò</label>
                                                <form:select class="form-select" path="vaiTro" id="vaiTro"
                                                    name="vaiTro">
                                                    <form:option value="CHU-KHACH-SAN">
                                                        Chủ khách sạn
                                                    </form:option>
                                                    <form:option value="LE-TAN">Lễ tân</form:option>
                                                </form:select>
                                            </div>
                                        </div>

                                        <button class="btn btn-warning" type="submit">Thêm</button>
                                        <a href="/quan-ly/tai-khoan" class="btn btn-dark">Quay lại</a>
                                    </form:form>
                                </div>
                            </div>
                        </div>

                        <!--footer-->
                        <jsp:include page="../layout/footer.jsp" />
                        <!--footer-->
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/quanly/js/scripts.js"></script>

            </body>

            </html>