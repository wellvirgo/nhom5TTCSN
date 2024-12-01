<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <html lang=" en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Lương nhân viên</title>
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
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Quản lý lương nhân viên</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/quan-ly">Bảng điều khiển</a></li>
                                    <li class="breadcrumb-item active">Lương nhân viên</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="d-flex justify-content-between">
                                                <h3>Danh sách</h3>
                                                <div>
                                                    <h5 class="text-danger">Quỹ lương:
                                                        <fmt:formatNumber type="number" value="${quyLuong}" />
                                                    </h5>
                                                </div>
                                            </div>
                                            <hr>
                                            <table class="table table-hover table-bordered">
                                                <thead>
                                                    <tr class="text-center">
                                                        <th scope="col">Mã lương</th>
                                                        <th scope="col">Mã nhân viên</th>
                                                        <th scope="col">Tên nhân viên</th>
                                                        <th scope="col">Chức vụ</th>
                                                        <th scope="col">Lương cơ bản</th>
                                                        <th scope="col">Ngày công</th>
                                                        <th scope="col">Tổng lương</th>
                                                        <th scope="col">Hành động</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="luong" items="${luongs}">
                                                        <tr>
                                                            <th class="text-center align-middle">
                                                                ${luong.maLuong}
                                                            </th>
                                                            <td class="text-center align-middle">
                                                                ${luong.nhanVien.maNhanVien}</td>
                                                            <td class="text-center align-middle">
                                                                ${luong.nhanVien.tenNhanVien}</td>
                                                            <td class="text-center align-middle">
                                                                ${luong.nhanVien.chucVu}</td>
                                                            <td class="text-center align-middle">
                                                                <fmt:formatNumber value="${luong.luongCoBan}"
                                                                    type="number" /> VND
                                                            </td>
                                                            <td class="text-center align-middle">
                                                                <fmt:formatNumber value="${luong.ngayCong}"
                                                                    type="number" />
                                                            </td>
                                                            <td class="text-center align-middle">
                                                                <fmt:formatNumber value="${luong.tongLuong}"
                                                                    type="number" /> VND
                                                            </td>
                                                            <td class="text-center align-middle">
                                                                <a class="btn btn-success"
                                                                    href="/quan-ly/thong-tin-nhan-vien/${nhanVien.getMaNhanVien()}">Xem</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
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
                <script src="/quanly/js/scripts.js"></script>
            </body>

            </html>