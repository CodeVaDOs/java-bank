package service;

import dao.AbstractDao;
import dao.AccountDao;
import entity.Account;
import entity.User;

import java.util.Optional;

public class AccountService {
    private AbstractDao<Account> dao = new AccountDao();

    public Account createAccount(String name) {
        Account account = new Account(name);
        return dao.save(account);
    }

    public Optional<Account> setHolder(Long accountId, User holder) {
        return dao.getById(accountId)
                .map(a -> {
                    a.setHolder(holder);
                    return dao.save(a);
                });
    }
}
