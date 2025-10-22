package se.kth.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape{
    private double diameter;

    public Circle(double x, double y, Color color, double diameter, boolean filled) {
        super(x, y, color, filled);
        this.diameter = diameter;
        setVelocity(100, 50);
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void paint(GraphicsContext gc){
        gc.setFill(getColor());
        gc.setStroke(getColor());
        if(isFilled()){
            gc.fillOval(getX(), getY(), diameter, diameter);
        }
        else {
            gc.strokeOval(getX(), getY(), diameter, diameter);
        }
    }

    @Override
    protected void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        double x = getX();
        double y = getY();
        double dx = getDx();
        double dy = getDy();

        // Studsa mot höger/vänster
        if (x < boxX) {
            x = boxX;
            dx = Math.abs(dx);
        } else if (x + diameter > boxWidth) {
            x = boxWidth - diameter;
            dx = -Math.abs(dx);
        }

        // Studsa mot topp/botten
        if (y < boxY) {
            y = boxY;
            dy = Math.abs(dy);
        } else if (y + diameter > boxHeight) {
            y = boxHeight - diameter;
            dy = -Math.abs(dy);
        }

        // Uppdatera position och hastighet
        setX(x);
        setY(y);
        setVelocity(dx, dy);
    }
}
