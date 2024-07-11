package com.kingdom_rush.controller;

import com.kingdom_rush.Main;
import com.kingdom_rush.model.Images;
import com.kingdom_rush.model.Player;
import com.kingdom_rush.model.Sounds;
import com.kingdom_rush.model.spells.Spell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class ShopController implements Initializable {

    public static Scene getScene() {
        Scene scene = null;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("shop-view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load(), 1280, 720);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        return scene;
    }

    @FXML
    private ImageView btn_buy;

    @FXML
    private ImageView btn_coin;

    @FXML
    private ImageView btn_freeze;

    @FXML
    private ImageView btn_health;

    @FXML
    private ImageView btn_little_boy;

    @FXML
    private ImageView btn_tick;

    @FXML
    private ImageView img_coin;

    @FXML
    private ImageView img_freeze;

    @FXML
    private ImageView img_health;

    @FXML
    private ImageView img_little_boy;

    @FXML
    private Label lbl_coin_value;

    @FXML
    private Label lbl_diamond_bar;

    @FXML
    private Label lbl_freeze_value;

    @FXML
    private Label lbl_health_value;

    @FXML
    private Label lbl_littleBoy_value;

    @FXML
    private ImageView shop_image;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shop_image.setImage(Images.getImage().shop_health);
        Map<String, Spell> backpack = PlayerController.getInstance().getPlayer().getBackpack();
        lbl_diamond_bar.setText(String.valueOf(PlayerController.getInstance().getPlayer().getDiamondsNum()));
        setValue(img_coin, lbl_coin_value, backpack.get("coin").getNumber());
        setValue(img_freeze, lbl_freeze_value, backpack.get("freeze").getNumber());
        setValue(img_health, lbl_health_value, backpack.get("health").getNumber());
        setValue(img_little_boy, lbl_littleBoy_value, backpack.get("littleBoy").getNumber());

    }

    public void setValue(ImageView imageView, Label label, int value) {
        if (value == 0) {
            imageView.setVisible(false);
            label.setText(null);
        }
        else {
            imageView.setVisible(true);
            label.setText(String.valueOf(value));
        }
    }

    @FXML
    void btn_buy_mouseClicked(MouseEvent event) {
        Player player = PlayerController.getInstance().getPlayer();
        Map<String, Spell> backpack = player.getBackpack();
        String selectedSpell;
        ImageView img_product;
        Label lbl_product;

        if (shop_image.getImage().equals(Images.getImage().shop_freeze)) {
            selectedSpell = "freeze";
            img_product = img_freeze;
            lbl_product = lbl_freeze_value;
        } else if (shop_image.getImage().equals(Images.getImage().shop_coin)) {
            selectedSpell = "coin";
            img_product = img_coin;
            lbl_product = lbl_coin_value;
        } else if (shop_image.getImage().equals(Images.getImage().shop_health)) {
            selectedSpell = "health";
            img_product = img_health;
            lbl_product = lbl_health_value;
        } else {
            selectedSpell = "littleBoy";
            img_product = img_little_boy;
            lbl_product = lbl_littleBoy_value;
        }

        if (PlayerController.getInstance().getPlayer().getDiamondsNum() < backpack.get(selectedSpell).getPrice()) return;

        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().cash_effect);
        mediaPlayer.play();

        player.setDiamondsNum(player.getDiamondsNum() - backpack.get(selectedSpell).getPrice());
        backpack.get(selectedSpell).setNumber(backpack.get(selectedSpell).getNumber() + 1);
        DBController.getInstance().updatePlayer(player, "diamonds", String.valueOf(player.getDiamondsNum()));
        DBController.getInstance().updateSpell(player, selectedSpell, backpack.get(selectedSpell).getNumber());

        lbl_diamond_bar.setText(String.valueOf(player.getDiamondsNum()));
        setValue(img_product, lbl_product, backpack.get(selectedSpell).getNumber());
    }

    @FXML
    void btn_buy_mouseEntered(MouseEvent event) {
        btn_buy.setImage(Images.getImage().buy_hover);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_special_hover);
        mediaPlayer.play();
    }

    @FXML
    void btn_buy_mouseExited(MouseEvent event) {
        btn_buy.setImage(null);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_special_hover);
        mediaPlayer.play();
    }

    @FXML
    void btn_coin_mouseClicked(MouseEvent event) {
        shop_image.setImage(Images.getImage().shop_coin);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();

    }

    @FXML
    void btn_freeze_mouseClicked(MouseEvent event) {
        shop_image.setImage(Images.getImage().shop_freeze);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();
    }

    @FXML
    void btn_health_mouseClicked(MouseEvent event) {
        shop_image.setImage(Images.getImage().shop_health);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();
    }

    @FXML
    void btn_little_boy_mouseClicked(MouseEvent event) {
        shop_image.setImage(Images.getImage().shop_little_boy);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_normal_click);
        mediaPlayer.play();
    }

    @FXML
    void btn_tick_mouseClicked(MouseEvent event) {
        Main.getPrimaryStage().setScene(HomePageController.getScene());
    }

    @FXML
    void btn_tick_mouseEntered(MouseEvent event) {
        btn_tick.setImage(Images.getImage().tick_hover);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_special_hover);
        mediaPlayer.play();
    }

    @FXML
    void btn_tick_mouseExited(MouseEvent event) {
        btn_tick.setImage(null);
        MediaPlayer mediaPlayer = new MediaPlayer(Sounds.getSound().btn_special_hover);
        mediaPlayer.play();
    }
}
