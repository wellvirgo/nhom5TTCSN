<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Thêm nhân viên</title>
                <!--link to bootstrap-->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous">
                <!--css custom-->
                <link href="/quanly/css/style.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
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
                                    <form:form method="post" action="/quan-ly/them-nhan-vien" modelAttribute="nhanVien"
                                        enctype='multipart/form-data'>
                                        <h2 class="mb-3 text-primary">Nhập thông tin</h2>

                                        <div class="row">
                                            <div class="mb-3 col-6">
                                                <label for="soCMND" class="form-label label">Số CMND/CCCD</label>
                                                <form:input type="text" path="soCMND" id="soCMND" name="soCMND"
                                                    class="form-control" />
                                            </div>

                                            <div class="mb-3 col-6">
                                                <label for="tenNhanVien" class="form-label label">Tên nhân viên</label>
                                                <form:input type="text" path="tenNhanVien" id="tenNhanVien"
                                                    name="tenNhanVien" required="required" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="mb-3 col-6">
                                                <label for="soDienThoai" class="form-label label">Số điện thoại</label>
                                                <form:input type="text" path="soDienThoai" id="soDienThoai"
                                                    name="soDienThoai" class="form-control" />
                                            </div>
                                            <div class="mb-3 col-6">
                                                <label for="email" class="form-label label">Email</label>
                                                <form:input type="email" path="email" id="email" name="email"
                                                    class="form-control" />
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="mb-3 col-3">
                                                <label for="ngaySinh" class="form-label label">Ngày sinh</label>
                                                <form:input type="date" class="form-control" id="ngaySinh"
                                                    name="ngaySinh" path="ngaySinh" />
                                            </div>
                                            <div class="mb-3 col-2">
                                                <label for="gioiTinh" class="form-label label">Giới tính</label>
                                                <form:input type="text" path="gioiTinh" id="gioiTinh" name="gioiTinh"
                                                    class="form-control" />
                                            </div>
                                            <div class="mb-3 col-2">
                                                <label for="chucVu" class="form-label label">Chức vụ</label>
                                                <form:input type="text" class="form-control" id="chucVu" name="chucVu"
                                                    path="chucVu" />
                                            </div>
                                            <div class="mb-3 col-2">
                                                <label for="caLam" class="form-label label">Ca làm</label>
                                                <form:input type="text" class="form-control" id="caLam" name="caLam"
                                                    path="caLam" />
                                            </div>
                                            <div class="mb-3 col-3">
                                                <label for="luongCoBan" class="form-label label">Lương cơ bản</label>
                                                <input type="number" class="form-control" id="luongCoBan"
                                                    name="luongCoBan" />
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="mb-3">
                                                <label for="diaChi" class="form-label label">Địa chỉ</label>
                                                <form:input type="text" class="form-control" id="diaChi" name="diaChi"
                                                    path="diaChi" />
                                            </div>
                                        </div>

                                        <div class="mb-3 col-12 col-md-6">
                                            <label for="avatarFile" class="form-label">Ảnh nhân viên</label>
                                            <div class="input-group mb-3">
                                                <input type="file" class="form-control" id="avatarFile"
                                                    accept=".png, .jpg, .jpeg" name="avatarFile">
                                                <label class="input-group-text" for="avatarFile">Chọn ảnh</label>
                                            </div>
                                        </div>
                                        <div class="col-12 mb-3">
                                            <label for="avatarPreview">Xem trước ảnh</label>
                                            <img alt="Avatar preview" style="max-height: 250px; display: none;"
                                                id="avatarPreview" />
                                        </div>

                                        <button class="btn btn-warning" type="submit">Thêm</button>
                                        <a href="/quan-ly/nhan-vien" class="btn btn-dark">Quay lại</a>
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