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
import com.iut.jumper.models.Jumper;

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

        Jumper ijumper = this.instanceManager.getJumper();
        Bitmap bjumper = BitmapFactory.decodeResource(getResources(), ijumper.getSkin());
        this.jumper = Bitmap.createScaledBitmap(bjumper, ijumper.getWidth(), ijumper.getHeight(), true);

    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("View", "constructor 3");
    }

    @Override
    protected void onDraw(Canvas canvas) {

        synchronized (sFrameLock) {
            canvas.drawBitmap(this.jumper, (int)this.instanceManager.getJumper().getPosX(), (int)this.instanceManager.getJumper().getPosY(), null);
        }
    }
}
