package com.gc.common.utils;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;

public class ResourceUtils {
    private static Resources getResources() {
        return RuntimeContext.sApplicationContext.getResources();
    }

    private static Context getContext() {
        return RuntimeContext.sApplicationContext;
    }

    public static int getColor(@ColorRes int colorId) {
        return getResources().getColor(colorId);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getResources().getColorStateList(colorId, getContext().getTheme());
        } else {
            return getResources().getColorStateList(colorId);
        }
    }

    public static int getDimen(int dimen) {
        return getResources().getDimensionPixelSize(dimen);
    }

    public static Drawable getDrawable(int drawableId) {
        return getResources().getDrawable(drawableId);
    }

    public static void setImageRes(int resId, ImageView imageView) {
        if (imageView != null) {
            imageView.setImageResource(resId);
        }
    }

    public static void setBackground(int resId, View view) {
        if (view != null) {
            view.setBackgroundResource(resId);
        }
    }

    public static String getString(int stringId) {
        return getResources().getString(stringId);
    }

    public static String getString(int stringId, Object... formatArgs) {
        try {
            return getResources().getString(stringId, formatArgs);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getQuantityString(int stringId, int count) {
        return getResources().getQuantityString(stringId, count);
    }


    public static int[] getIntArray(int intArrayId) {
        return getResources().getIntArray(intArrayId);
    }

    public static String[] getStringArray(int intArrayId) {
        return getResources().getStringArray(intArrayId);
    }

    /**
     * @return drawable size.</br>
     * size[0]=width</br>
     * size[1]=height</br>
     */
    public static int[] getDrawableSize(int aResID) {
        int[] ret;
        Drawable d = getDrawable(aResID);
        if (null == d) {
            ret = new int[]{
                    0, 0
            };
        } else {
            ret = new int[]{
                    d.getIntrinsicWidth(), d.getIntrinsicHeight()
            };
        }
        return ret;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static StateListAnimator getStateListAnimator(int animId) {
        return AnimatorInflater.loadStateListAnimator(RuntimeContext.sApplicationContext, animId);
    }
}
