package org.developx.clean_code.part3_method.switchContext;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @DisplayName("COMMISSIONED 직원의 월급을 계산")
    @Test
    void calculatorPayTest(){
        // given
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee = employeeFactory.makeEmployee(EmployeeRecord.COMMISSIONED);

        Assertions.assertThat(employee.calculatorPay()).isEqualTo(10000);
    }
}