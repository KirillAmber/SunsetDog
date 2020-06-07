package com.kirillamber.sunsetdog.state;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;
import com.kirillamber.sunsetdog.SunsetDog;

public class MenuState extends State {

    private Texture background;

    private SpriteBatch sb;
    //private ImageButton btn;
    //private TextureAtlas atlasForBtn;
    //private Skin skinForBtn;
   // private Stage stage;
    //TextureRegionDrawable drawableUp;
    //TextureRegionDrawable drawableDown;
    //TextureRegionDrawable drawableOver;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, SunsetDog.WIDTH, SunsetDog.HEIGHT);
      // TexturePacker.process("walk",
        //       "C:\\Users\\kerya\\Documents\\SunsetDog\\android\\assets", "walk");
       /*
        stage = new Stage();

        skinForBtn = new Skin();
        atlasForBtn = new TextureAtlas("playbtn.atlas");
        skinForBtn.addRegions(atlasForBtn);
        //skin.load(Gdx.files.internal("skin.json"));
        drawableUp = new TextureRegionDrawable(atlasForBtn.findRegion("playbtn") );
        drawableDown = new TextureRegionDrawable(atlasForBtn.findRegion("playbtndown"));
        drawableOver = new TextureRegionDrawable(atlasForBtn.findRegion("playbtnover"));
        btn = new ImageButton(drawableUp, drawableDown);
        btn.setX(camera.position.x+btn.getWidth()-30);
        btn.setY(camera.position.y+btn.getHeight()*4);
        btn.getStyle().imageOver = skinForBtn.getDrawable("playbtnover");
        btn.getStyle().imageUp = skinForBtn.getDrawable("playbtn");
        btn.getStyle().imageDown = skinForBtn.getDrawable("playbtndown");

        stage.addActor(btn);
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        Gdx.input.setInputProcessor(multiplexer);

        */
        background = new Texture(Gdx.files.internal("Sunset.png"));
    }

    @Override
    protected void handleInput() {
        /*
        if(btn.isPressed()){
            float delay = 0.1f; // seconds
            Timer.schedule(new Timer.Task(){
                @Override
                public void run() {
                    gsm.set(new PlayState(gsm));
                }
            }, delay);

         */
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {

        handleInput();
       // stage.act(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.end();
     //   stage.draw();


    }

    @Override
    public void dispose() {
        background.dispose();
    //    atlasForBtn.dispose();
      //  skinForBtn.dispose();
    }
}
