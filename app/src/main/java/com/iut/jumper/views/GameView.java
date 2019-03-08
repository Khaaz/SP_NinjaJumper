package com.iut.jumper.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.iut.jumper.R;

public class GameView extends View {

    private Paint painter;
    private Bitmap perso;

    public GameView(Context context) {
        super(context);
        Log.d("View", "constructor 1");
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("View", "constructor 2");
        this.painter = new Paint(Paint.ANTI_ALIAS_FLAG);
        // create bitmap

    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("View", "constructor 3");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //canvas.drawBitmap(this.perso, 0, 0, this.painter);
    }
}
