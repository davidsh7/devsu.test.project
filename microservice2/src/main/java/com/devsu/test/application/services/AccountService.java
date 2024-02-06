package com.devsu.test.application.services;

import java.util.List;

import com.devsu.test.application.requests.AccountAddRequest;
import com.devsu.test.application.requests.AccountUpdateRequest;
import com.devsu.test.application.responses.AccountIdResponse;
import com.devsu.test.application.responses.AccountResponse;

/**
 * The Interface AccountService.
 * 
 *  @author David Sepulveda
 */
public interface AccountService {

    /**
     * Gets the account.
     *
     * @param accountId the account id
     * @return the account
     */
    AccountResponse getAccount(Long accountId);

    /**
     * Adds the account.
     *
     * @param request the request
     * @return the account id response
     */
    AccountIdResponse addAccount(AccountAddRequest request);

    /**
     * Update account.
     *
     * @param request the request
     */
    void updateAccount(AccountUpdateRequest request);

    /**
     * Gets the all accounts.
     *
     * @return the all accounts
     */
    List<AccountResponse> getAllAccounts();

    /**
     * Delete account.
     *
     * @param accountId the account id
     */
    void deleteAccount(Long accountId);

}
