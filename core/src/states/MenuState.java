/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
    //instance variables
    private Texture bg;
    private int highScore;
    public BitmapFont font;
    public BitmapFont SmallFont;
    private Texture galaga;
    private Music sound;
    
    /**
     * constructor for menustate
     * @param sm statemanger to change states
     */
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
        //store font is "font"
        font = fontGenerator.generateFont(fontParameter);
        //set color of font 
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
        //store second font in "Smallfont" (bitmap font)
        SmallFont = fontGenerator.generateFont(fontParameter2);
        //set camera view
        SmallFont.setColor(com.badlogic.gdx.graphics.Color.GREEN);
        //set the camera view of the game
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

        Preferences pref = Gdx.app.getPreferences("hightScore");
        //find int hihgscore if not set value to 0
        highScore = pref.getInteger("highScore", 0);
        //load in a new sound
        Music sound = Gdx.audio.newMusic(Gdx.files.internal("menu.mp3"));
        //play the sound on the menu screen
        sound.play();

    }

    @Override
    /**
     * method used to draw all components to the menu screen
     */
    public void render(SpriteBatch batch) {
        //set the camera
        batch.setProjectionMatrix(getCombinedCamera());
        //being the batch
        batch.begin();
        //draw the backround 
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        //draw the highscore on the screen 
        font.draw(batch, "High Score " + highScore, getViewWidth() / 2 - 150, getViewHeight() - 100);
        //draw the "game over" picture to the screen 
        batch.draw(galaga, 150, 300, getViewWidth() - 300, getViewHeight() - 450);
        //let the user know to press i for instuctions
        font.draw(batch, "Press I for instructions", getViewWidth() - 550, getViewHeight() - 400);
        //tell user to "press enter to start the game.
        font.draw(batch, "Press space to play!", getViewWidth() - 525, getViewHeight() - 500);
        //end the batch
        batch.end();
    }

    /**
     * updates score
     */
    public void updateScore() {
        Preferences pref = Gdx.app.getPreferences("hightScore");
        highScore = pref.getInteger("highScore", 0);
    }

    @Override
    /**
     * update menu state
     */
    public void update(float deltaTime) {
    }

    @Override
    /**
     * handle input from player
     */
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
     * disposes of all components needed to be disposed
     */
    @Override
    public void dispose() {
        bg.dispose();
        sound.dispose();

    }

}
