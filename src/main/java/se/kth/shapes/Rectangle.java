package se.kth.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape{
    private double width, height;

    public Rectangle(double x, double y, Color color, double height, double width, boolean filled) {
        super(x, y, color, filled);
        this.height = height;
        this.width = width;
        setVelocity(100, 50);
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
        gc.setStroke(getColor());
        if(isFilled()){
            gc.fillRect(getX(), getY(), width, height);
        }
        else {
            gc.strokeRect(getX(), getY(), width, height);
        }
    }

    @Override
    protected void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
    }

    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        double x = getX();
        double y = getY();
        double dx = getDx();
        double dy = getDy();

        // Studsa mot höger/vänster
        if (x < boxX) {
            x = boxX;
            dx = Math.abs(dx);
        } else if (x + width > boxWidth) {
            x = boxWidth - width;
            dx = -Math.abs(dx);
        }

        // Studsa mot topp/botten
        if (y < boxY) {
            y = boxY;
            dy = Math.abs(dy);
        } else if (y + height > boxHeight) {
            y = boxHeight - height;
            dy = -Math.abs(dy);
        }

        // Uppdatera position och hastighet
        setX(x);
        setY(y);
        setVelocity(dx, dy);
    }
}
