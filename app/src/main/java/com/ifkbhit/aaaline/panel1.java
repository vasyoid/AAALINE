package com.ifkbhit.aaaline;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by vasyoid on 22.07.17.
 */

public class panel1 extends Panel {

    private Bitmap[] digits = new Bitmap[10];
    private Texture line;
    private Texture[][] texPanels = new Texture[4][4];
    private Texture[] texDig = new Texture[10];

    private Bitmap getScaledBitmap(int id, double w, double h) {
        Bitmap b = Bitmap.createScaledBitmap(getBitmap(id), (int) w, (int) h, false);
        return b;
    }

    panel1(int cnvW, int cnvH, int x, int y, int height, Resources res, boolean isReverse, boolean isVertical) {
        this.res = res;
        reversible = true;
        reverse = isReverse;
        Bitmap panelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel);

        double k = (1.0 - Config.CAR_Y_OFFSET_K) * 120.0 / Config.CAR_H;
        if (height < 0) {
            h = cnvH * k;
        }
        else {
            h = height;
        }
        w = panelBitmap.getWidth() * h / panelBitmap.getHeight();
        panel = new Texture(Bitmap.createScaledBitmap(panelBitmap, (int) w, (int) h, false));
        if (x < 0 || y < 0) {
            panel.setPos(new Point((cnvW - panel.img.getWidth()) / 2.0, cnvH * (Config.CAR_Y_OFFSET_K / 2) + ((1 - Config.CAR_Y_OFFSET_K) * cnvH) / 2.0 - panel.img.getWidth() / 16.0));
        }
        else {
            panel.setPos(new Point(x - w / 2, y - h / 2));
        }
        panel.setScaled(1.3);

        digits[0] = getBitmap(R.drawable.d0);
        digits[1] = getBitmap(R.drawable.d1);
        digits[2] = getBitmap(R.drawable.d2);
        digits[3] = getBitmap(R.drawable.d3);
        digits[4] = getBitmap(R.drawable.d4);
        digits[5] = getBitmap(R.drawable.d5);
        digits[6] = getBitmap(R.drawable.d6);
        digits[7] = getBitmap(R.drawable.d7);
        digits[8] = getBitmap(R.drawable.d8);
        digits[9] = getBitmap(R.drawable.d9);

        for (int i = 0; i < 10; i++) {
            double kh = 0.9 * 98.0 / 174.0;
            double kw = 0.9 * 65.0 / 600.0;
            double w = panel.img.getWidth() * kw;
            double h = panel.img.getHeight() * kh;
            if (line == null) {
                line = new Texture(Bitmap.createScaledBitmap(getBitmap(R.drawable.dl), (int) w, (int) h, true));
            }
            texDig[i] = new Texture(Bitmap.createScaledBitmap(digits[i], (int) w, (int) h, true));
            digits[i] = null;
        }

        k = panel.img.getHeight() / 174.0;

        Point position = new Point(59 * k, 67 * k).sum(panel.pos);
        texPanels[0][0] = new Texture(getScaledBitmap(R.drawable.f12, 78 * k,(75 * k)), position, k);
        texPanels[0][1] = new Texture(getScaledBitmap(R.drawable.f02, 78 * k,(75 * k)), position, k);
        texPanels[0][2] = new Texture(getScaledBitmap(R.drawable.f21, 78 * k,(75 * k)), position, k);
        texPanels[0][3] = new Texture(getScaledBitmap(R.drawable.f01, 78 * k, (75 * k)),position, k);

        position = new Point(142 * k, 46 * k).sum(panel.pos);
        texPanels[1][0] = new Texture(getScaledBitmap(R.drawable.f13, 78 * k,(96 * k)), position , k);
        texPanels[1][1] = new Texture(getScaledBitmap(R.drawable.f51, 78 * k,(96 * k)), position, k);
        texPanels[1][2] = new Texture(getScaledBitmap(R.drawable.f31, 78 * k,(96 * k)), position, k);
        texPanels[1][3] = new Texture(getScaledBitmap(R.drawable.f11, 78 * k, (96 * k)),position, k);

        position = new Point(369 * k, 46 * k).sum(panel.pos);
        texPanels[2][0] = new Texture(getScaledBitmap(R.drawable.f23, 78 * k,(96 * k)),position , k);
        texPanels[2][1] = new Texture(getScaledBitmap(R.drawable.f21, 78 * k, (96 * k)),position, k);
        texPanels[2][2] = new Texture(getScaledBitmap(R.drawable.f51, 78 * k,(96 * k)), position, k);
        texPanels[2][3] = new Texture(getScaledBitmap(R.drawable.f61, 78 * k,(96 * k)), position, k);

