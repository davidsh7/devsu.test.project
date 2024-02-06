package com.devsu.test.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devsu.test.domain.models.Account;

/**
 * The Interface AccountContext.
 */
@Repository
public interface AccountContext extends JpaRepository<Account, Long> {
    
    /**
     * Find by number and type.
     *
     * @param accountNumber the account number
     * @param accountType the account type
     * @return the account
     */
    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber AND a.accountType = :accountType")
    Account findByNumberAndType(@Param("accountNumber") String accountNumber, @Param("accountType") String accountType);
}
