package com.company;

public class Point {
    int row, col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object o) {
        Point otherPoint = (Point) o;
        return this.row == otherPoint.row && this.col == otherPoint.col;
    }

    @Override
    public String toString() {
        return String.format("row %s, col %s", row, col);
    }
}
