package org.developx.clean_code.part17_냄새와_휴리스틱;

public enum HourlyPayGrade {
    APPRENTICE {
        @Override
        public double rete() {
            return 1.0;
        }
    },
    MASTER {
        @Override
        public double rete() {
            return 2.0;
        }
    };
    public abstract double rete();
}
