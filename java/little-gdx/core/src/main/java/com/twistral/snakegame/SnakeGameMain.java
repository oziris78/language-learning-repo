package com.twistral.snakegame;

import com.badlogic.gdx.Game;

public class SnakeGameMain extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}
