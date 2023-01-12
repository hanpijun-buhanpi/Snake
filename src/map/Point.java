package map;

import type.Type;

import java.util.Objects;

public class Point {
    private int x;  // 起始点x
    private int y;  // 起始点y
    private int c;  // 逻辑点x
    private int r;  // 逻辑点y
    private Type type;  // 所属类型

    public Point(int x, int y, int c, int r, Type type) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.r = r;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && c == point.c && r == point.r && type == point.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, c, r, type);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", c=" + c +
                ", r=" + r +
                ", type=" + type +
                '}';
    }
}
