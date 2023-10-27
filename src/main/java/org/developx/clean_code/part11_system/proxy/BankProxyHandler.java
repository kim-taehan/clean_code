package org.developx.clean_code.part11_system.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class BankProxyHandler implements InvocationHandler {

    private Bank bank;

    public BankProxyHandler(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        if (methodName.equals("getAccounts")) {
            //..
            return new ArrayList<>();
        }
        else if (methodName.equals("setAccounts")) {
            //..
            return null;
        }
        return null;
    }
}
