package com.kingdom_rush.model;

import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Bertha extends Tower {
    public Bertha() {
        super(1000, 50, 150, Images.getImage().bertha);
        setFitHeight(100);
        setFitWidth(74);
    }
    static {
        setCost(125);
    }

    public void shoot(AnchorPane root, Raider raider) {
        ImageView arrow = new ImageView(Images.getImage().arrow);
        setPreserveRatio(true);
        setFitHeight(70);
        setFitWidth(50);
        MoveTo moveTo = new MoveTo(getX() + 10, getY() + 10);
        LineTo lineTo = new LineTo(raider.getX() + 10, raider.getY() + 10);
        Path path = new Path(moveTo, lineTo);
        PathTransition pathTransition = new PathTransition(Duration.millis(200), path, arrow);
        pathTransition.setCycleCount(1);
        pathTransition.setAutoReverse(false);
        root.getChildren().add(arrow);
        pathTransition.play();
        pathTransition.setOnFinished((event) -> {
            root.getChildren().remove(arrow);
            if (raider.getRaiderType().equals(RaiderType.SHIELD)) {
                raider.setHealth(raider.getHealth() - this.getDestructionPower()/2);
            } else {
                raider.setHealth(raider.getHealth() - this.getDestructionPower());
            }
        });
        if (raider.getHealth() <= 0) {
            raider.getPathTransition().stop();
            root.getChildren().remove(raider);
        }
    }

    public void getReady(AnchorPane root) {

        new Thread(() -> {
            for (Node node : root.getChildren()) {
                if (node instanceof Raider raider) {
                    System.out.println("HI");
                    double distance = Math.sqrt(Math.pow((raider.getX()-10) - (getX()- 10),2) +
                            Math.pow((raider.getY()-10) - (getY()- 10),2));
                    System.out.println(distance);
                    if (distance < getRadius()) {
                        System.out.println("shoot");
                        shoot(root, raider);
                    }
                    if (raider.getHealth() <= 0) {
                        raider.getPathTransition().stop();
                        root.getChildren().remove(raider);
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
