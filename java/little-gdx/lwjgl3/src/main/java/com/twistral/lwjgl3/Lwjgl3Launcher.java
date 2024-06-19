package com.twistral.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.twistral.conwaysgameoflife.MyTESTmain;
import com.twistral.physicssim.PhysicsSimMain;


public class Lwjgl3Launcher {

	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setTitle("LittleGDX");
		final boolean UNLIMITED_FPS = false;

		if(!UNLIMITED_FPS) {
			configuration.useVsync(true);
			configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate);
		}
		else {
			// can be useful for testing performance, but can also be very stressful to some hardware.
			// You may also need to configure GPU drivers to fully disable Vsync; this can cause screen tearing.
			configuration.useVsync(UNLIMITED_FPS);
		}

		configuration.setWindowedMode(640, 480);
		configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
		new Lwjgl3Application(new MyTESTmain(), configuration);
	}

}