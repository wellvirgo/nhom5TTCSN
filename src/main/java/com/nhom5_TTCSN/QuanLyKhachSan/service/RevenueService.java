package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.DoanhThu;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.RevenueRepository;

@Service
public class RevenueService {
    private final RevenueRepository revenueRepository;

    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public List<DoanhThu> fetchAllRevenue() {
        return revenueRepository.findAll();
    }

    public DoanhThu save(DoanhThu doanhThu) {
        return revenueRepository.save(doanhThu);
    }
}
