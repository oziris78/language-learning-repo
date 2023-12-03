package com.twistral.physicssim;

import com.badlogic.gdx.Game;
import com.twistral.physicssim.screens.PhysicsSimGameScreen;


public class PhysicsSimMain extends Game {


	@Override
	public void create() {
		setScreen(new PhysicsSimGameScreen(this));
	}

}
