package com.manuver.learner;

import android.content.Context;
import android.widget.Toast;

public class Util {
    public static void toast(String s, Context context) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}
