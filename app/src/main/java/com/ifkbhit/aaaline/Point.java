package com.ifkbhit.aaaline;

import android.view.MotionEvent;


public class Point {
    public double x, y;
    public long createdTime;
    public String s;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
        createdTime = System.currentTimeMillis();
    }

    Point(double x, String s) {
        this.x = x;
        this.s = s;
    }

    Point(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        createdTime = System.currentTimeMillis();

    }

    Point(Point p, double dx, double dy) {
        x = p.x + dx;
        y = dy + p.y;

    }

    public Point(Point point) {
        x = point.x;
        y = point.y;
    }

    Point sum(Point a) {
        return new Point(a.x + x, a.y + y);
    }

    void sum1(Point a) {
        x += a.x;
        y += a.y;
    }

    Point multi(double d) {
        return new Point(x * d, y * d);
    }

    Point() {
        x = 0;
        y = 0;
    }

    Point sum(double x, double y) {
        return new Point(this.x + x,
        this.y + y);
    }

    Point medium(Point a) {
        return new Point((x + a.x) / 2.0, (y+a.y) / 2.0);
    }

    Point medium(Point a, Point b) {
        return a.medium(b);
    }

    public String toString() {
        return "x: " + (int)x + " y: " + (int)y;
    }

    double dist(Point point) {
        return Math.sqrt((x - point.x) * (x - point.x) + (y - point.y) * (y - point.y));
    }

    public double dist(Brick brick) {
        if (brick.points[0].x <= x && x <= brick.points[1].x) {
            return Math.min(Math.abs(brick.points[1].y - y),
                            Math.abs(brick.points[2].y - y));
        }
        if (brick.points[1].y <= y && y <= brick.points[2].y) {
            return Math.min(Math.abs(brick.points[0].x - x),
                    Math.abs(brick.points[1].x - x));
        }
        return Math.min(Math.min(dist(brick.points[0]), dist(brick.points[1])),
                        Math.min(dist(brick.points[2]), dist(brick.points[3])));
    }
}
