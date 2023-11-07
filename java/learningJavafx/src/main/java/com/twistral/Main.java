package com.twistral;

import com.twistral.apps.cookieclicker.CookieClickerApplication;
import com.twistral.apps.minesweeper.MineSweeperApplication;
import com.twistral.exercises.controls.VideoPlayerTest;
import com.twistral.exercises.material.TrayIconTest;
import com.twistral.utils.resources.Resources;
import javafx.application.Application;


public class Main {

    public static final Resources res = new Resources();

    public static void main(String[] args) {
        Application.launch(MineSweeperApplication.class, args);
    }

}
