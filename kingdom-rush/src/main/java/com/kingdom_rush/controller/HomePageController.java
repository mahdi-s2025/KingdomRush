package com.kingdom_rush.controller;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.kingdom_rush.Main;
import com.kingdom_rush.model.Images;
import com.kingdom_rush.model.Map;
import com.kingdom_rush.model.Sounds;
import com.kingdom_rush.model.Wave;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import lombok.Getter;

import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @Getter
    private final static MusicController mainThemeMusic;
    private static Scene scene;

    public static Scene getScene() {
        mainThemeMusic.getMusic().loop(Clip.LOOP_CONTINUOUSLY);
        mainThemeMusic.getMusic().start();
        SettingController.resetSettingStage();
        scene = null;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home-page-view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load(), 1280, 720);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        return scene;
    }

    public static Scene getOnleyScene() {
        return scene;
    }

    static {
        mainThemeMusic = new MusicController("src/main/resources/musics/MainTheme.wav");
    }

    @FXML
    private ImageView btn_level1_place;

    @FXML
    private ImageView btn_level2_place;

    @FXML
    private ImageView btn_level3_place;

    @FXML
    private ImageView btn_level4_place;

    @FXML
    private ImageView btn_logout;

    @FXML
    private ImageView btn_settings;

    @FXML
    private ImageView btn_shop;

    @FXML
    private Label lbl_diamond_bar;

    @FXML
    private ImageView star1_level1;

    @FXML
    private ImageView star1_level2;

    @FXML
    private ImageView star1_level3;

    @FXML
    private ImageView star1_level4;

    @FXML
    private ImageView star2_level1;

    @FXML
    private ImageView star2_level2;

    @FXML
    private ImageView star2_level3;

    @FXML
    private ImageView star2_level4;

    @FXML
    private ImageView star3_level1;

    @FXML
    private ImageView star3_level2;

    @FXML
    private ImageView star3_level3;

    @FXML
    private ImageView star3_level4;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ImageView[][] levels = new ImageView[][]{{btn_level1_place, star1_level1, star2_level1, star3_level1},
                {btn_level2_place, star1_level2, star2_level2, star3_level2}, {btn_level3_place, star1_level3, star2_level3, star3_level3},
                {btn_level4_place, star1_level4, star2_level4, star3_level4}};
        lbl_diamond_bar.setText(String.valueOf(PlayerController.getInstance().getPlayer().getDiamondsNum()));

        int[] stars = PlayerController.getInstance().getPlayer().getStars();
        stars[0] = 2;  // for test
        stars[1] = 3;
        int i = 0;
        for (; i < 4; i++) {
            if (stars[i] == 0) break;
            for (int j = 0; j < stars[i] + 1; j++) {
                levels[i][j].setVisible(true);
            }
        }
        levels[i][0].setVisible(true);
    }

    @FXML
    void btn_level1_place_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();
        mainThemeMusic.getMusic().stop();
        mainThemeMusic.getMusic().setFramePosition(0);


        MusicController level1Music = new MusicController("src/main/resources/musics/IceWindPass.wav");

        int[][] coordinations = {{427, 248}, {515, 219}, {524, 377}, {523, 455},
                {626, 456}, {811, 468}, {699, 582}, {969, 547}};

        MoveTo moveTo = new MoveTo(690, -60);
        LineTo line1 = new LineTo(690, 233);
        LineTo line2 = new LineTo(490, 360);
        LineTo line3 = new LineTo(495, 520);
        LineTo line4 = new LineTo(925, 540);
        LineTo line5 = new LineTo(1045, 450);
        LineTo line6 = new LineTo(1320, 450);
        Path[] paths = {new Path(moveTo, line1, line2, line3, line4, line5, line6)};

        // change the waves

        int[][] wave1_distro = {{3, 5}, {2, 3}, {3, 5}, {1, 4}, {2, 3}};
        Wave wave1 = new Wave(wave1_distro, paths);

        int[][] wave2_distro = {{3, 8}, {2, 5}, {1, 4}, {2, 5}, {1, 4}};
        Wave wave2 = new Wave(wave2_distro, paths);

        Wave[] waves = {wave1, wave2};

        Map level1 = new Map(Images.getImage().map_1, coordinations, 200, 20, level1Music, waves);
        MapController.setMap(level1);
        Main.getPrimaryStage().setScene(MapController.getScene());

    }

    @FXML
    void btn_level2_place_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();

        mainThemeMusic.getMusic().stop();
        mainThemeMusic.getMusic().setFramePosition(0);


        MusicController level1Music = new MusicController("src/main/resources/musics/UnderAttack.wav");

        int[][] coordinations = {{773, 156}, {771, 239}, {590, 177}, {522, 325},
                {698, 456}, {597, 476}, {712, 605}};

        MoveTo moveTo = new MoveTo(1330, 240);
        LineTo line1 = new LineTo(945, 270);
        LineTo line2 = new LineTo(870, 115);
        LineTo line3 = new LineTo(755, 150);
        LineTo line4 = new LineTo(678, 282);
        LineTo line5 = new LineTo(500, 315);
        LineTo line6 = new LineTo(493, 430);
        LineTo line7 = new LineTo(845, 436);
        LineTo line8 = new LineTo(840, 570);
        LineTo line9 = new LineTo(685, 605);
        LineTo line10 = new LineTo(675, 760);
        Path[] paths = {new Path(moveTo, line1, line2, line3, line4, line5, line6, line7, line8, line9, line10)};

        // change the waves

        int[][] wave1_distro = {{3, 5}, {2, 3}, {3, 5}, {1, 4}, {2, 3}};
        Wave wave1 = new Wave(wave1_distro, paths);

        int[][] wave2_distro = {{3, 8}, {2, 5}, {1, 4}, {2, 5}, {1, 4}};
        Wave wave2 = new Wave(wave2_distro, paths);

        int[][] wave3_distro = {{3, 8}, {2, 5}, {1, 4}, {2, 5}};

        Wave[] waves = {wave1, wave2};

        Map level1 = new Map(Images.getImage().map_1, coordinations, 200, 20, level1Music, waves);
        MapController.setMap(level1);
        Main.getPrimaryStage().setScene(MapController.getScene());
    }

    @FXML
    void btn_level3_place_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();
    }

    @FXML
    void btn_level4_place_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();
    }

    @FXML
    void btn_logout_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_special_click);
        mediaPlayer.play();
        PlayerController.getInstance().setPlayer(null);
        Main.getPrimaryStage().setScene(FirstVideoController.getInstance().getNextScene());
        LoginController.getLoginStage().setScene(LoginController.getLoginScene());
        mainThemeMusic.getMusic().stop();
        mainThemeMusic.getMusic().setFramePosition(0);
    }

    @FXML
    void btn_logout_mouseEntered(MouseEvent event) {
        btn_logout.setOpacity(1);
    }

    @FXML
    void btn_logout_mouseExited(MouseEvent event) {
        btn_logout.setOpacity(0.7);
    }

    @FXML
    void btn_settings_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();
        SettingController.getSettingStage().show();
    }

    @FXML
    void btn_settings_mouseEntered(MouseEvent event) {
        btn_settings.setImage(Images.getImage().setting_hover);
    }

    @FXML
    void btn_settings_mouseExited(MouseEvent event) {
        btn_settings.setImage(Images.getImage().setting);
    }

    @FXML
    void btn_shop_mouseEntered(MouseEvent event) {
        btn_shop.setImage(Images.getImage().shop_hover);
    }

    @FXML
    void btn_shop_mouseClicked(MouseEvent event) {
        Main.getPrimaryStage().setScene(ShopController.getScene());
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();
    }

    @FXML
    void btn_shop_mouseExited(MouseEvent event) {
        btn_shop.setImage(Images.getImage().shop);
    }
}
