package com.fesven.marcos;

import android.graphics.Bitmap;

class FotoSingleton {
    private static final FotoSingleton ourInstance = new FotoSingleton();
    private Bitmap bitmap;

    static FotoSingleton getInstance() {
        return ourInstance;
    }

    private FotoSingleton() {
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
