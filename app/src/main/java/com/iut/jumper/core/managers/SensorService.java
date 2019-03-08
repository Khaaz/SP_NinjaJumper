package com.iut.jumper.core.managers;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.iut.jumper.models.Personnage;
import com.iut.jumper.utils.Constants;

public class SensorService implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;

    private double lastX = 0;
    private final double delta = Constants.SENSOR_SENSIBILITY; // captor sensibility


    private Personnage perso = null;
    public Personnage getPerso() { return perso; }

    public void setPerso(Personnage pperso) { this.perso = pperso; }

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
        if (sensibility(event.values[0])) {
            Log.d("JUMPER-SENSOR", "SENSIBLE"); // x
            Log.d("JUMPER-SENSOR", String.valueOf(event.values[0])); // x
            double acceleration = this.calculateAcceleration();
            // update perso acceleration/movement value (Position manager handles position)
        }
        //this.lastX = event.values[0];
        /*
        perso.setSpeedX(perso.getSpeedX() + x);
        if(perso.getSpeedX() > perso.Vit_Max){
            perso.setSpeedX(perso.Vit_Max);
        }
        float nposx = perso.getMyX() + perso.getSpeedX();
        perso.setMyX(nposx);

        if (event.values[0] > 0){
            Log.d("Dirx", "Gauche");
        }
        else{
            Log.d("Dirx", "Droite");
        }*/

        //Log.d("Pos", String.valueOf(perso.getMyX()));
        //Log.d("Spd", String.valueOf(perso.getSpeedX()));
        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[0])); // x
        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[1])); // y
        //Log.d("JUMPER-SENSOR", String.valueOf(event.values[2])); // z
    }

    private boolean sensibility(double curX) {
        if (Math.abs(this.lastX - curX) > delta) {
            this.lastX = curX;
            return true;
        }
        return false;
    }

    private double calculateAcceleration() {
        return 0;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
