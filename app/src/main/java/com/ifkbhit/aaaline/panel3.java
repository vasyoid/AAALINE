package com.ifkbhit.aaaline;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class panel3 extends Panel {

    Texture[] greenInd = new Texture[8];
    Texture[] redInd = new Texture[8];
    Texture[] whiteInd = new Texture[2];
    MyTime blinkTimer = new MyTime();

    panel3(int cnvW, int cnvH, Resources res, boolean isVertical) {
        this.res = res;
        reversible = true;
        double k = (isVertical ? 0.08 : 0.2);
        Bitmap panelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel_277);
        h = cnvH * k;
        w = panelBitmap.getWidth() * h / panelBitmap.getHeight();
        panel = new Texture(Bitmap.createScaledBitmap(panelBitmap, (int) w, (int) h, false));
        if (isVertical) {
            panel.setPos(new Point((cnvW - panel.img.getWidth()) / 2.0, cnvH * 0.47));
        }
        else {
            panel.setPos(new Point((cnvW - w) / 2, cnvH / 4 - h / 2));
        }
        Bitmap tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f01_277);
        int w1 = (int)(tmpBmp.getWidth() * h / tmpBmp.getHeight());
        greenInd[0] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        greenInd[0].setPos(new Point(panel.pos.x  + 0.033 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f11_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        greenInd[1] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        greenInd[1].setPos(new Point(panel.pos.x  + 0.083 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f21_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        greenInd[2] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        greenInd[2].setPos(new Point(panel.pos.x  + 0.223 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f31_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        greenInd[3] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        greenInd[3].setPos(new Point(panel.pos.x  + 0.363 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f41_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        greenInd[4] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        greenInd[4].setPos(new Point(panel.pos.x  + 0.503 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f51_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        greenInd[5] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        greenInd[5].setPos(new Point(panel.pos.x  + 0.646 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f61_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        greenInd[6] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        greenInd[6].setPos(new Point(panel.pos.x  + 0.786 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f71_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        greenInd[7] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        greenInd[7].setPos(new Point(panel.pos.x  + 0.926 * w, panel.pos.y));

        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f02_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        redInd[0] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        redInd[0].setPos(new Point(panel.pos.x  + 0.033 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f12_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        redInd[1] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        redInd[1].setPos(new Point(panel.pos.x  + 0.083 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f22_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        redInd[2] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        redInd[2].setPos(new Point(panel.pos.x  + 0.223 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f32_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        redInd[3] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        redInd[3].setPos(new Point(panel.pos.x  + 0.363 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f42_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        redInd[4] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        redInd[4].setPos(new Point(panel.pos.x  + 0.503 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f52_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        redInd[5] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        redInd[5].setPos(new Point(panel.pos.x  + 0.646 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f62_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        redInd[6] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        redInd[6].setPos(new Point(panel.pos.x  + 0.786 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f72_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        redInd[7] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        redInd[7].setPos(new Point(panel.pos.x  + 0.926 * w, panel.pos.y));

        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f00_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        whiteInd[0] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        whiteInd[0].setPos(new Point(panel.pos.x  + 0.033 * w, panel.pos.y));
        tmpBmp = BitmapFactory.decodeResource(res, R.drawable.f70_277);
        w1 = (int) (tmpBmp.getWidth() * h / tmpBmp.getHeight());
        whiteInd[1] = new Texture(Bitmap.createScaledBitmap(tmpBmp, w1, (int)h, false));
        whiteInd[1].setPos(new Point(panel.pos.x  + 0.926 * w, panel.pos.y));



        Bitmap rPanelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel_227);
        Bitmap lPanelBitmap = BitmapFactory.decodeResource(res, R.drawable.empty_218);

        k = (isVertical ? (1.0 - Config.CAR_Y_OFFSET_K) * 393.0 / Config.CAR_H : 0.55);

        double lh = cnvH * k;
        double lw = lPanelBitmap.getWidth() * lh / lPanelBitmap.getHeight();

        k = (isVertical ? (1.0 - Config.CAR_Y_OFFSET_K) * 300.0 / Config.CAR_H : 0.45);

        double rh = cnvH * k;
        double rw = rPanelBitmap.getWidth() * rh / rPanelBitmap.getHeight();

        r_panel = new Texture(Bitmap.createScaledBitmap(rPanelBitmap, (int) rw, (int) rh, false));
        l_panel = new Texture(Bitmap.createScaledBitmap(lPanelBitmap, (int) lw, (int) lh, false));

        if (isVertical) {
            l_panel.setPos(new Point(-lw * 0.87, cnvH * 0.425));
            r_panel.setPos(new Point(cnvW - 0.21 * rw, cnvH * 0.425));
        }
        else {
            l_panel.setPos(new Point((-lw - w) / 2, cnvH * 0.28 - lh / 2));
            r_panel.setPos(new Point(cnvW + Math.abs(w - rw) / 2, cnvH * 0.28 - rh / 2));
        }
    }

    void drawBars(Canvas canvas) {
        if (!isActive) {
            return;
        }
        int left = Math.max(state[0], state[1]);
        int right = Math.max(state[2], state[3]);
        if (this.reverse) {
            left += right;
            right = left - right;
            left = left - right;
        }
        for (Texture ind : whiteInd) {
            ind.xPos = panel.xPos;
        }
        for (Texture ind : redInd) {
            ind.xPos = panel.xPos;
        }
        for (Texture ind : greenInd) {
            ind.xPos = panel.xPos;
        }

        if (right >= 5 || left >= 5) {
           blinkTimer.Refresh();
           int numberOn;
           if (blinkTimer.FromStart % 800 < 400) {
               numberOn = (int)((blinkTimer.FromStart % 800) / 100);
           } else {
               numberOn = 2 - (int)((blinkTimer.FromStart % 800 - 400) / 100);
           }
           if (numberOn >= 0) {
               for (int i = 4; i <= 4 + numberOn; i++) {
                   redInd[i].draw(canvas);
               }
               for (int i = 3; i >= 3 - numberOn; i--) {
                   redInd[i].draw(canvas);
               }
           }
        } else {
            if (left > 3) {
                for (int i = 0; i < 4; ++i) {
                    redInd[i].draw(canvas);
                }
            } else {
                if (!isUp) {
                    whiteInd[0].draw(canvas);
                }
                if (left > 0) {
                    greenInd[0].draw(canvas);
                }
                if (left > 1) {
                    greenInd[1].draw(canvas);
                }
                if (left > 2) {
                    greenInd[2].draw(canvas);
                    greenInd[3].draw(canvas);
                }
            }
            if (right > 3) {
                for (int i = 4; i < 8; ++i) {
                    redInd[i].draw(canvas);
                }
            } else {
                if (!isUp) {
                    whiteInd[1].draw(canvas);
                }
                if (right > 0) {
                    greenInd[7].draw(canvas);
                }
                if (right > 1) {
                    greenInd[6].draw(canvas);
                }
                if (right > 2) {
                    greenInd[5].draw(canvas);
                    greenInd[4].draw(canvas);
                }
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
            drawBars(canvas);
            canvas.restore();
        }
        else {
            panel.draw(canvas);
            drawBars(canvas);
        }
        canvas.restore();
    }

    @Override
    int getLevel(double val) {
        if (val < 0) {
            return -1;
        }
        if (val <= 0.21) {
            return 5;
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