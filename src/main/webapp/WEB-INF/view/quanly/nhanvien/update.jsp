<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Cập nhật nhân viên</title>

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

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                        });
                    });
                </script>
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
                                        <div class="col-md-8 col-12 mx-auto">
                                            <h1>Cập nhật thông tin</h1>
                                            <hr>
                                            <form:form method="post" action="/quan-ly/cap-nhat-nhan-vien"
                                                modelAttribute="nhanVien" enctype="multipart/form-data">

                                                <div class="row" style="display: none;">
                                                    <div class="mb-3 col-6">
                                                        <label for="maNhanVien" class="form-label label">Mã nhân
                                                            viên</label>
                                                        <form:input type="text" path="maNhanVien" id="maNhanVien"
                                                            name="maNhanVien" class="form-control" />
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="mb-3 col-6">
                                                        <label for="soCMND" class="form-label label">Số
                                                            CMND/CCCD</label>
                                                        <form:input type="text" path="soCMND" id="soCMND" name="soCMND"
                                                            class="form-control" />
                                                    </div>

                                                    <div class="mb-3 col-6">
                                                        <label for="tenNhanVien" class="form-label label">Tên nhân
                                                            viên</label>
                                                        <form:input type="text" path="tenNhanVien" id="tenNhanVien"
                                                            name="tenNhanVien" required="required"
                                                            class="form-control" />
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="mb-3 col-6">
                                                        <label for="soDienThoai" class="form-label label">Số điện
                                                            thoại</label>
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
                                                    <div class="mb-3 col-3">
                                                        <label for="gioiTinh" class="form-label label">Giới tính</label>
                                                        <form:input type="text" path="gioiTinh" id="gioiTinh"
                                                            name="gioiTinh" class="form-control" />
                                                    </div>
                                                    <div class="mb-3 col-3">
                                                        <label for="chucVu" class="form-label label">Chức vụ</label>
                                                        <form:input type="text" class="form-control" id="chucVu"
                                                            name="chucVu" path="chucVu" />
                                                    </div>
                                                    <div class="mb-3 col-3">
                                                        <label for="caLam" class="form-label label">Ca làm</label>
                                                        <form:input type="text" class="form-control" id="caLam"
                                                            name="caLam" path="caLam" />
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="mb-3 col-3">
                                                        <label for="luongCoBan" class="form-label label">Lương cơ
                                                            bản</label>
                                                        <form:input type="number" class="form-control" id="luongCoBan"
                                                            name="luongCoBan" path="luong.luongCoBan" />
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="mb-3">
                                                        <label for="diaChi" class="form-label label">Địa chỉ</label>
                                                        <form:input type="text" class="form-control" id="diaChi"
                                                            name="diaChi" path="diaChi" />
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="mb-3 col-12 col-md-6">
                                                        <label for="avatarFile" class="form-label">Ảnh nhân viên</label>
                                                        <div class="input-group mb-3">
                                                            <input type="file" class="form-control" id="avatarFile"
                                                                accept=".png, .jpg, .jpeg" name="avatarFile">
                                                            <label class="input-group-text" for="avatarFile">Chọn
                                                                ảnh</label>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-12 mb-3">
                                                        <label for="avatarPreview">Xem trước ảnh</label>
                                                        <img alt="Avatar preview"
                                                            style="max-height: 250px; display: block;"
                                                            id="avatarPreview"
                                                            src="/images/avatars/${nhanVien.getLinkAnhNhanVien()}" />
                                                    </div>
                                                </div>

                                                <div class="d-flex gap-2">
                                                    <button type="submit" class="btn btn-warning">Cập nhật</button>
                                                    <a href="/quan-ly/nhan-vien" class="btn btn-secondary">Quay lại</a>
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