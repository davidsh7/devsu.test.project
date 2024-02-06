package com.devsu.test.infraestructure.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.devsu.test.domain.models.Account;
import com.devsu.test.domain.repositories.AccountRepository;
import com.devsu.test.infraestructure.persistence.AccountContext;

/**
 * The Class AccountRepositoryImpl.
 */
@Component
public class AccountRepositoryImpl implements AccountRepository {

    /** The account context. */
    private final AccountContext accountContext;

    /**
     * Instantiates a new account repository impl.
     *
     * @param accountContext the account context
     */
    public AccountRepositoryImpl(final AccountContext accountContext) {
        this.accountContext = accountContext;
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the account
     */
    @Override
    public Account findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return this.accountContext.findById(id).orElse(null);
    }

    /**
     * Find by number account and type.
     *
     * @param accountNumber the account number
     * @param accountType   the account type
     * @return the account
     */
    @Override
    public Account findByNumberAccountAndType(String accountNumber, String accountType) {
        return this.accountContext.findByNumberAndType(accountNumber, accountType);
    }

    /**
     * Find all.
     *
     * @return the list
     */
    @Override
    public List<Account> findAll() {
        return this.accountContext.findAll();
    }

    /**
     * Save.
     *
     * @param account the account
     * @return the account
     */
    @Override
    public Account save(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        return this.accountContext.save(account);
    }

    /**
     * Delete.
     *
     * @param account the account
     */
    @Override
    public void delete(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        this.accountContext.delete(account);
    }
}
