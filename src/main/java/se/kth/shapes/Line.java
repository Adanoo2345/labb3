package se.kth.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape{
    private double x2, y2;

    public Line(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public Line(double x, double y, Color color, double x2, double y2) {
        super(x, y, color);
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    @Override
    public void paint(GraphicsContext gc){
        gc.setStroke(getColor());
        gc.strokeLine(getX(), getY(), x2,  y2);
        gc.setLineWidth(3.0);
    }
}
