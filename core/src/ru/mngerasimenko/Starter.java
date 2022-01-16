package ru.mngerasimenko;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.mngerasimenko.domen.Germ;

public class Starter extends ApplicationAdapter {
	SpriteBatch batch;

	private Germ germ;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		germ = new Germ(200, 200);
	}

	@Override
	public void render () {
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
