/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author munta
 */
public class ControlState extends State {
    //instance variables
    private Texture bg;
    public BitmapFont font;
    public BitmapFont SmallFont;
    
    //constructor for controlstate
    public ControlState(StateManager sm) {
        super(sm);
        //add the backround texture image
        bg = new Texture("Galaga_Background.png");
        //create the font generator(first font)
        FreeTypeFontGenerator fontGenerator = new //grab the font from the fonts avalible in assets 
        FreeTypeFontGenerator(Gdx.files.internal("COOPBL.ttf"));
        //create the new font type 
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new //FreeTypeFontGenerator.FreeTypeFontParameter fontParamter2=new        
        //actually generate the font         
        FreeTypeFontGenerator.FreeTypeFontParameter();
        //chaze the size of th font 
        fontParameter.size = 52;
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
        fontParameter2.size = 26;
        SmallFont = fontGenerator.generateFont(fontParameter2);
        //set camera view
        SmallFont.setColor(com.badlogic.gdx.graphics.Color.GREEN);
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
    }

    @Override
    /**
     * method to draw control state
     */
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        //draw the game "" on the menue screen 
        font.draw(batch, "Controls", getViewWidth() - 425, getViewHeight() - 100);
        //tell user all controls for the game 
        SmallFont.draw(batch, "Use left and right arrow keys to move", getViewWidth() - 550, getViewHeight() - 300);
        //draw shooting instructions
        SmallFont.draw(batch, "Space to Shoot", getViewWidth() - 400, getViewHeight() - 400);
        //tell user to start 
        SmallFont.draw(batch, "Press space to main menu", 125, getViewHeight() - 550);
        batch.end();
    }

    @Override
    /**
     * method to update
     */
    public void update(float deltaTime) {
    }

    @Override
    /**
     * method to handle player input
     */
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            //get the statemanager 
            StateManager gsm = getStateManager();
            //push on game screen
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    /**
     * method to dispose of things
     */
    public void dispose() {
        bg.dispose();
    }

}
