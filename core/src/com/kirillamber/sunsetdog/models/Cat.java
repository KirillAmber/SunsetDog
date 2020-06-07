package com.kirillamber.sunsetdog.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.kirillamber.sunsetdog.control.CatController;

import sun.awt.SunToolkit;

public class Cat extends GameObject {
    private CatController catController;
    private Vector2 currentVector;
    private Vector2 previousVector;
    private AnimationWalk animationWalk;
    private Sprite standing;
    private TextureAtlas atlasMoving;
//...

    public Cat(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, texture.getWidth(), texture.getHeight());
        catController = new CatController(getBounds(), getObject());
        currentVector = new Vector2(getBounds().getX(), getBounds().getY());
        previousVector = new Vector2(getBounds().getX()-2, getBounds().getY());
        atlasMoving = new TextureAtlas("walk.atlas");
        animationWalk = new AnimationWalk(atlasMoving);

    }

    public void updateCurrentVector(float x, float y){ // обновляет текущее и предыдущее значение вектора
            previousVector.set(currentVector);
            currentVector.set(getBounds().getX(), getBounds().getY());
    }

    public void update(float y){
        getBounds().setY(y);
        updateCurrentVector(getBounds().getX(), getBounds().getY());
    }

    @Override
    public void draw(SpriteBatch sb) {
        super.draw(sb);
    }

    public CatController getCatController() {
        return catController;
    }

    public Vector2 getPreviousVector() {
        return previousVector;
    }

    public Vector2 getCurrentVector() {
        return currentVector;
    }

    public AnimationWalk getAnimationWalk() {
        return animationWalk;
    }
}
