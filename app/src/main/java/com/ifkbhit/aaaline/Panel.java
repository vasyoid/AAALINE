package com.ifkbhit.aaaline;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

abstract public class Panel {

    boolean isActive = false;
    double w, h;
    MyTime mvTimer = null, invTimer = null;
    boolean moveFlag = false, invertFlag = false, invalidFlag = false, reverse = false;
    float panelAngle = 0;
    Texture panel, l_panel, r_panel;
    Resources res;
    boolean reversible;
    int[] state = {0,0,0,0};
    int cur_l = -1, cur_r = -1;
    boolean isUp;


    void setActive(boolean active) {
        isActive = active;
    }

    void moveX(double dx) {
        panel.xPos += dx;
    }

    void setInvertFlag(boolean value) {
        invertFlag = value;
    }

    void switchReverse() {
        reverse ^= true;
    }

    void setMoveFlag(boolean value) {
        moveFlag = value;
    }

    boolean getInvertFlag() {
        return invertFlag;
    }

    boolean getMoveFlag() {
        return moveFlag;
    }

    boolean getInvalidFlag() {
        return invalidFlag;
    }

    void setInvalidFlag(boolean value) {
        invalidFlag = value;
    }

    void move() {
        if (!moveFlag) {
            return;
        }

        if (mvTimer == null) {
            mvTimer = new MyTime();
        }

        double cft = 10;
        mvTimer.Refresh();
        panel.xPos -= cft * panel.xPos * mvTimer.DeltaS;

        if (Math.abs(panel.xPos) < 3.0) {
            panel.xPos = 0;
            moveFlag = false;
            mvTimer = null;
        }

    }

    private double func(double arg) {
        return 2 - Math.abs(arg - 2);
    }

    void invert() {
        if (!invertFlag) {
            return;
        }
        if (invTimer == null) {
            invTimer = new MyTime();
        }

        double period = 4.0;
        double tm = 1.3;
        double cft = 0.001 / tm * period;
        double integral = 4.0;

        invTimer.Refresh();
        double mid = (func(invTimer.FromStart * cft) + func((invTimer.FromStart - invTimer.Delta) * cft)) / 2.0;
        panelAngle += 180 / integral * mid * invTimer.Delta * cft;

        if (invTimer.FromStartS >= tm) {
            invTimer = null;
            invertFlag = false;
            invalidFlag = true;
            panelAngle = 0;
        }
    }

    Bitmap getBitmap(int id) {
        return BitmapFactory.decodeResource(res, id);
    }

    abstract int getLevel(double val);

    private void clear() {
        for (int i = 0; i < 4; i++)
            state[i] = 0;
    }

    void setPanel(double[] info,  boolean isUp) {
        this.isUp = isUp;
        double cur_dist = 1e9;
        for (int i = 0; i < 4; ++i) {
            info[i] = ((int)(info[i] * 10)) * 0.1;
            if (info[i] >= 0 && cur_dist > info[i]) {
                cur_dist = info[i];
            }
            state[i] = getLevel(info[i]);
        }
        if (cur_dist < 0.3) {
            cur_dist = 0.0;
        }
        cur_l = (int)cur_dist;
        cur_r = ((int)(cur_dist * 10)) % 10;
        if (cur_dist > (isUp ? 0.99 : 2.09)) {
            clear();
            cur_l = cur_r = -1;
        }
    }

    void draw(Canvas canvas) { }
    void drawNext(Canvas canvas) {
        l_panel.xPos = panel.xPos;
        l_panel.draw(canvas);
        r_panel.xPos = panel.xPos;
        r_panel.draw(canvas);
    }

}
