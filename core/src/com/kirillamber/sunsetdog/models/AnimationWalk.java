package com.kirillamber.sunsetdog.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationWalk {
    private Animation<TextureRegion> walkingAnimation;
    private float stateTime;
    private TextureRegion currentFrame;
    public AnimationWalk(TextureAtlas atlas){
        walkingAnimation = new Animation<TextureRegion>(0.2f, atlas.findRegions("walk"),
                Animation.PlayMode.NORMAL);
        stateTime = 0f;
    }
    public void play(){
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = walkingAnimation.getKeyFrame(stateTime, true);
    }

    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public Animation<TextureRegion> getWalkingAnimation() {
        return walkingAnimation;
    }
}
