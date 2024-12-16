<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="QuanLyKhachSan" />
                <meta name="author" content="Well" />
                <title>Bảng điều khiển</title>
                <link href="/nhanvien/css/style.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <!--Header-->
                <jsp:include page="./layout/header.jsp" />
                <!--Header-->

                <!--Content start-->
                <div id="layoutSidenav">
                    <!--Sidebar-->
                    <jsp:include page="./layout/sidebar.jsp" />
                    <!--Sidebar-->
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <div class="d-flex justify-content-between">
                                    <h1 class="mt-4">Bảng điều khiển</h1>
                                    <div class="mt-4">
                                        <form action="/nhan-vien/loc-theo-ngay" method="get">
                                            <input type="date" name="ngayCanTim" value="${ngayCanTim}">
                                            <button class="btn btn-info" type="submit">
                                                Lọc
                                            </button>
                                        </form>
                                    </div>
                                    <div>
                                        <a href="/nhan-vien/dat-phong" class="btn btn-warning my-4 mx-2">Đặt phòng</a>
                                        <a href="/nhan-vien/thue-phong" class="btn btn-primary my-4">Thuê phòng</a>
                                    </div>
                                </div>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active">Bảng điều khiển</li>
                                </ol>
                                <div class="row">
                                    <c:if test="${phongs.size()==0}">
                                        <div style="text-align: center;">
                                            <h5>Không có phòng nào</h5>
                                        </div>
                                    </c:if>
                                    <c:forEach var="phong" items="${phongs}">
                                        <c:if test="${phong.tinhTrang eq 'trống'}">
                                            <c:set var="bgColor" value="bg-success" />
                                        </c:if>
                                        <c:if test="${phong.tinhTrang eq 'được đặt'}">
                                            <c:set var="bgColor" value="bg-warning" />
                                        </c:if>
                                        <c:if test="${phong.tinhTrang eq 'đang thuê'}">
                                            <c:set var="bgColor" value="bg-danger" />
                                        </c:if>
                                        <c:if test="${phong.tinhTrang eq 'chưa dọn'}">
                                            <c:set var="bgColor" value="bg-secondary" />
                                        </c:if>

                                        <div class="col-xl-3 col-md-6">
                                            <div class="card ${bgColor} text-white mb-4">
                                                <div class="card-body">
                                                    <h5 class="card-title">${phong.getTenPhong()}</h5>
                                                    <p class="card-text">${phong.getLoaiPhong()}</p>
                                                </div>

                                                <div
                                                    class="card-footer d-flex align-items-center justify-content-between">

                                                    <a class="card-text small text-white"
                                                        style="text-decoration: none;">
                                                        <fmt:formatNumber value="${phong.getGiaPhong()}"
                                                            type="number" /> VND
                                                    </a>
                                                    <div class="small text-white">${phong.getTinhTrang()}</div>
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>
                                </div>
                            </div>
                        </main>
                        <!--Footer-->
                        <jsp:include page="./layout/footer.jsp" />
                        <!--Footer-->
                    </div>
                </div>
                <!--Content end-->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/nhanvien/js/scripts.js"></script>
            </body>

            </html>