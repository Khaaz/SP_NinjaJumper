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
import com.iut.jumper.core.managers.InstanceManager;
import com.iut.jumper.interfaces.IUpdatable;

public class GameView extends View {

    private InstanceManager instanceManager;

    private Bitmap jumper;

    private static final Object sFrameLock = new Object();

    public GameView(Context context) {
        super(context);
        Log.d("View", "constructor 1");
    }


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("View", "constructor 2");

        this.instanceManager = ((GameActivity)context).getGameService().getInstanceManager();

        this.jumper = BitmapFactory.decodeResource(getResources(), this.instanceManager.getJumper().getSkin());

    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("View", "constructor 3");
    }

    @Override
    protected void onDraw(Canvas canvas) {

        synchronized (sFrameLock) {
            Log.d("GAMEVIEW", "ONDRAW");
            canvas.drawBitmap(this.jumper, 0, 0, null);
        }
    }
}
