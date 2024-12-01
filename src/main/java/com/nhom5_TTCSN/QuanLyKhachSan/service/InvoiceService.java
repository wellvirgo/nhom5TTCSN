package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.DatPhong;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.DoanhThu;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.HoaDon;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.KhachHang;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.NhanVien;
import com.nhom5_TTCSN.QuanLyKhachSan.domain.ThuePhong;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.InvoiceRepository;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final RevenueService revenueService;

    public InvoiceService(InvoiceRepository invoiceRepository, RevenueService revenueService) {
        this.invoiceRepository = invoiceRepository;
        this.revenueService = revenueService;
    }

    public HoaDon save(HoaDon hoaDon) {
        return invoiceRepository.save(hoaDon);
    }

    public HoaDon create(NhanVien nhanVien, KhachHang khachHang, DatPhong datPhong) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setNhanVien(nhanVien);
        hoaDon.setKhachHang(khachHang);
        hoaDon.setDatPhong(datPhong);
        hoaDon.setTrangThaiThanhToan("thanh toán 50%");
        hoaDon.setTongTien(datPhong.getTongChiPhi());
        hoaDon.setThanhToanTruoc(datPhong.getTongChiPhi() * 0.5);
        Date currentDate = new Date(System.currentTimeMillis());
        hoaDon.setNgayLap(currentDate);

        if (revenueService.fetchAllRevenue().isEmpty()) {
            DoanhThu doanhThu = new DoanhThu();
            hoaDon.setDoanhThu(doanhThu);
            doanhThu.setTongDoanhThuDuTinh(hoaDon.getTongTien());
            doanhThu.setTongDoanhThuThuc(hoaDon.getThanhToanTruoc());
            revenueService.save(doanhThu);
        } else {
            DoanhThu doanhThu = revenueService.fetchAllRevenue().get(0);
            doanhThu.setTongDoanhThuDuTinh(doanhThu.getTongDoanhThuDuTinh() + hoaDon.getTongTien());
            doanhThu.setTongDoanhThuThuc(doanhThu.getTongDoanhThuThuc() + hoaDon.getThanhToanTruoc());
            hoaDon.setDoanhThu(doanhThu);
            revenueService.save(doanhThu);
        }

        return invoiceRepository.save(hoaDon);
    }

    public HoaDon create(NhanVien nhanVien, KhachHang khachHang, ThuePhong thuePhong) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setNhanVien(nhanVien);
        hoaDon.setKhachHang(khachHang);
        hoaDon.setThuePhong(thuePhong);
        hoaDon.setTrangThaiThanhToan("chưa thanh toán");
        hoaDon.setTongTien(thuePhong.getTongChiPhi());
        Date currentDate = new Date(System.currentTimeMillis());
        hoaDon.setNgayLap(currentDate);

        if (revenueService.fetchAllRevenue().isEmpty()) {
            DoanhThu doanhThu = new DoanhThu();
            hoaDon.setDoanhThu(doanhThu);
            doanhThu.setTongDoanhThuDuTinh(hoaDon.getTongTien());
            revenueService.save(doanhThu);
        } else {
            DoanhThu doanhThu = revenueService.fetchAllRevenue().get(0);
            doanhThu.setTongDoanhThuDuTinh(doanhThu.getTongDoanhThuDuTinh() + hoaDon.getTongTien());
            hoaDon.setDoanhThu(doanhThu);
            revenueService.save(doanhThu);
        }

        return invoiceRepository.save(hoaDon);
    }
}
