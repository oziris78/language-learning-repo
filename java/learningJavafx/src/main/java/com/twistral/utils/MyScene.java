package com.twistral.utils;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class MyScene<T extends Application, R extends Parent> extends Scene {

    protected final T app;
    protected final R root;

    public MyScene(T app, R root, Paint fill) {
        super(root, fill);
        this.root = root;
        this.app = app;

    }

    public MyScene(T app, R root) {
        this(app, root, Color.WHITE);
    }

}
