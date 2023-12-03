package com.twistral.spaceshooters.main;

import com.badlogic.gdx.Game;

public class SpaceShooterGameMain extends Game {

	static int CUSTOM_WIDTH = 360;
	static int CUSTOM_HEIGHT = 640;

	GameScreen gameScreen;

	@Override
	public void create() {
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		gameScreen.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		gameScreen.resize(width, height);
	}

}
