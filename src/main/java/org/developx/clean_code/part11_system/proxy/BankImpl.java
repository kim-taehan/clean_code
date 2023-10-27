package org.developx.clean_code.part11_system.proxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BankImpl implements Bank {

    private List<Account> accounts;

    @Override
    public Collection<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void setAccounts(Collection<Account> accounts) {
        this.accounts = new ArrayList<>();
        for (Account account : accounts) {
            this.accounts.add(account);
        }
    }
}
