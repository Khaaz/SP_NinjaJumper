package com.iut.jumper.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.iut.jumper.activities.GameActivity;
import com.iut.jumper.core.managers.InstanceManager;
import com.iut.jumper.models.APlateform;
import com.iut.jumper.models.Jumper;

import java.util.HashMap;
import java.util.Map;

public class GameView extends View {

    private InstanceManager instanceManager;

    private Bitmap jumper;
    private Bitmap jumperReverse;

    private Map<String, Bitmap> plateforms;

    private static final Object sFrameLock = new Object();

    public GameView(Context context) {
        super(context);
    }


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.instanceManager = ((GameActivity)context).getGameService().getInstanceManager();

        // Create jumper bitmaps
        this.createJumperBitmaps(this.instanceManager.getJumper());

        // create plateforms bitmaps
        this.plateforms = new HashMap<>();
    }

    private void createJumperBitmaps(Jumper ijumper) {
        Bitmap bjumper = BitmapFactory.decodeResource(getResources(), ijumper.getSkin());
        this.jumper = Bitmap.createScaledBitmap(bjumper, ijumper.getWidth(), ijumper.getHeight(), true);

        Bitmap bjumperR = BitmapFactory.decodeResource(getResources(), ijumper.getSkinReverse());
        this.jumperReverse = Bitmap.createScaledBitmap(bjumperR, ijumper.getWidth(), ijumper.getHeight(), true);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        synchronized (sFrameLock) {
            for(APlateform p : this.instanceManager.getPlateforms()) {
                canvas.drawBitmap(this.getOrCreatePlateformBitmap(p), (int)p.getPosX(), (int)p.getPosY(), null);
            }

            Jumper j = this.instanceManager.getJumper();
            canvas.drawBitmap(j.getDirection() ? this.jumper : this.jumperReverse, (int)j.getPosX(), (int)j.getPosY(), null);
        }
    }

    private Bitmap getOrCreatePlateformBitmap(APlateform p) {
        Bitmap b = this.plateforms.get(p.getType().name());
        if (b != null) {
            return b;
        }
        Bitmap tmp = BitmapFactory.decodeResource(getResources(), p.getType().getValue());
        b = Bitmap.createScaledBitmap(tmp, p.getWidth(), p.getHeight(), true);
        this.plateforms.put(p.getType().name(), b);
        return b;

    }
}
