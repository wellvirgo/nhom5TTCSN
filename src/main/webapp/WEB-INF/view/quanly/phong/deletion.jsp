<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Xóa phòng</title>

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
            <link href="/quanly/css/style.css" rel="stylesheet" />
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
                                <li class="breadcrumb-item"><a href="/quan-ly">Bảng điều khiển</a></li>
                                <li class="breadcrumb-item"><a href="/quan-ly/phong">Phòng</a></li>
                                <li class="breadcrumb-item active">${phong.tenPhong}</li>
                            </ol>
                            <div class="mt-5">
                                <div class="row">
                                    <div class="col-md-6 col-12 mx-auto">
                                        <h1>Xóa ${phong.tenPhong}</h1>
                                        <hr>
                                        <form:form method="post" action="/quan-ly/xoa-phong" modelAttribute="phong">
                                            <div class="mb-3" style="display: none;">
                                                <label for="maPhong" class="form-label">Mã phòng</label>
                                                <form:input type="text" class="form-control" id="maPhong"
                                                    path="maPhong" />
                                            </div>
                                            <div class="alert alert-danger" role="alert">
                                                Bạn muốn xóa phòng này?
                                            </div>
                                            <div class="d-flex gap-2">
                                                <button type="submit" class="btn btn-danger">Xóa</button>
                                                <a href="/quan-ly/phong" class="btn btn-secondary">Quay lại</a>
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
            <script src="/quanly/js/scripts.js"></script>
        </body>

        </html>