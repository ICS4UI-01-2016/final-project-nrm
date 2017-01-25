/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.MyGdxGame;
import java.awt.Color;

/**
 *
 * @author munta
 */
public class MenuState extends State {

    //the backround
    private Texture bg;
    //varible used to keep users highscore
    private int highScore;
    //the font
    public BitmapFont font;
    public BitmapFont SmallFont;
    private Texture galaga;

    public MenuState(StateManager sm) {
        super(sm);
        //add the backround texture image
        bg = new Texture("Galaga_Background.png");
        galaga = new Texture("galaga.png");
        //create the font generator
        FreeTypeFontGenerator fontGenerator = new //grab the font from the fonts avalible in assets 
                FreeTypeFontGenerator(Gdx.files.internal("COOPBL.ttf"));
        //create the new font type 
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new //actually generate the font         
                FreeTypeFontGenerator.FreeTypeFontParameter();
        //chaze the size of th font 
        fontParameter.size = 44;

        font = fontGenerator.generateFont(fontParameter);

        //set camera view
        font.setColor(com.badlogic.gdx.graphics.Color.GREEN);

        //THE SECOND FONT 
        FreeTypeFontGenerator fontGenerator2 = new //grab the font from the fonts avalible in assets 
                FreeTypeFontGenerator(Gdx.files.internal("COOPBL.ttf"));
        //create the new font type 
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter2 = new //FreeTypeFontGenerator.FreeTypeFontParameter fontParamter2=new        
                //actually generate the font         
                FreeTypeFontGenerator.FreeTypeFontParameter();
        //chaze the size of th font 
        fontParameter.size = 28;

        SmallFont = fontGenerator.generateFont(fontParameter2);
        //set camera view
        SmallFont.setColor(com.badlogic.gdx.graphics.Color.GREEN);

        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

        Preferences pref = Gdx.app.getPreferences("hightScore");
        //finf int hihgscore if not set value to 0
        highScore = pref.getInteger("highScore", 0);

    }

    @Override
    public void render(SpriteBatch batch) {

        batch.setProjectionMatrix(getCombinedCamera());

        batch.begin();

        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        font.draw(batch, "" + highScore, getViewWidth() / 2, getViewHeight() - 100);
        //draw the game "name" on the menue screen 
        //font.draw(batch, "GALAGA", getViewWidth() - 400, getViewHeight() - 350);
        batch.draw(galaga, 150, 300, getViewWidth() - 300, getViewHeight() - 450);

        font.draw(batch, "Press I for instructions", getViewWidth() - 575, getViewHeight() - 400);
        //tell user to "press enter to start the game.
        font.draw(batch, "Press space to play!", getViewWidth() - 575, getViewHeight() - 500);

        batch.end();
    }

    public void updateScore() {
        Preferences pref = Gdx.app.getPreferences("hightScore");
        highScore = pref.getInteger("highScore", 0);
        System.out.println(highScore);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
            //get the statemanager 
            StateManager gsm = getStateManager();
            //push on game screen
            gsm.push(new ControlState(gsm));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            //get the statemanager 
            StateManager gsm = getStateManager();
            //push on game screen
            gsm.push(new PlayState(gsm));
        }

    }

    /**
     *
     */
    @Override
    public void dispose() {
        bg.dispose();

    }

    private void setCameraPosition(float f, float f0) {

    }

}
