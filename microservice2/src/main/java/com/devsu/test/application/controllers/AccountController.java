package com.devsu.test.application.controllers;

import com.devsu.test.application.requests.AccountAddRequest;
import com.devsu.test.application.requests.AccountUpdateRequest;
import com.devsu.test.application.responses.AccountIdResponse;
import com.devsu.test.application.responses.AccountResponse;
import com.devsu.test.application.services.AccountService;

import jakarta.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Class AccountController.
 * 
 * @author David Sepulveda
 */
@RestController
@RequestMapping("api/accounts")
public class AccountController {

    /** The account service. */
    private final AccountService accountService;

    /**
     * Instantiates a new account controller.
     *
     * @param accountService the account service
     */
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Adds the account.
     *
     * @param request the request
     * @return the account id response
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AccountIdResponse addAccount(@Valid @RequestBody final AccountAddRequest request) {
        return this.accountService.addAccount(request);
    }

    /**
     * Gets the account.
     *
     * @param accountId the account id
     * @return the account
     */
    @GetMapping("/{id}")
    public AccountResponse getAccount(@PathVariable(value = "id") String accountId) {
        return this.accountService.getAccount(Long.parseLong(accountId));
    }

    /**
     * Gets the all accounts.
     *
     * @return the all accounts
     */
    @GetMapping
    public List<AccountResponse> getAllAccounts() {
        return this.accountService.getAllAccounts();
    }

    /**
     * Update account.
     *
     * @param request the request
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAccount(@Valid @RequestBody final AccountUpdateRequest request) {
        this.accountService.updateAccount(request);
    }

    /**
     * Delete account.
     *
     * @param accountId the account id
     */
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable(value = "id") long accountId) {
        this.accountService.deleteAccount(accountId);
    }

}