package com.kirillamber.sunsetdog.models;

import com.badlogic.gdx.graphics.Texture;

public class Train extends GameObject {

    private boolean isUp;
    public Train(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        isUp = false;
    }
    public void handle(float dt){
        if(getBounds().getY() < 0 && !isUp)
        getBounds().setY(getBounds().getY()+10f*dt);
        else if (getBounds().getY() >= 0)
            isUp = true;
        if(getBounds().getY() >= -5 && isUp)
            getBounds().setY(getBounds().getY()-10f*dt);
        else if (getBounds().getY() < -5)
            isUp = false;
    }

}
