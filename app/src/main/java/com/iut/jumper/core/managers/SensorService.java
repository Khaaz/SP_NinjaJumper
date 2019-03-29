package com.iut.jumper.core.managers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.WindowManager;

import com.iut.jumper.utils.Constants;

public class SensorService implements SensorEventListener {

    private final SensorManager sensorManager;
    private final Sensor sensor;

    private final GameService gameService;

    private final double delta = Constants.SENSOR_SENSIBILITY; // captor sensibility

    private double lastX = 0;

    private int screenOrientation;

     public SensorService(Context context, GameService gameService) {
         this.gameService = gameService;

         this.screenOrientation = this.gameService.getDisplay().getRotation();

         this.gameService.getDisplay().getRotation();

         sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
         sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void start() {
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    public void stop() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] values = this.adjustAccelOrientation(this.screenOrientation, event.values);
        double curX = values[0];

        if (sensibility(curX)) {
            //Log.d("JUMPER-SENSOR", "SENSIBLE"); // x
            //Log.d("JUMPER-SENSOR", String.valueOf(event.values[0])); // x

            this.gameService.getPositionManager().updateJumperDirection(curX < 0);

            double acceleration = this.calculateAcceleration(curX);
            this.gameService.getPositionManager().updateJumperSpeed(acceleration);

            this.lastX = curX;
        }

        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[0])); // x
        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[1])); // y
        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[2])); // z
    }

    private boolean sensibility(double curX) {
        return Math.abs(this.lastX - curX) > delta;
    }

    private double calculateAcceleration(double curX) {
        return Math.abs(Constants.SENSOR_TO_SPEED_MULTIPLIER * curX);
    }

    // https://stackoverflow.com/questions/5877780/orientation-from-android-accelerometer/15552017
    // http://developer.download.nvidia.com/tegra/docs/tegra_android_accelerometer_v5f.pdf
    private float[] adjustAccelOrientation(int displayRotation, float[] eventValues) {
        float[] adjustedValues = new float[3];

        final int axisSwap[][] = {
                {  1, -1, 0, 1 },     // ROTATION_0
                { -1, -1, 1, 0 },     // ROTATION_90
                { -1,  1, 0, 1 },     // ROTATION_180
                {  1,  1, 1, 0 }
        }; // ROTATION_270

        final int[] as = axisSwap[displayRotation];
        adjustedValues[0]  =  (float)as[0] * eventValues[ as[2] ];
        adjustedValues[1]  =  (float)as[1] * eventValues[ as[3] ];
        adjustedValues[2]  =  eventValues[2];

        return adjustedValues;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
