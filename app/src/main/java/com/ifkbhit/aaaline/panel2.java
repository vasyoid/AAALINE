package com.ifkbhit.aaaline;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class panel2 extends Panel {

    double scale;
    Texture[] nums = new Texture[11];
    Texture[] indTextures = new Texture[4];
    Texture[][] backTextures = new Texture[4][4];
    Texture[][] frontTextures = new Texture[4][3];
    int indication;

    panel2(int cnvW, int cnvH, Resources res, boolean isVertical) {

        this.res = res;
        reversible = false;
        Bitmap panelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel_218);
        double k;
        if (isVertical) {
            k = (1.0 - Config.CAR_Y_OFFSET_K) * 393.0 / Config.CAR_H;
        }
        else {
            k = 0.55;
        }
        h = cnvH * k;
        w = panelBitmap.getWidth() * h / panelBitmap.getHeight();
        panel = new Texture(Bitmap.createScaledBitmap(panelBitmap, (int) w, (int) h, false));
        if (isVertical) {
            panel.setPos(new Point((cnvW - panel.img.getWidth()) / 2.0, cnvH * 0.425));
        }
        else {
            panel.setPos(new Point((cnvW - w) / 2, cnvH * 0.28 - h / 2));
        }
        Bitmap[] numBitmaps = new Bitmap[11];

        numBitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.d0_218);
        numBitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.d1_218);
        numBitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.d2_218);
        numBitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.d3_218);
        numBitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.d4_218);
        numBitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.d5_218);
        numBitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.d6_218);
        numBitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.d7_218);
        numBitmaps[8] = BitmapFactory.decodeResource(res, R.drawable.d8_218);
        numBitmaps[9] = BitmapFactory.decodeResource(res, R.drawable.d9_218);
        numBitmaps[10] = BitmapFactory.decodeResource(res, R.drawable.dl_218);

        double cft_h = h / panelBitmap.getHeight();
        double cft_w = w / panelBitmap.getWidth();
        scale = panel.h / 572;

        h = numBitmaps[0].getHeight() * cft_h;
        w = numBitmaps[0].getWidth() * cft_w;

        for (int i = 0; i < 11; ++i) {
            nums[i] = new Texture(Bitmap.createScaledBitmap(numBitmaps[i], (int) w, (int) h, false));
            nums[i].setPos(new Point(0, panel.pos.y + 240 * scale));
            numBitmaps[i] = null;
        }

        Bitmap[] indBitmaps = new Bitmap[4];

        indBitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.ind0_218);
        indBitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.ind1_218);
        indBitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.ind2_218);
        indBitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.ind3_218);

        h = indBitmaps[0].getHeight() * cft_h;
        w = indBitmaps[0].getWidth() * cft_w;

        for (int i = 0; i < 3; ++i) {
            indTextures[i] = new Texture(Bitmap.createScaledBitmap(indBitmaps[i], (int) w, (int) h, false));
            indTextures[i].setPos(new Point(panel.pos.x + 516 * scale, panel.pos.y + (168 - 40 * i) * scale));
            indBitmaps[i] = null;
        }

        h = indBitmaps[3].getHeight() * cft_h;
        w = indBitmaps[3].getWidth() * cft_w;

        indTextures[3] = new Texture(Bitmap.createScaledBitmap(indBitmaps[3], (int) w, (int) h, false));
        indTextures[3].setPos(new Point(panel.pos.x + 282 * scale, panel.pos.y + 300 * scale));
        indBitmaps[3] = null;

        Bitmap[][] backBitmaps = new Bitmap[4][4];

        backBitmaps[0][0] = BitmapFactory.decodeResource(res, R.drawable.b00_218);
        backBitmaps[0][1] = BitmapFactory.decodeResource(res, R.drawable.b01_218);
        backBitmaps[0][2] = BitmapFactory.decodeResource(res, R.drawable.b02_218);
        backBitmaps[0][3] = BitmapFactory.decodeResource(res, R.drawable.b03_218);

        backBitmaps[1][0] = BitmapFactory.decodeResource(res, R.drawable.b10_218);
        backBitmaps[1][1] = BitmapFactory.decodeResource(res, R.drawable.b11_218);
        backBitmaps[1][2] = BitmapFactory.decodeResource(res, R.drawable.b12_218);
        backBitmaps[1][3] = BitmapFactory.decodeResource(res, R.drawable.b13_218);

        backBitmaps[2][0] = BitmapFactory.decodeResource(res, R.drawable.b20_218);
        backBitmaps[2][1] = BitmapFactory.decodeResource(res, R.drawable.b21_218);
        backBitmaps[2][2] = BitmapFactory.decodeResource(res, R.drawable.b22_218);
        backBitmaps[2][3] = BitmapFactory.decodeResource(res, R.drawable.b23_218);

        backBitmaps[3][0] = BitmapFactory.decodeResource(res, R.drawable.b30_218);
        backBitmaps[3][1] = BitmapFactory.decodeResource(res, R.drawable.b31_218);
        backBitmaps[3][2] = BitmapFactory.decodeResource(res, R.drawable.b32_218);
        backBitmaps[3][3] = BitmapFactory.decodeResource(res, R.drawable.b33_218);

        h = backBitmaps[0][0].getHeight() * cft_h;
        w = backBitmaps[0][0].getWidth() * cft_w;

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                backTextures[i][j] = new Texture(Bitmap.createScaledBitmap(backBitmaps[i][j], (int) w, (int) h, false));
                backTextures[i][j].setPos(new Point(panel.pos.x + 346 * scale, panel.pos.y + 169 * scale));
                backBitmaps[i][j] = null;
            }
        }

        backBitmaps[0][0] = BitmapFactory.decodeResource(res, R.drawable.f00_218);
        backBitmaps[0][1] = BitmapFactory.decodeResource(res, R.drawable.f01_218);
        backBitmaps[0][2] = BitmapFactory.decodeResource(res, R.drawable.f02_218);

        backBitmaps[1][0] = BitmapFactory.decodeResource(res, R.drawable.f10_218);
        backBitmaps[1][1] = BitmapFactory.decodeResource(res, R.drawable.f11_218);
        backBitmaps[1][2] = BitmapFactory.decodeResource(res, R.drawable.f12_218);

        backBitmaps[2][0] = BitmapFactory.decodeResource(res, R.drawable.f20_218);
        backBitmaps[2][1] = BitmapFactory.decodeResource(res, R.drawable.f21_218);
        backBitmaps[2][2] = BitmapFactory.decodeResource(res, R.drawable.f22_218);

        backBitmaps[3][0] = BitmapFactory.decodeResource(res, R.drawable.f30_218);
        backBitmaps[3][1] = BitmapFactory.decodeResource(res, R.drawable.f31_218);
        backBitmaps[3][2] = BitmapFactory.decodeResource(res, R.drawable.f32_218);

        h = backBitmaps[0][0].getHeight() * cft_h;
        w = backBitmaps[0][0].getWidth() * cft_w;

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                frontTextures[i][j] = new Texture(Bitmap.createScaledBitmap(backBitmaps[i][j], (int) w, (int) h, false));
                frontTextures[i][j].setPos(new Point(panel.pos.x + 116 * scale, panel.pos.y + 76 * scale));
                backBitmaps[i][j] = null;
            }
        }

        Bitmap lPanelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel_216);
        Bitmap rPanelBitmap = BitmapFactory.decodeResource(res, R.drawable.panel_277);

        k = (isVertical ? 0.0822 : 0.2);
        double lh = cnvH * k;
        double lw = lPanelBitmap.getWidth() * lh / lPanelBitmap.getHeight();

        k = (isVertical ? (1.0 - Config.CAR_Y_OFFSET_K) * 115.0 / Config.CAR_H : 0.2);
        double rh = cnvH * k;
        double rw = rPanelBitmap.getWidth() * rh / rPanelBitmap.getHeight();

        l_panel = new Texture(Bitmap.createScaledBitmap(lPanelBitmap, (int) (lw * 1.3), (int) (lh * 1.3), false));
        r_panel = new Texture(Bitmap.createScaledBitmap(rPanelBitmap, (int) rw, (int) rh, false));

        if (isVertical) {
            l_panel.setPos(new Point(-lw * 0.75 * 1.3, cnvH * (Config.CAR_Y_OFFSET_K / 2) + ((1 - Config.CAR_Y_OFFSET_K) * cnvH) / 2.0 - l_panel.img.getWidth() * 1.3 / 16.0));
            r_panel.setPos(new Point(cnvW - rw * 0.20, cnvH * 0.47));
        }
        else {
            l_panel.setPos(new Point(-lw * 1.3, cnvH / 4 - lh * 1.3 / 2));
            r_panel.setPos(new Point(cnvW, cnvH / 4 - r_panel.h / 2));
        }
    }

    void drawNum(Canvas canvas) {

        if (cur_l < 0) {
            cur_l = 10;
        }
        if (cur_r < 0) {
            cur_r = 10;
        }

        nums[cur_l].pos.x = panel.pos.x + 130 * scale;
        nums[cur_l].xPos = panel.xPos;
        nums[cur_l].draw(canvas);
        nums[cur_r].pos.x = panel.pos.x + 213 * scale;
        nums[cur_r].xPos = panel.xPos;
        nums[cur_r].draw(canvas);
    }

    void drawIndication(Canvas canvas) {
        if (cur_l > 0 || cur_r > 7) {
            indication = 0;
        }
        else if (cur_r > 2) {
            indication = 1;
        }
        else {
            indication = 2;
        }

        indTextures[indication].xPos = panel.xPos;
        indTextures[indication].draw(canvas);

        if (cur_l < 10 && cur_r < 10) {
            indTextures[3].xPos = panel.xPos;
            indTextures[3].draw(canvas);
        }
    }

    void drawBars(Canvas canvas) {
        for (int i = 0; i < 4; ++i) {
            if (state[i] > 0) {
                if (isUp) {
                    frontTextures[i][state[i] - 1].xPos = panel.xPos;
                    frontTextures[i][state[i] - 1].draw(canvas);
                }
                else {
                    backTextures[i][state[i] - 1].xPos = panel.xPos;
                    backTextures[i][state[i] - 1].draw(canvas);
                }
            }
        }
    }


    @Override
    void draw(Canvas canvas) {
        panel.draw(canvas);
        drawNum(canvas);
        drawIndication(canvas);
        drawBars(canvas);
    }

    @Override
    int getLevel(double val) {
        if (val < 0) {
            return 0;
        }
        if (val <= (isUp ? -10 : 0.41)) {
            return 4;
        }
        if (val <= (isUp ? 0.51 : 0.71)) {
            return 3;
        }
        if (val <= (isUp ? 0.71 : 0.91)) {
            return 2;
        }
        if (val <= (isUp ? 0.91 : 1.31)) {
            return 1;
        }
        return 0;
    }

}
