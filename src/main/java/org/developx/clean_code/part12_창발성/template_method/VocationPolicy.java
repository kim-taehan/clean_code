package org.developx.clean_code.part12_창발성.template_method;

public abstract class VocationPolicy {

    public void accrueVacation(){
        calculateBaseVacationHours();
        alterForLegalMinimums();
        applyToPayroll();

    }

    private void calculateBaseVacationHours() {
        // 지끔까지 근무한 시간을 바탕으로 휴가 일수를 계산
    }
    protected abstract void alterForLegalMinimums();
    private void applyToPayroll() {
        // 휴가 일수를 급여 대장에 적용하는 코드
    }
}
