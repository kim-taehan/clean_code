package org.developx.clean_code.part3_method.switchContext;

public class EmployeeFactory {

    public Employee makeEmployee(EmployeeRecord record) {
        return switch (record) {
            case COMMISSIONED -> new CommissionedEmployee();
            case HOURLY -> new HourlyEmployee();
            case SALARIED -> new SalariedEmployee();
        };
    }
}
