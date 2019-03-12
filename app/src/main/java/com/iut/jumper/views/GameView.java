package com.iut.jumper.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.iut.jumper.R;
import com.iut.jumper.activities.GameActivity;

public class GameView extends View {

    private Bitmap perso;

    public GameView(Context context) {
        super(context);
        Log.d("View", "constructor 1");
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("View", "constructor 2");
        perso = BitmapFactory.decodeResource(getResources(), R.drawable.doodle);

        GameActivity activity = (GameActivity)context;

    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("View", "constructor 3");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(this.perso, 0, 0, null);
        canvas.drawBitmap(this.perso, 500, 500, null);
    }
}
