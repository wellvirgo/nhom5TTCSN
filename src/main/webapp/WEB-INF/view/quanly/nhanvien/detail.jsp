<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Thông tin nhân viên</title>
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

                <style>
                    .avatar {
                        width: 300px;
                        height: auto;
                        background-image: url("/images/avatars/${nhanVien.linkAnhNhanVien}");
                        background-position: center;
                        background-size: cover;
                        background-repeat: no-repeat;
                    }
                </style>
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
                                    <li class="breadcrumb-item active">Nhân viên</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="d-flex justify-content-between">
                                                <h3>Thông tin chi tiết nhân viên ${nhanVien.maNhanVien}</h3>
                                            </div>
                                            <hr>
                                            <div class="d-flex gap-5">
                                                <div class="card" style="width: 60%;">
                                                    <div class="card-header">
                                                        Thông tin chi tiết
                                                    </div>
                                                    <ul class="list-group list-group-flush">
                                                        <li class="list-group-item">Mã nhân viên: ${nhanVien.maNhanVien}
                                                        </li>
                                                        <li class="list-group-item">Tên nhân viên:
                                                            ${nhanVien.tenNhanVien}
                                                        </li>
                                                        <li class="list-group-item">Số CMND: ${nhanVien.soCMND} </li>
                                                        <li class="list-group-item">Giới tính: ${nhanVien.gioiTinh}</li>
                                                        <li class="list-group-item">Ngày sinh: ${nhanVien.ngaySinh}</li>
                                                        <li class="list-group-item">
                                                            Số điện thoại: ${nhanVien.soDienThoai}
                                                        </li>
                                                        <li class="list-group-item">Email: ${nhanVien.email} </li>
                                                        <li class="list-group-item">Địa chỉ: ${nhanVien.diaChi} </li>
                                                        <li class="list-group-item">Chức vụ: ${nhanVien.chucVu} </li>
                                                        <li class="list-group-item">Ca làm: ${nhanVien.caLam} </li>
                                                    </ul>
                                                </div>

                                                <div class="avatar"></div>
                                            </div>
                                            <a href="/quan-ly/nhan-vien" class="btn btn-secondary mt-2">Quay lại</a>
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