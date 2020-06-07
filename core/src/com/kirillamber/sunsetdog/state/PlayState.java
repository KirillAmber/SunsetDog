package com.kirillamber.sunsetdog.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.kirillamber.sunsetdog.SunsetDog;
import com.kirillamber.sunsetdog.models.Cat;
import com.kirillamber.sunsetdog.models.Train;


public class PlayState extends State {

    private Texture bg;
    private Texture trainTexture;
    private Texture mainCatTexture;
    private Cat mainCat;
    private Train train;
    private Vector2 opposite;
    private Skin skinForBack;
    private TextureAtlas atlasForBack;

    private Sprite clouds;
    private Sprite grass;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, SunsetDog.WIDTH, SunsetDog.HEIGHT);

        bg = new Texture(Gdx.files.internal("background_sunset.png"));
        trainTexture = new Texture(Gdx.files.internal("train.png"));
        mainCatTexture = new Texture(Gdx.files.internal("walk\\walk_1.png"));

        skinForBack = new Skin();
        atlasForBack = new TextureAtlas("backgrounds_items.atlas");
        skinForBack.addRegions(atlasForBack);
        clouds = atlasForBack.createSprite("clouds");
        clouds.setPosition(camera.position.x-300, camera.position.y+80);
        grass = atlasForBack.createSprite("grass");

        train = new Train(trainTexture, camera.position.x - camera.viewportWidth/2, 0, trainTexture.getWidth(),trainTexture.getHeight());
        mainCat = new Cat(mainCatTexture, 20f, train.getBounds().getY()+10, mainCatTexture.getWidth(), mainCatTexture.getHeight());
        opposite = new Vector2(1, mainCat.getBounds().getY());
    }

    @Override
    protected void handleInput() {
        if(((mainCat.getCurrentVector().x - mainCat.getPreviousVector().x < 0) || !mainCat.getCatController().isRight)&&
        !mainCat.getObject().isFlipX()) {
            mainCat.getObject().flip(true, false);
            for(int i = 0; i<mainCat.getAnimationWalk().getWalkingAnimation().getKeyFrames().length; i++){
                mainCat.getAnimationWalk().getWalkingAnimation().getKeyFrames()[i].flip(true, false);
            }

            mainCat.getCatController().isRight = false;
        }
        else if((mainCat.getCurrentVector().x - mainCat.getPreviousVector().x > 0 || mainCat.getCatController().isRight)&&
                mainCat.getObject().isFlipX()){
            mainCat.getObject().flip(true, false);
            for(int i = 0; i<mainCat.getAnimationWalk().getWalkingAnimation().getKeyFrames().length; i++){
                mainCat.getAnimationWalk().getWalkingAnimation().getKeyFrames()[i].flip(true, false);
            }
            mainCat.getCatController().handle();
            mainCat.getCatController().isRight = true;
        }
        mainCat.getCatController().handle();
    }

    @Override
    public void update(float dt) {
        mainCat.update(train.getBounds().getY()+10);
        handleInput();
        camera.update();
        clouds.setX(clouds.getX()-10f*dt);
        if(clouds.getX() <= -817){
            clouds.setX(SunsetDog.WIDTH);
        }
        train.handle(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(bg, camera.position.x - camera.viewportWidth/2, 0);
        sb.draw(clouds, clouds.getX(), clouds.getY());
        train.draw(sb);
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            mainCat.getAnimationWalk().play();
            sb.draw(mainCat.getAnimationWalk().getCurrentFrame(), mainCat.getBounds().getX(), mainCat.getBounds().getY(),
                    mainCat.getBounds().getWidth(), mainCat.getBounds().getHeight());
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            mainCat.getAnimationWalk().play();
            sb.draw(mainCat.getAnimationWalk().getCurrentFrame(), mainCat.getBounds().getX(), mainCat.getBounds().getY(),
                    mainCat.getBounds().getWidth(), mainCat.getBounds().getHeight());
        }
        else mainCat.draw(sb);

        sb.end();
    }

    @Override
    public void dispose() {
        mainCatTexture.dispose();
        trainTexture.dispose();
        bg.dispose();
    }

}
