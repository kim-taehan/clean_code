package org.developx.clean_code.part6_자료_추상화.shape;

public class Square extends AbstractShape {

    private final double side;

    public Square(Point topLeft, double side) {
        super(topLeft);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
