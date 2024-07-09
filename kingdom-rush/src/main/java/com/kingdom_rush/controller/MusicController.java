package com.kingdom_rush.controller;

import lombok.Getter;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

@Getter
public class MusicController {
    private Clip music;

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
}
