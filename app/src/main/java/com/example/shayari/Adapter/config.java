package com.example.shayari.Adapter;

import android.os.Environment;

import com.example.shayari.R;

import java.io.File;

public class config {
    public static int gradArr[] = {R.drawable.bg_gradient, R.drawable.bg_gradient1, R.drawable.bg_gradient2,
            R.drawable.bg_gradient3, R.drawable.bg_gradient4,
            R.drawable.bg_gradient5, R.drawable.bg_gradient6,
            R.drawable.bg_gradient7, R.drawable.bg_gradient8,
            R.drawable.bg_gradient9};

    public static int color[] = {R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5, R.color.color6, R.color.color7,
            R.color.color8, R.color.color9, R.color.color10, R.color.color11, R.color.color12, R.color.color13, R.color.color14};
    public static String[] fontsArr={"ALGER.TTF","ARLRDBD.TTF","BRUSHSCI.TTF","CASTELAR.TTF","COLONNA.TTF","CURLZ___.TTF","GOTHIC.TTF","GOTHICB.TTF",
            "GOTHICBI.TTF","GOTHICI.TTF","HARNGTON.TTF","Inkfree.ttf","ITCEDSCR.TTF"};


    public static String[] emojiArr={"😀😁😂🤣😃😄","😋😊😉😆😅😍","😘🥰😗😙🥲🤔","🤩🤗🙂☺😚🤨","😐😑😶😶‍🌫️🙄","😯🤐😮😥😣😏","❣💕💞💓💗💖","❤️🧡💛💚💙💜"};

    public static File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
}