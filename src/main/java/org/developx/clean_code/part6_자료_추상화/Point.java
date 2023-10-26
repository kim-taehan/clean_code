package org.developx.clean_code.part6_자료_추상화;

public interface Point {

    double getX();
    double getY();
    void setCartesian(double x, double y);
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
}
