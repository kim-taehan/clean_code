package org.developx.clean_code.part6_자료_추상화.shape;

public class Rectangle extends AbstractShape {

    private final double height;
    private final double width;

    public Rectangle(Point topLeft, double height, double width) {
        super(topLeft);
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return height * width;
    }
}
