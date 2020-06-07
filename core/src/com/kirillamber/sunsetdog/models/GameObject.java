package com.kirillamber.sunsetdog.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {
    private Sprite object;
    private Rectangle bounds;
    public GameObject(Texture texture, float x, float y, float width, float height){
        bounds = new Rectangle(x, y, width, height);
        bounds.setCenter(width/2, height/2);
        bounds.setPosition(x, y);
        object = new Sprite(texture);
        object.setOrigin(width/2f, height/2f);
        object.setPosition(bounds.getX(), bounds.getY());

    }
    public void draw(SpriteBatch sb){
        object.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        object.draw(sb);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Sprite getObject() {
        return object;
    }
}
