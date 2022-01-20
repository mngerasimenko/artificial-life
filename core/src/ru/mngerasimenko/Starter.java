package ru.mngerasimenko;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.mngerasimenko.controller.KeyboardAdapter;
import ru.mngerasimenko.domen.Germ;

public class Starter extends ApplicationAdapter {
	SpriteBatch batch;

	private KeyboardAdapter inputProcessor = new KeyboardAdapter();
	private Germ germ;
	private BitmapFont font;

	
	@Override
	public void create () {
		Gdx.input.setInputProcessor(inputProcessor);
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);

		germ = new Germ(200, 200);
	}

	@Override
	public void render () {

		germ.moveTo(inputProcessor.getMouseClick());

		ScreenUtils.clear(0.8f, 0.8f, 0.8f, 1);
		batch.begin();

		font.draw(batch, germ.getFixX(), 100, 250);
		font.draw(batch, germ.getFixY(), 100, 200);
		germ.render(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		germ.dispose();
		font.dispose();
	}
}
