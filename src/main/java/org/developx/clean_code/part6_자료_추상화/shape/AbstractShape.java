package org.developx.clean_code.part6_자료_추상화.shape;

public abstract class AbstractShape implements Shape {

    private final Point topLeft;

    protected AbstractShape(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getTopLeft() {
        return topLeft;
    }
}
