package ru.mngerasimenko;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.mngerasimenko.controller.KeyboardAdapter;
import ru.mngerasimenko.domen.Germ;

public class Starter extends ApplicationAdapter {
	SpriteBatch batch;

	private KeyboardAdapter inputProcessor = new KeyboardAdapter();
	private Germ germ;
	
	@Override
	public void create () {
		Gdx.input.setInputProcessor(inputProcessor);
		batch = new SpriteBatch();
		germ = new Germ(200, 200);
	}

	@Override
	public void render () {
		germ.rotateTo(inputProcessor.getMousePos());

		ScreenUtils.clear(0.8f, 0.8f, 0.8f, 1);
		batch.begin();
		germ.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		germ.dispose();
	}
}
