package fr.ntdt.game.shooter.objet;

public class Point {

    private int x = 0;
    private int y = 0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Point x(int x) {
        setX(x);
        return this;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point y(int y) {
        setY(y);
        return this;
    }

}
