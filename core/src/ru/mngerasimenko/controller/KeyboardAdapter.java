package ru.mngerasimenko.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

public class KeyboardAdapter extends InputAdapter {
    private final Vector2 mousePos = new Vector2();
    private final Vector2 mouseClick = new Vector2();

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mouseClick.set(screenX, Gdx.graphics.getHeight() - screenY);

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mousePos.set(screenX, Gdx.graphics.getHeight() - screenY);

        return false;
    }

    public Vector2 getMousePos() {
        return mousePos;
    }

    public Vector2 getMouseClick() {
        return mouseClick;
    }
}
