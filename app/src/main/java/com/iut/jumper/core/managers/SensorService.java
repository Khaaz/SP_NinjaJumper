package com.iut.jumper.core.managers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.iut.jumper.utils.Constants;

public class SensorService implements SensorEventListener {

    private final SensorManager sensorManager;
    private final Sensor sensor;

    private final GameService gameService;

    private final double delta = Constants.SENSOR_SENSIBILITY; // captor sensibility

    private double lastX = 0;

     public SensorService(Context context, GameService gameService) {
        this.gameService = gameService;

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

         double curX = event.values[0];

        if (sensibility(curX)) {
            Log.d("JUMPER-SENSOR", "SENSIBLE"); // x
            Log.d("JUMPER-SENSOR", String.valueOf(event.values[0])); // x

            this.gameService.getPositionManager().updateJumperDirection(curX > this.lastX);
            this.lastX = curX;

            double acceleration = this.calculateAcceleration();
            this.gameService.getPositionManager().updateJumperSpeed(acceleration);
        }

        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[0])); // x
        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[1])); // y
        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[2])); // z
    }

    private boolean sensibility(double curX) {
        return Math.abs(this.lastX - curX) > delta;
    }

    private double calculateAcceleration() {
        return -Constants.SENSOR_TO_SPEED_MULTIPLIER * this.lastX;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
