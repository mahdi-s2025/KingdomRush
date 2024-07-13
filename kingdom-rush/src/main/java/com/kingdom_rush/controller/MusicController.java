package com.kingdom_rush.controller;

import lombok.Getter;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

@Getter
public class MusicController {
    private Clip music;
    private long muteTime;

    public MusicController(String path) {
        try {
            File musicFile = new File(path);
            AudioInputStream musicStream = AudioSystem.getAudioInputStream(musicFile);
            music = AudioSystem.getClip();
            music.open(musicStream);
            music.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(System.err);
        }
    }

    public void mute() {
        muteTime = System.currentTimeMillis();
        music.stop();
    }

    public void unmute() {
        long time = System.currentTimeMillis() - muteTime;
        time *= 1000;
        time %= music.getMicrosecondLength();
        long newTime = music.getMicrosecondPosition() + time;
        newTime %= music.getMicrosecondLength();
        music.setMicrosecondPosition(newTime);
        music.loop(Clip.LOOP_CONTINUOUSLY);
        music.start();
    }
}
