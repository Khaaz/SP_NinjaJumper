package com.iut.jumper.core.managers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class SensorService implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    public SensorService(Context context) {
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
        Log.d("JUMPER-SENSOR", String.valueOf(event.values[0])); // x
        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[1])); // y
        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[2])); // z
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
