package com.twistral.apps.calculator;


import com.twistral.Main;
import com.twistral.utils.MyScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CalculatorApplication extends Application {

    private Stage stage;

    @Override
    public void init() {}

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // main
        stage.setScene(getSceneCalculator());

        // stage setup
        stage.setTitle("Calculator");
        stage.show();
    }


    @Override
    public void stop() {
        System.exit(0);
        Platform.exit();
    }


    /*  GETTERS AND SETTERS  */
    public Stage getStage() { return stage; }

    public MyScene getSceneCalculator() {
        return new CalculatorScene(this, new VBox());
    }



}
