package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import com.kingdom_rush.model.*;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.sound.sampled.Clip;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class MapController implements Initializable {
    private static final Player player;
    @Setter @Getter
    private static Map map;
    private static Timer timer;
    private static int waveCounter;
    private static FXMLLoader fxmlLoader;
    @Getter
    private final static MapController instance = new MapController();

    static {
        player = PlayerController.getInstance().getPlayer();
        waveCounter = 0;
    }

    public static Scene getScene() {
        waveCounter = 0;
        fxmlLoader = new FXMLLoader(Main.class.getResource("map-view.fxml"));
        Scene scene = null;
        map.getMusicController().getMusic().loop(Clip.LOOP_CONTINUOUSLY);
        map.getMusicController().getMusic().start();
        try {
            scene = new Scene(fxmlLoader.load(), 1280, 720);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        return scene;
    }


    @FXML
    private ImageView btn_map;

    @FXML
    private ImageView btn_sound;

    @FXML
    private ImageView btn_tick;

    @FXML
    private ImageView img_coin_spell;

    @FXML
    private ImageView img_freeze_spell;

    @FXML
    private ImageView img_health_spell;

    @FXML
    private ImageView img_littleBoy_spell;

    @FXML
    private ImageView img_map;

    @FXML
    private Label lbl_coin;

    @FXML
    private Label lbl_coin_spell;

    @FXML
    private Label lbl_freeze_spell;

    @FXML
    private Label lbl_health;

    @FXML
    private Label lbl_health_spell;

    @FXML
    private Label lbl_littleBoy_spell;

    @FXML
    private Label lbl_wave;

    @FXML
    private AnchorPane root;

    @FXML
    void btn_map_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_special_click);
        mediaPlayer.play();
        HomePageController.getMainThemeMusic().getMusic().start();

        // it may to close some Thread
        if (timer != null)
            timer.cancel();
        map.getMusicController().getMusic().close();

        Main.getPrimaryStage().setScene(HomePageController.getScene());
    }

    @FXML
    void btn_sound_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_special_click);
        mediaPlayer.play();
        if (btn_sound.getImage().equals(Images.getImage().mute)) {
            map.getMusicController().unmute();
            btn_sound.setImage(Images.getImage().unmute);
        }
        else {
            map.getMusicController().mute();
            btn_sound.setImage(Images.getImage().mute);
        }
    }

    @FXML
    void btn_tick_mouseClicked(MouseEvent event) {
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();
        btn_tick.setVisible(false);
        Wave[] waves = map.getWaves();
        ArrayList<Raider> wave = waves[waveCounter++].getWave();
        new Thread(() -> {
            for (Raider raider : wave) {
                Platform.runLater(() -> {
                    root.getChildren().add(raider);
                    raider.move();
                    raider.getPathTransition().setOnFinished(event2 -> {
                        map.setHealth(map.getHealth() - raider.getPower());
                        lbl_health.setText(String.valueOf(map.getHealth()));
                        root.getChildren().remove(raider);
                    });
                });
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                boolean isRaider = false;
                ArrayList<Node> nodes = new ArrayList<>(root.getChildren());
                for (Node node : nodes) {
                    if (node instanceof Raider) {
                        isRaider = true;
                        break;
                    }
                }

                if (!isRaider) {
                    if (waveCounter < waves.length) {
                        Platform.runLater(() -> {
                            lbl_wave.setText(waveCounter + 1 + "/" + waves.length);
                            btn_tick.setVisible(true);
                        });
                        timer.cancel();
                    } else {
                        // show finish page
                        System.out.println("finished");
                        timer.cancel();
                    }
                }
            }
        }, 10000, 10000);
    }

    @FXML
    void img_coin_spell_mouseClicked(MouseEvent event) {
        if (player.getBackpack().get("coin").getNumber() <= 0) return;
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().coin_spell);
        mediaPlayer.play();
        MapController controller = fxmlLoader.getController();
        player.getBackpack().get("coin").drop(map, controller.root);
        lbl_coin.setText(String.valueOf(map.getCoin()));
        lbl_coin_spell.setText(String.valueOf(player.getBackpack().get("coin").getNumber()));
    }

    @FXML
    void img_freeze_spell_mouseClicked(MouseEvent event) {
        if (player.getBackpack().get("freeze").getNumber() <= 0) return;
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().freeze_spell);
        mediaPlayer.play();
        MapController controller = fxmlLoader.getController();
        player.getBackpack().get("freeze").drop(map, controller.root);
        lbl_freeze_spell.setText(String.valueOf(player.getBackpack().get("freeze").getNumber()));
    }

    @FXML
    void img_health_spell_mouseClicked(MouseEvent event) {
        if (player.getBackpack().get("health").getNumber() <= 0) return;
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().health_spell);
        mediaPlayer.play();
        MapController controller = fxmlLoader.getController();
        player.getBackpack().get("health").drop(map, controller.root);
        lbl_health.setText(String.valueOf(map.getHealth()));
        lbl_health_spell.setText(String.valueOf(player.getBackpack().get("health").getNumber()));
    }

    @FXML
    void img_littleBoy_spell_mouseClicked(MouseEvent event) {
        if (player.getBackpack().get("littleBoy").getNumber() <= 0) return;
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().bomb_spell);
        mediaPlayer.play();
        MapController controller = fxmlLoader.getController();
        player.getBackpack().get("littleBoy").drop(map, controller.root);
        lbl_littleBoy_spell.setText(String.valueOf(player.getBackpack().get("littleBoy").getNumber()));
    }

    @FXML
    void img_map_mouseClicked(MouseEvent event) {
        System.out.println(event.getX());
        System.out.println(event.getY());
        ArrayList<Node> nodes = new ArrayList<>(root.getChildren());
        for (Node node : nodes) {
            if (node instanceof ImageView imageView) {
                if ((imageView.getImage() == null || imageView.getImage().equals(Images.getImage().update_bar) ||
                        imageView.getImage().equals(Images.getImage().tower_bar))) {
                    root.getChildren().remove(imageView);
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbl_wave.setText("1/" + map.getWaves().length);
        img_map.setImage(map.getMapImage());
        lbl_coin.setText(String.valueOf(map.getCoin()));
        lbl_health.setText(String.valueOf(map.getHealth()));
        lbl_coin_spell.setText(String.valueOf(player.getBackpack().get("coin").getNumber()));
        lbl_freeze_spell.setText(String.valueOf(player.getBackpack().get("freeze").getNumber()));
        lbl_littleBoy_spell.setText(String.valueOf(player.getBackpack().get("littleBoy").getNumber()));
        lbl_health_spell.setText(String.valueOf(player.getBackpack().get("health").getNumber()));

        for (int[] coordination : map.getTowerCoordinations()) {
            ImageView towerPlace = new ImageView(Images.getImage().tower_place);
            towerPlace.setPreserveRatio(true);
            towerPlace.setSmooth(true);
            towerPlace.setCursor(Cursor.HAND);
            towerPlace.setFitWidth(100);
            towerPlace.setFitHeight(60);
            towerPlace.setX(coordination[0]);
            towerPlace.setY(coordination[1]);

            towerPlace.setOnMouseClicked(event -> {
                ArrayList<Node> nodes = new ArrayList<>(root.getChildren());
                for (Node node : nodes) {
                    if (node instanceof ImageView imageView) {
                        if ((imageView.getImage() == null || imageView.getImage().equals(Images.getImage().update_bar) ||
                                imageView.getImage().equals(Images.getImage().tower_bar))) {
                            root.getChildren().remove(imageView);
                        }
                    }
                }
                MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
                mediaPlayer.play();
                ImageView towerBar = new ImageView(Images.getImage().tower_bar);
                towerBar.setPreserveRatio(true);
                towerBar.setSmooth(true);
                towerBar.setCursor(Cursor.HAND);
                towerBar.setFitWidth(185);
                towerBar.setFitHeight(173);
                towerBar.setX(coordination[0] - 36);
                towerBar.setY(coordination[1] - 58);

                towerBar.setOnMouseClicked(event2 -> {
                    if ((event2.getX() < towerPlace.getX() + 23) && (event2.getY() < towerPlace.getY() + 11)) {
                        if (map.getCoin() < Archer.getCost()) return;
                        MapController controller = fxmlLoader.getController();
                        Archer archer = new Archer();
                        archer.getReady(controller.root);
                        archer.setX(towerPlace.getX()-4);
                        archer.setY(towerPlace.getY()-20);
                        root.getChildren().remove(towerBar);
                        root.getChildren().add(archer);
                        map.setCoin(map.getCoin()-Archer.getCost());
                        lbl_coin.setText(String.valueOf(map.getCoin()));

                    } else if ((event2.getX() < towerPlace.getX() + 23) && (event2.getY() > towerPlace.getY() + 47)) {
                            if (map.getCoin() < Mega.getCost()) return;
                            MapController controller = fxmlLoader.getController();
                            Mega mega = new Mega();
                            mega.getReady(controller.root);
                            mega.setX(towerPlace.getX() - 2);
                            mega.setY(towerPlace.getY() - 20);
                            root.getChildren().remove(towerBar);
                            root.getChildren().add(mega);
                            map.setCoin(map.getCoin() - Mega.getCost());
                            lbl_coin.setText(String.valueOf(map.getCoin()));
                        } else if ((event2.getX() > towerPlace.getX() + 75) && (event2.getY() > towerPlace.getY() + 47)) {
                                if (map.getCoin() < Bertha.getCost()) return;
                                MapController controller = fxmlLoader.getController();
                                Bertha bertha = new Bertha();
                                bertha.getReady(controller.root);
                                bertha.setX(towerPlace.getX() + 5);
                                bertha.setY(towerPlace.getY());
                                root.getChildren().remove(towerBar);
                                root.getChildren().add(bertha);
                                map.setCoin(map.getCoin() - Bertha.getCost());
                                lbl_coin.setText(String.valueOf(map.getCoin()));
                            }
                });

                root.getChildren().add(towerBar);
            });

            root.getChildren().add(towerPlace);
        }
    }
}
