package com.kingdom_rush.model;

import com.google.common.collect.Multimap;
import javafx.scene.shape.Path;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Map;

@Getter
public class Wave {
    private final ArrayList<Raider> wave;

    public Wave(int[][] distributions, Path[] paths) {
        wave = new ArrayList<>();
        for (int[] distribution : distributions) {
            switch (distribution[0]) {
                case 1 -> {
                    for (int i = 0; i < distribution[1]; i++) {
                        wave.add(new FlyRaider());
                    }
                }
                case 2 -> {
                    for (int i = 0; i < distribution[1]; i++) {
                        wave.add(new ShieldRaider());
                    }
                }
                case 3 -> {
                    for (int i = 0; i < distribution[1]; i++) {
                        wave.add(new SpeedRaider());
                    }
                }
                // and the shoot
            }
        }
        int reminder = wave.size() % paths.length;
        int indicator = wave.size() / paths.length;
        int j = 0;
        for (int i = 1; i <= wave.size() ; i++) {
            if ((i % (indicator + 1)) == 0)
                j++;
            wave.get(i-1).setPath(paths[j]);
        }

        for (int i = wave.size() - 1; i >= wave.size() - reminder ; i--) {
            wave.get(i).setPath(paths[j]);
        }
    }
}
