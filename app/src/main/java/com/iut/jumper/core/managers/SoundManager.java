package com.iut.jumper.core.managers;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.iut.jumper.R;
import com.iut.jumper.activities.AActivity;

public class SoundManager {

    private SoundPool soundPool;
    private AudioManager audioManager;

    private boolean loaded;
    private boolean sound;

    private int musicID;
    private int jumpSoundID;

    public SoundManager(Context context, boolean sound) {
        this.sound = sound;
        ((AActivity)context).setVolumeControlStream(AudioManager.STREAM_MUSIC);

        if (!sound) {
            return;
        }

        this.soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        this.jumpSoundID = soundPool.load(context, R.raw.jump_sound2, 1);
        this.musicID = soundPool.load(context, R.raw.electronika, 1);
        this.audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public void playJumpSound() {
        if (!sound) {
            return;
        }

        float actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;

        if (loaded) {
            soundPool.play(jumpSoundID, volume, volume, 2, 0, 1f);
        }
    }

    public void playMusic() {
        if (!sound) {
            return;
        }

        float actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;

        if (loaded) {
            soundPool.play(musicID, volume, volume, 1, -1, 1f);
        }
    }

}
