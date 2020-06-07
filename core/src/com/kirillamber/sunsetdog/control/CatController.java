package com.kirillamber.sunsetdog.control;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.kirillamber.sunsetdog.models.AnimationWalk;

public class CatController {
    private Rectangle dogBounds;

    public boolean isRight;
    public CatController(Rectangle dogBounds, Sprite sprite){
        this.dogBounds = dogBounds;
        isRight = true;
    }
    public void handle(){
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            dogBounds.x = (int) (dogBounds.x + 3f);

        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            dogBounds.x = (int) (dogBounds.x - 3f);
        }
    }
}
