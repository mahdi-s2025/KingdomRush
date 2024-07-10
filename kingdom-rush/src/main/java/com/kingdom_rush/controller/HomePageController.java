package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @Getter
    private final static Scene scene;

    @Getter
    private final static MusicController mainThemeMusic;

    static {
        mainThemeMusic = new MusicController("src/main/resources/musics/MainTheme.wav");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home-page-view.fxml"));
        Scene tmp = null;
        try {
            tmp = new Scene(fxmlLoader.load(), 1280, 720);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        scene = tmp;
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

    }

    @FXML
    void btn_level2_place_mouseClicked(MouseEvent event) {

    }

    @FXML
    void btn_level3_place_mouseClicked(MouseEvent event) {

    }

    @FXML
    void btn_level4_place_mouseClicked(MouseEvent event) {

    }

    @FXML
    void btn_logout_mouseClicked(MouseEvent event) {
        PlayerController.getInstance().setPlayer(null);
        Main.getPrimaryStage().setScene(FirstVideoController.getInstance().getNextScene());
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

    }

    @FXML
    void btn_settings_mouseEntered(MouseEvent event) {

    }

    @FXML
    void btn_settings_mouseExited(MouseEvent event) {

    }

    @FXML
    void btn_shop_mouseEntered(MouseEvent event) {

    }

    @FXML
    void btn_shop_mouseClicked(MouseEvent event) {

    }

    @FXML
    void btn_shop_mouseExited(MouseEvent event) {

    }

//    private static void showLevels() {

//    }
//
//    public static Scene getScene() {
//        showLevels();
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home-page-view.fxml"));
//        Scene scene = null;
//        try {
//            scene = new Scene(fxmlLoader.load(), 1280, 720);
//        } catch (IOException e) {
//            e.printStackTrace(System.err);
//        }
//        return scene;
//    }
}
