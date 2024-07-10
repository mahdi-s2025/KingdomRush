package com.kingdom_rush.controller;

import lombok.Getter;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

@Getter
public class MusicController {
    private Clip music;
    private FloatControl volumeControl;

    public MusicController(String path) {
        try {
            File musicFile = new File(path);
            AudioInputStream musicStream = AudioSystem.getAudioInputStream(musicFile);
            music = AudioSystem.getClip();
            music.open(musicStream);
            music.loop(Clip.LOOP_CONTINUOUSLY);
            volumeControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace(System.err);
        }
    }

    public void mute() {
        volumeControl.setValue(volumeControl.getMinimum());
    }

    public void unmute() {
        volumeControl.setValue(volumeControl.getMaximum());
    }
}
