package ru.mngerasimenko.domen;



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
//    private Color color;
//    private int age;
//    private double energy;
    private float speed = 1.0f;
    private float fixX;
    private float fixY;
//    private Genome genome;

    private final String IMG = "germ50.png";


    public Germ(float x, float y) {
        texture = new Texture(IMG);
        textureRegion = new TextureRegion(texture);
        position = new Vector2(x, y);
        direction = new Vector2(200, 200);
    }

    public void render(Batch batch) {
        movedx();
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

    private void movedx() {
        rotateTo(direction);

        float delta = Math.abs(direction.x) + Math.abs(direction.y);

        fixX = Math.abs(direction.x);
        if (fixX < 5) {
            fixX = 5f;
        }
        fixY = Math.abs(direction.y);
        if (fixY < 5) {
            fixY = 5f;
        }

        float dx = (float) (speed * Math.atan(fixY) * direction.x / delta);
        float dy = (float) (speed * Math.atan(fixX) * direction.y / delta);

        position.add(dx, dy);
    }

    public String getFixX() {
        return Float.toString((float) (Math.atan(fixX) * speed));
    }

    public String getFixY() {
        return Float.toString((float) (Math.atan(fixY) * speed));
    }

    public void dispose() {
        texture.dispose();
    }

    public void rotateTo(Vector2 dir) {
        direction.set(dir).sub(position.x + halfSize, position.y + halfSize);
    }

    public void moveTo(Vector2 dir) {
        direction.set(dir).sub(position.x + halfSize, position.y + halfSize);
    }
}
