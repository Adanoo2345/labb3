package se.kth.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape{
    private double diameter;

    public Circle(double diameter) {
        this.diameter = diameter;
    }

    public Circle(double x, double y, Color color, double diameter) {
        super(x, y, color);
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void paint(GraphicsContext gc){
        gc.setFill(getColor());
        gc.fillOval(getX(), getY(), diameter, diameter);
    }
}
