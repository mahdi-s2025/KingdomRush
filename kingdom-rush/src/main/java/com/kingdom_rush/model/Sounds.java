package com.kingdom_rush.model;

import javafx.scene.media.Media;

import java.io.File;

public class Sounds {
    private static Sounds sound;

    public Media btn_normal_hover, btn_special_hover;
    public Media btn_normal_click, btn_special_click, cash_effect;

    private Sounds() {
        String soundsPath = "src/main/resources/sounds/";
        btn_normal_hover = new Media(new File(soundsPath + "/buttons/hover/btn_normal.mp3").toURI().toString());
        btn_special_hover = new Media(new File(soundsPath + "/buttons/hover/btn_special.mp3").toURI().toString());
        btn_normal_click = new Media(new File(soundsPath + "/buttons/click/btn_normal.mp3").toURI().toString());
        btn_special_click = new Media(new File((soundsPath + "/buttons/click/btn_special.mp3")).toURI().toString());
        cash_effect = new Media(new File(soundsPath + "/buttons/click//cash.mp3").toURI().toString());
    }

    public static Sounds getSound() {
        if (sound == null) {
            sound = new Sounds();
        }
        return sound;
    }
}
