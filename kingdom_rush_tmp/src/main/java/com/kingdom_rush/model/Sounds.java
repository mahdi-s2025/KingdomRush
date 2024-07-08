package com.kingdom_rush.model;

import javafx.scene.media.Media;

import java.io.File;

public class Sounds {
    private static Sounds sound;

    public Media btn_normal_hover;
    protected Media btn_special_hover;
    protected Media btn_normal_click, btn_special_click;

    private Sounds() {
        String soundsPath = "src/main/resources/sounds/";
        btn_normal_hover = new Media(new File(soundsPath + "/buttons/hover/btn_normal.mp3").toURI().toString());
    }

    public static Sounds getSound() {
        if (sound == null) {
            sound = new Sounds();
        }
        return sound;
    }
}
