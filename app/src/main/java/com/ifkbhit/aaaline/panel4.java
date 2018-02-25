package com.ifkbhit.aaaline;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class panel4 extends Panel {

    private double scale;
    private Texture[] nums = new Texture[11];
    private Texture[][] backTextures = new Texture[4][3];

    panel4(int cnvW, int cnvH, Resources res, boolean isVertical) {

        this.res = res;
        reversible = false;
        showSmall = true;
        Bitmap panelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel_227);
        double k;
        if (isVertical) {
            k = (1.0 - Config.CAR_Y_OFFSET_K) * 210.0 / Config.CAR_H;
        }
        else {
            k = 0.35;
        }
        h = cnvH * k;
        w = panelBitmap.getWidth() * h / panelBitmap.getHeight();
        panel = new Texture(Bitmap.createScaledBitmap(panelBitmap, (int) w, (int) h, false));
        if (isVertical) {
            panel.setPos(new Point((cnvW - panel.img.getWidth()) / 2.0, cnvH * 0.445));
        }
        else {
            panel.setPos(new Point((cnvW - w) / 2, cnvH * 0.28 - h / 2));
        }
        Bitmap[] numBitmaps = new Bitmap[11];

        numBitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.d0_227);
        numBitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.d1_227);
        numBitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.d2_227);
        numBitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.d3_227);
        numBitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.d4_227);
        numBitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.d5_227);
        numBitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.d6_227);
        numBitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.d7_227);
        numBitmaps[8] = BitmapFactory.decodeResource(res, R.drawable.d8_227);
        numBitmaps[9] = BitmapFactory.decodeResource(res, R.drawable.d9_227);
        numBitmaps[10] = BitmapFactory.decodeResource(res, R.drawable.dl_227);

        double cft_h = h / panelBitmap.getHeight();
        double cft_w = w / panelBitmap.getWidth();
        scale = panel.h / 400;

        h = numBitmaps[0].getHeight() * cft_h;
        w = numBitmaps[0].getWidth() * cft_w;

        for (int i = 0; i < 11; ++i) {
            nums[i] = new Texture(Bitmap.createScaledBitmap(numBitmaps[i], (int) w, (int) h, false));
            nums[i].setPos(new Point(0, panel.pos.y + 90 * scale));
            numBitmaps[i] = null;
        }

        Bitmap[][] backBitmaps = new Bitmap[4][3];

        backBitmaps[0][0] = BitmapFactory.decodeResource(res, R.drawable.b00_227);
        backBitmaps[0][1] = BitmapFactory.decodeResource(res, R.drawable.b01_227);
        backBitmaps[0][2] = BitmapFactory.decodeResource(res, R.drawable.b02_227);

        backBitmaps[1][0] = BitmapFactory.decodeResource(res, R.drawable.b10_227);
        backBitmaps[1][1] = BitmapFactory.decodeResource(res, R.drawable.b11_227);
        backBitmaps[1][2] = BitmapFactory.decodeResource(res, R.drawable.b12_227);

        backBitmaps[2][0] = BitmapFactory.decodeResource(res, R.drawable.b20_227);
        backBitmaps[2][1] = BitmapFactory.decodeResource(res, R.drawable.b21_227);
        backBitmaps[2][2] = BitmapFactory.decodeResource(res, R.drawable.b22_227);

        backBitmaps[3][0] = BitmapFactory.decodeResource(res, R.drawable.b30_227);
        backBitmaps[3][1] = BitmapFactory.decodeResource(res, R.drawable.b31_227);
        backBitmaps[3][2] = BitmapFactory.decodeResource(res, R.drawable.b32_227);


        int[] xPos = {214, 250, 282, 314};
        int[] yPos = {272, 262, 244, 224};

        for (int i = 0; i < 4; ++i) {
            h = backBitmaps[i][0].getHeight() * cft_h;
            w = backBitmaps[i][0].getWidth() * cft_w;
            for (int j = 0; j < 3; ++j) {
                backTextures[i][j] = new Texture(Bitmap.createScaledBitmap(backBitmaps[i][j], (int) w, (int) h, false));
                backTextures[i][j].setPos(new Point(panel.pos.x + xPos[i] * scale, panel.pos.y + yPos[i] * scale));
                backBitmaps[i][j] = null;
            }
        }

        Bitmap lPanelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel_277);
        Bitmap rPanelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel_216);

        k = (isVertical ? (1.0 - Config.CAR_Y_OFFSET_K) * 115.0 / Config.CAR_H : 0.2);
        double lh = cnvH * k;
        double lw = lPanelBitmap.getWidth() * lh / lPanelBitmap.getHeight();

        k = (isVertical ? 0.083 : 0.2);
        double rh = cnvH * k;
        double rw = rPanelBitmap.getWidth() * rh / rPanelBitmap.getHeight();

        l_panel = new Texture(Bitmap.createScaledBitmap(lPanelBitmap, (int) lw, (int) lh, false));
        r_panel = new Texture(Bitmap.createScaledBitmap(rPanelBitmap, (int) (rw * 1.3), (int) (rh * 1.3), false));

        if (isVertical) {
            l_panel.setPos(new Point(-0.71 * lw, cnvH * 0.47));
            r_panel.setPos(new Point(cnvW - 0.34 * rw, cnvH * (Config.CAR_Y_OFFSET_K / 2) + ((1 - Config.CAR_Y_OFFSET_K) * cnvH) / 2.0 - r_panel.img.getWidth() * 1.3 / 16.0));
        }
        else {
            l_panel.setPos(new Point(-lw - 1, cnvH / 4 - lh / 2));
            r_panel.setPos(new Point(cnvW, cnvH / 4 - rh * 1.3 / 2));
        }
    }

    private void drawNum(Canvas canvas) {

        if (cur_l < 0 || isUp) {
            cur_l = 10;
        }
        if (cur_r < 0 || isUp) {
            cur_r = 10;
        }

        nums[cur_l].pos.x = panel.pos.x + 295 * scale;
        nums[cur_l].xPos = panel.xPos;
        nums[cur_l].draw(canvas);
        nums[cur_r].pos.x = panel.pos.x + 378 * scale;
        nums[cur_r].xPos = panel.xPos;
        nums[cur_r].draw(canvas);
    }

    private void drawBars(Canvas canvas) {
        if (isUp) {
            return;
        }
        for (int i = 0; i < 4; ++i) {
            if (state[i] > 0) {
                backTextures[i][state[i] - 1].xPos = panel.xPos;
                backTextures[i][state[i] - 1].draw(canvas);
            }
        }
    }


    @Override
    void draw(Canvas canvas) {
        panel.draw(canvas);
        drawNum(canvas);
        drawBars(canvas);
    }

    @Override
    int getLevel(double val) {
        if (val < 0) {
            return 0;
        }
        if (val <= (isUp ? 0.51 : 0.51)) {
            return 3;
        }
        if (val <= (isUp ? 0.71 : 0.71)) {
            return 2;
        }
        if (val <= (isUp ? 0.91 : 1.31)) {
            return 1;
        }
        return 0;
    }

}
