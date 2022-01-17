package ru.mngerasimenko.domen;


import java.awt.*;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Germ {

    private final Texture texture;
    private final TextureRegion textureRegion;
    private final Vector2 position;
    private final Vector2 direction;
    private final float size = 50;
    private final float halfSize = size / 2;
    private Color color;
    private int age;
    private double energy;
    private float speed;
    private Genome genome;

    private final String IMG = "germ50.png";


    public Germ(float x, float y) {
        texture = new Texture(IMG);
        textureRegion = new TextureRegion(texture);
        position = new Vector2(x, y);
        direction = new Vector2(300, 300);
    }

    public void render(Batch batch) {
        move();
        batch.draw(
                textureRegion,
                position.x,
                position.y,
                halfSize,
                halfSize,
                size,
                size,
                1,
                1,
                direction.angleDeg()
                );
    }

    private void move() {
        float dirX = (float) Math.cos(direction.angleDeg());
        float dirY = (float) Math.sin(direction.angleDeg());

        position.add(dirX * 1.5f , dirY * 1.5f);


    }

    public void dispose() {
        texture.dispose();
    }

    public void rotateTo(Vector2 dir) {
        direction.set(dir).sub(position.x + halfSize, position.y + halfSize);
    }
}
