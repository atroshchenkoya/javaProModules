package ru.otus.bank.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.bank.dao.AccountDao;
import ru.otus.bank.dao.AgreementDao;
import ru.otus.bank.entity.Account;
import ru.otus.bank.entity.Agreement;
import ru.otus.bank.service.AccountService;
import ru.otus.bank.service.AgreementService;

import java.math.BigDecimal;

public class AccountServiceImplIntegrationTest {
    AccountDao accountDao = new AccountDao();
    AgreementDao agreementDao = new AgreementDao();
    AccountService accountService = new AccountServiceImpl(accountDao);
    AgreementService agreementService = new AgreementServiceImpl(agreementDao);

    @Test
    void addAccountAndAgreementCheckThatAccountAndAgreementWasSuccessfullyAdded() {
        Account account = new Account();
        account.setId(1L);
        account.setAgreementId(2L);
        account.setType(1);
        account.setNumber("3939393");
        account.setAmount(new BigDecimal(100));

        Agreement agreement = new Agreement();
        agreement.setId(1L);
        agreement.setName("AAA");

        Agreement addedAgreement = agreementService.addAgreement("AAA");
        Account addedAccount = accountService.addAccount(addedAgreement, "3939393", 1, new BigDecimal(100));

        Assertions.assertEquals("AAA", agreementService.findByName("AAA").get().getName());
        Assertions.assertEquals(accountService.getAccounts(addedAgreement).get(0), addedAccount);
        Assertions.assertEquals(accountService.getAccounts().size(), 1);
        Assertions.assertNotNull(addedAccount.toString());
        Assertions.assertNotNull(addedAgreement.toString());
    }
}
