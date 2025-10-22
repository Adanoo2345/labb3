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
        this.x2 = x2 + x;
        this.y2 = y2 + y;
        setVelocity(100, 50);
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
        gc.setLineWidth(3.0);
        gc.setStroke(getColor());
        gc.strokeLine(getX(), getY(), x2, y2);
    }

    @Override
    protected void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
        x2 += getDx() * elapsedTimeNs / BILLION;
        y2 += getDy() * elapsedTimeNs / BILLION;
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        double x1 = getX();
        double y1 = getY();
        double x2Abs = x2;
        double y2Abs = y2;

        double dx = getDx();
        double dy = getDy();

        // Studsa mot väggarna om någon ände går utanför
        if (x1 < boxX || x2Abs < boxX) dx = Math.abs(dx);
        else if (x1 > boxWidth || x2Abs > boxWidth) dx = -Math.abs(dx);

        if (y1 < boxY || y2Abs < boxY) dy = Math.abs(dy);
        else if (y1 > boxHeight || y2Abs > boxHeight) dy = -Math.abs(dy);

        setVelocity(dx, dy);
    }

}
