package com.crazy.activity.widget;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class EmergencyTypeDrawable extends GradientDrawable {

    private Resources resources;

    public EmergencyTypeDrawable(Resources resources) {
        super();
        this.resources = resources;
        init();
    }

    private void init() {

        float topLeftRadius = dp2px(0), topRightRadius = dp2px(25), bottomRightRadius = dp2px(25), bottomLeftRadius = dp2px(0);

        setShape(RECTANGLE);
        setColor(Color.BLUE);
        setCornerRadii(new float[]{
                topLeftRadius, topLeftRadius,
                topRightRadius, topRightRadius,
                bottomRightRadius, bottomRightRadius,
                bottomLeftRadius, bottomLeftRadius
        });
    }


    public float dp2px(float dp) {
        final float scale = resources.getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

}
