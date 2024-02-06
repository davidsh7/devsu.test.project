package com.devsu.test.domain.repositories;

import java.util.List;

import com.devsu.test.domain.models.Account;

/**
 * The Interface AccountRepository.
 */
public interface AccountRepository {

    /**
     * Find by id.
     *
     * @param id the id
     * @return the account
     */
    Account findById(Long id);
    
    /**
     * Find by number account and type.
     *
     * @param accountNumber the account number
     * @param accountType the account type
     * @return the account
     */
    Account findByNumberAccountAndType(String accountNumber, String accountType);

    /**
     * Find all.
     *
     * @return the list
     */
    List<Account> findAll();

    /**
     * Save.
     *
     * @param account the account
     * @return the account
     */
    Account save(Account account);

    /**
     * Delete.
     *
     * @param account the account
     */
    void delete(Account account);

}
