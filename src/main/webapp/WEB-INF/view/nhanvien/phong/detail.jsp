<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Chi tiết phòng</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                    crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
                    integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
                    crossorigin="anonymous"></script>
                <!--css custom-->
                <link href="/nhanvien/css/style.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <div id="layoutSidenav">

                    <!--header-->
                    <jsp:include page="../layout/header.jsp" />
                    <!--header-->

                    <!--sidebar-->
                    <jsp:include page="../layout/sidebar.jsp" />
                    <!--sidebar-->

                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <ol class="breadcrumb mb-4 mt-4">
                                    <li class="breadcrumb-item"><a href="/nhan-vien">Bảng điều khiển</a></li>
                                    <li class="breadcrumb-item"><a href="/nhan-vien/phong">Phòng</a></li>
                                    <li class="breadcrumb-item active">${phong.tenPhong}</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="d-flex justify-content-between">
                                                <h3>Chi tiết phòng ${phong.tenPhong}</h3>
                                            </div>
                                            <hr>
                                            <div class="card" style="width: 60%;">
                                                <div class="card-header">
                                                    Thông tin chi tiết
                                                </div>
                                                <ul class="list-group list-group-flush">
                                                    <li class="list-group-item">Mã phòng: ${phong.maPhong}</li>
                                                    <li class="list-group-item">Tên phòng: ${phong.tenPhong} </li>
                                                    <li class="list-group-item">Loại phòng: ${phong.loaiPhong} </li>
                                                    <li class="list-group-item">
                                                        Giá phòng:
                                                        <fmt:formatNumber value="${phong.giaPhong} " type="number" />
                                                        VND
                                                    </li>
                                                    <li class="list-group-item">Mô tả: ${phong.moTa} </li>
                                                    <li class="list-group-item">Tình trạng: ${phong.tinhTrang} </li>
                                                </ul>
                                            </div>
                                            <a href="/nhan-vien/phong" class="btn btn-secondary mt-2">Quay lại</a>
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