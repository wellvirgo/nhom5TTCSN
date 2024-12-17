<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Chấm công</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                        rel="stylesheet"
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
                    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
                        crossorigin="anonymous"></script>
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
                                        <li class="breadcrumb-item active">Chấm công</li>
                                    </ol>
                                    <div class="mt-5">
                                        <div class="row">
                                            <div class="col-12 mx-auto">
                                                <div class="d-flex justify-content-between">
                                                    <div>
                                                        <h3>Thực hiện chấm công</h3>
                                                        <strong>Ngày hiện tại: </strong> ${ngayHienTai}
                                                    </div>
                                                    <form:form method="post" action="/nhan-vien/cham-cong"
                                                        modelAttribute="nhanVien">
                                                        <div class="mb-3 col-6">
                                                            <label for="maNhanVien" class="form-label label">
                                                                Mã nhân viên
                                                            </label>
                                                            <form:input type="text" class="form-control" id="maNhanVien"
                                                                name="maNhanVien" path="maNhanVien" readonly="true" />
                                                        </div>

                                                        <c:if test="${check}">
                                                            <button type="submit" class="btn btn-primary mb-2">
                                                                Chấm công
                                                            </button>
                                                        </c:if>
                                                        <c:if test="${!check}">
                                                            <button type="submit" class="btn btn-primary mb-2" disabled
                                                                aria-disabled="true">
                                                                Chấm công
                                                            </button>
                                                        </c:if>
                                                    </form:form>
                                                </div>
                                                <hr>
                                                <div class="mt-2">
                                                    Đã chấm công:
                                                    <strong>
                                                        <fmt:formatNumber type="number"
                                                            value="${nhanVien.luong.ngayCong}" />
                                                    </strong> ngày
                                                </div>
                                                <a href="/nhan-vien" class="btn btn-secondary mt-5">Quay lại</a>
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