package com.kirillamber.sunsetdog.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kirillamber.sunsetdog.SunsetDog;

import static com.kirillamber.sunsetdog.SunsetDog.HEIGHT;
import static com.kirillamber.sunsetdog.SunsetDog.TITLE;
import static com.kirillamber.sunsetdog.SunsetDog.WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = WIDTH;
		config.height = HEIGHT;
		config.title = TITLE;
		new LwjglApplication(new SunsetDog(), config);
	}
}
