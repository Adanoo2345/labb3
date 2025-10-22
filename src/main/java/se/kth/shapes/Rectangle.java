package se.kth.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape{
    private double width, height;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle(double x, double y, Color color, double height, double width) {
        super(x, y, color);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void paint(GraphicsContext gc){
        gc.setFill(getColor());
        gc.fillRect(getX(), getY(), width, height);
    }
}
