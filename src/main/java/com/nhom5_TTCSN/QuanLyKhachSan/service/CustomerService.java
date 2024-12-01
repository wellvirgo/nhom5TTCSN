package com.nhom5_TTCSN.QuanLyKhachSan.service;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.KhachHang;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public KhachHang handleCreateCustomer(KhachHang khachHang) {
        if (customerRepository.findBySoCMND(khachHang.getSoCMND()) != null) {
            return customerRepository.findBySoCMND(khachHang.getSoCMND());
        }
        return customerRepository.save(khachHang);
    }

    public KhachHang fetchCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
