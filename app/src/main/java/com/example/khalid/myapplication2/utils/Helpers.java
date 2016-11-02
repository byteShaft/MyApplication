package com.example.khalid.myapplication2.utils;

import android.os.Build;
import android.widget.ImageView;

/**
 * Created by s9iper1 on 10/9/16.
 */

public class Helpers {

    public static void setImageViewIcon(ImageView imageView, int drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.setImageDrawable(AppGlobals.getContext().getResources().getDrawable(drawable,
                    AppGlobals.getContext().getTheme()));
        } else {
            imageView.setImageDrawable(AppGlobals.getContext().getResources().getDrawable(drawable));
        }
    }
}
