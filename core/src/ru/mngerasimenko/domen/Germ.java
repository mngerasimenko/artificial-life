package ru.mngerasimenko.domen;


import java.awt.*;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Germ {
    private Texture texture;
    private final Vector2 position;
    //private Coordinate direction;
    private double size;
    private Color color;
    private int age;
    private double energy;
    private double speed;
    private Genome genome;


    public Germ(float x, float y) {
        texture = new Texture("2.png");
        position = new Vector2();
        position.set(x, y);
    }

    public void render(Batch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
    }
}
