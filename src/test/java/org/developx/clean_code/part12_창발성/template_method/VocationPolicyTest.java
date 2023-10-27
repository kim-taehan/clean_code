package org.developx.clean_code.part12_창발성.template_method;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VocationPolicyTest {

    @DisplayName("미국 정보구하기")
    @Test
    void test255(){
        // given
        VocationPolicy vocationPolicy = new UsVocationPolicy();

        // when & then
        vocationPolicy.accrueVacation();
    }
    @DisplayName("유럽 정보구하기")
    @Test
    void test252(){
        // given
        VocationPolicy vocationPolicy = new EuVocationPolicy();

        // when & then
        vocationPolicy.accrueVacation();
    }
}