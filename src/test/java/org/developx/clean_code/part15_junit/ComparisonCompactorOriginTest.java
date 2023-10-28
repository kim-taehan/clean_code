package org.developx.clean_code.part15_junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComparisonCompactorOriginTest {

    @DisplayName("")
    @Test
    void test244(){

        ComparisonCompactorOrigin comparisonCompactor = new ComparisonCompactorOrigin(0, "b", "c");
        String compact = comparisonCompactor.compact(null);
        System.out.println(compact);
    }

}
