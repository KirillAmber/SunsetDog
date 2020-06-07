package com.kirillamber.sunsetdog;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kirillamber.sunsetdog.state.GameStateManager;
import com.kirillamber.sunsetdog.state.MenuState;

public class SunsetDog extends ApplicationAdapter {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	public static final String TITLE = "Sunset Dog";
	private GameStateManager gsm;
	private SpriteBatch batch;
	OrthographicCamera camera;
	//private Music music;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		camera = new OrthographicCamera();
		/*
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		*/
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

	}

	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		//music.dispose();
	}
}
