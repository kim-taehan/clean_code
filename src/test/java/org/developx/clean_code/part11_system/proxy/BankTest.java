package org.developx.clean_code.part11_system.proxy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @DisplayName("프록시로 객체를 생성할 수 있다")
    @Test
    void createProxyEntityTest(){
        Bank bank = (Bank) Proxy.newProxyInstance(
                Bank.class.getClassLoader(),
                new Class[]{Bank.class},
                new BankProxyHandler(new BankImpl())
        );

        Collection<Account> accounts = bank.getAccounts();
        assertThat(accounts).isNotNull();
    }
}