package com.nhom5_TTCSN.QuanLyKhachSan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhom5_TTCSN.QuanLyKhachSan.domain.TaiKhoan;
import com.nhom5_TTCSN.QuanLyKhachSan.repository.AccountRepository;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<TaiKhoan> fetchListAccount() {
        return accountRepository.findAll().stream()
                .filter(account -> !account.getTenTaiKhoan().equals("") && !account.getMatKhau().equals(""))
                .toList();
    }

    public TaiKhoan save(TaiKhoan taiKhoan) {
        return accountRepository.save(taiKhoan);
    }

    public TaiKhoan fetchAccountById(long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    public void delete(TaiKhoan taiKhoan) {
        TaiKhoan taiKhoanXoa = fetchAccountById(taiKhoan.getMaTaiKhoan());
        taiKhoanXoa.setTenTaiKhoan("");
        taiKhoan.setMatKhau("");
        accountRepository.save(taiKhoanXoa);
    }

    public TaiKhoan getTaiKhoanByTenTaiKhoan(String tenTaiKhoan) {
        return accountRepository.findByTenTaiKhoan(tenTaiKhoan);
    }
}