        position = new Point(449 * k, 67 * k).sum(panel.pos);
        texPanels[3][0] = new Texture(getScaledBitmap(R.drawable.f33, 78 * k,(75 * k)), position, k);
        texPanels[3][1] = new Texture(getScaledBitmap(R.drawable.f31, 78 * k,(75 * k)), position, k);
        texPanels[3][2] = new Texture(getScaledBitmap(R.drawable.f31, 78 * k,(75 * k)), position, k);
        texPanels[3][3] = new Texture(getScaledBitmap(R.drawable.f71, 78 * k,(75 * k)), position, k);

        Bitmap rPanelBitmap = BitmapFactory.decodeResource(res, R.drawable.empty);

        k = (isVertical ? (1.0 - Config.CAR_Y_OFFSET_K) * 393.0 / Config.CAR_H : 0.55);

        double rh = cnvH * k;
        double rw = rPanelBitmap.getWidth() * rh / rPanelBitmap.getHeight();

        Bitmap lPanelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel);

        k = (isVertical ? 0.08 : 0.2);

        double lh = cnvH * k, lw = lPanelBitmap.getWidth() * lh / lPanelBitmap.getHeight();

        l_panel = new Texture(Bitmap.createScaledBitmap(lPanelBitmap, (int) lw, (int) lh, false));
        r_panel = new Texture(Bitmap.createScaledBitmap(rPanelBitmap, (int) rw, (int) rh, false));

        if (isVertical) {
            l_panel.setPos(new Point(-0.75 * lw, cnvH * 0.47));
            r_panel.setPos(new Point(cnvW - 0.21 * rw, cnvH * 0.425));
        }
        else {
            l_panel.setPos(new Point(-lw - 1, y - lh / 2));
            r_panel.setPos(new Point(cnvW + (w * 1.3 - rw) / 2, cnvH * 0.28 - rh / 2));
        }
    }

    private void drawNum(Canvas canvas) {
        Texture left, right;
        if (cur_l == -1 || cur_r == -1) {
            left = right = line;
        } else {
            left = texDig[cur_l];
            right = texDig[cur_r];
        }
        Point dotCenter = panel.getCenter();
        Point posLeft = new Point(dotCenter.x - left.img.getWidth() * 1.15, (dotCenter.y - left.img.getHeight() * 0.5));
        left.setPos(posLeft);
        left.draw(canvas);
        Point posRight = new Point(dotCenter.x + left.img.getWidth() * 0.15, (dotCenter.y - left.img.getHeight() * 0.5));
        right.setPos(posRight);
        right.draw(canvas);
        Paint dotPaint = new Paint();
        dotPaint.setARGB(255, 240, 110, 50);
        canvas.drawCircle((float)dotCenter.x, (float)dotCenter.y + (float)(texDig[0].h * 0.45), (float)(texDig[0].h * 0.06), dotPaint);
    }

    private void drawBars(Canvas canvas) {
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < 4; ++j) {
                texPanels[i][j].xPos = panel.xPos;
            }
            int lvl = state[i];
            if (lvl != 0) {
                texPanels[i][4 - lvl].draw(canvas);
            }
        }
    }

    @Override
    void draw(Canvas canvas) {
        canvas.save();
        canvas.rotate(panelAngle, (float)panel.getCenter().x, (float)panel.getCenter().y);
        if (reverse) {
            canvas.save();
                canvas.rotate(180, (float) panel.getCenter().x, (float) panel.getCenter().y);
                panel.draw(canvas);
                canvas.scale(-1f, 1f, (float) panel.getCenter().x, (float) panel.getCenter().y);
                drawBars(canvas);
            canvas.restore();
            drawNum(canvas);
        }
        else {
            panel.draw(canvas);
            drawNum(canvas);
            drawBars(canvas);
        }
        canvas.restore();
    }

    int getLevel(double val) {
        if (val < 0) {
            return 0;
        }
        if (val <= 0.51) {
            return 4;
        }
        if (val <= 0.71) {
            return 3;
        }
        if (val <= 0.91) {
            return 2;
        }
        if (val <= 1.31) {
            return 1;
        }
        return 0;
    }

}
