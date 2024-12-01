<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Thêm phòng</title>
                <!--link to bootstrap-->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
                <!--css custom-->
                <link href="/quanly/css/style.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

                <!--My css-->
                <style>
                    .label {
                        color: rgb(233, 150, 42);
                    }
                </style>
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
                                    <form:form method="post" action="/quan-ly/them-phong" modelAttribute="phongMoi"
                                        enctype='multipart/form-data'>
                                        <h2 class="mb-3" style="color: burlywood;">Nhập thông tin</h2>

                                        <div class="row">
                                            <div class="mb-3 col-6">
                                                <label for="tenPhong" class="form-label label">Tên phòng</label>
                                                <form:input type="text" path="tenPhong" id="tenPhong" name="tenPhong"
                                                    class="form-control" />
                                            </div>

                                            <div class="mb-3 col-3">
                                                <label for="giaPhong" class="form-label label">Giá phòng</label>
                                                <form:input type="number" path="giaPhong" id="giaPhong" name="giaPhong"
                                                    required="required" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="mb-3">
                                            <label for="loaiPhong" class="form-label label">Loại phòng</label>
                                            <form:input type="text" path="loaiPhong" id="loaiPhong" name="loaiPhong"
                                                class="form-control" />
                                        </div>

                                        <div class="mb-3">
                                            <label for="moTa" class="form-label label">Mô tả </label>
                                            <form:textarea type="text" class="form-control" id="moTa" name="moTa"
                                                path="moTa" />
                                        </div>

                                        <button class="btn btn-warning" type="submit">Thêm</button>
                                        <a href="/quan-ly/phong" class="btn btn-dark">Quay lại</a>
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