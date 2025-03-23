package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, Account accountDetails) {
        return accountRepository.findById(id).map(account -> {
            account.setUsername(accountDetails.getUsername());
            account.setPassword(accountDetails.getPassword());
            account.setFullname(accountDetails.getFullname());
            return accountRepository.save(account);
        }).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
/*
getAllAccounts(): Lấy tất cả tài khoản.

getAccountById(Long id): Lấy tài khoản theo id.

createAccount(Account account): Tạo tài khoản mới.

updateAccount(Long id, Account accountDetails): Cập nhật tài khoản.

deleteAccount(Long id): Xóa tài khoản.
 */
