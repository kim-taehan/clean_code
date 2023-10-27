package org.developx.clean_code.part11_system.proxy;

import java.util.Collection;

public interface Bank {
    Collection<Account> getAccounts();

    void setAccounts(Collection<Account> accounts);
}
