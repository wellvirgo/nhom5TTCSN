<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <html lang=" en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Phòng</title>
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
                                <h1 class="mt-4">Thông tin các phòng</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/nhan-vien">Bảng điều khiển</a></li>
                                    <li class="breadcrumb-item active">Phòng</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="d-flex justify-content-between">
                                                <h3>Danh sách phòng</h3>
                                            </div>
                                            <hr>
                                            <table class="table table-hover table-bordered">
                                                <thead>
                                                    <tr class="text-center">
                                                        <th scope="col">Mã phòng</th>
                                                        <th scope="col">Tên phòng</th>
                                                        <th scope="col">Loại phòng</th>
                                                        <th scope="col">Giá phòng</th>
                                                        <th scope="col">Tình trạng</th>
                                                        <th scope="col">Hành động</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="phong" items="${phongs}">
                                                        <tr>
                                                            <th class="text-center align-middle">${phong.getMaPhong()}
                                                            </th>
                                                            <td class="text-center align-middle">${phong.getTenPhong()}
                                                            </td>
                                                            <td class="text-center align-middle">${phong.getLoaiPhong()}
                                                            </td>
                                                            <td class="text-center align-middle">
                                                                <fmt:formatNumber value="${phong.getGiaPhong()}"
                                                                    type="number" /> VND
                                                            </td>
                                                            <td class="text-center align-middle">${phong.getTinhTrang()}
                                                            </td>
                                                            <td class="text-center align-middle">
                                                                <a class="btn btn-success"
                                                                    href="/nhan-vien/xem-phong/${phong.getMaPhong()}">Xem</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <!-- <nav aria-label="Page navigation example" class="mt-5">
                                <ul class="pagination justify-content-center">
                                    <li class="page-item ${currentPage eq 1 ?'disabled':''}">
                                        <a class="page-link" href="/admin/book?page=${currentPage-1}"
                                            aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                    <c:forEach begin="1" end="${totalPages}" varStatus="status">
                                        <li class="page-item ${status.index eq currentPage ?'active':''}"><a
                                                class="page-link"
                                                href="/admin/book?page=${status.index}">${status.index}</a></li>
                                    </c:forEach>
                                    <li class="page-item ${currentPage eq totalPages ?'disabled':''}">
                                        <a class="page-link" href="/admin/book?page=${currentPage+1}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav> -->
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