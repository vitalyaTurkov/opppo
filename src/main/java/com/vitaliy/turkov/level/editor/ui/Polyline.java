package com.vitaliy.turkov.level.editor.ui;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private final List<Integer> x;
    private final List<Integer> y;
    private Integer pointCount;

    public Polyline() {
        x = new ArrayList<>();
        y = new ArrayList<>();
        pointCount = 0;
    }

    public void addPoint(int x, int y) {
        this.x.add(x);
        this.y.add(y);
        this.pointCount++;
    }

    public double[] getX() {
        double[] xs = new double[x.size()];
        for (int i = 0; i < x.size(); i++) {
            xs[i] = x.get(i);
        }
        return xs;
    }

    public double[] getY() {
        double[] ys = new double[y.size()];
        for (int i = 0; i < y.size(); i++) {
            ys[i] = y.get(i);
        }
        return ys;
    }

    public Integer getPointCount() {
        return pointCount;
    }
}
