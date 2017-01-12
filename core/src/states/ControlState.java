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

    private Texture bg;

    //the font
    public BitmapFont font;
    public BitmapFont SmallFont;

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
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        //draw the game "" on the menue screen 
        font.draw(batch, "Controlls", getViewWidth() - 425, getViewHeight() - 100);

        //tell user all controls for the game 
        SmallFont.draw(batch, "Use left and right arrow keys to move", getViewWidth() - 550, getViewHeight() - 300);
        SmallFont.draw(batch, "Space to Shoot", getViewWidth() - 400, getViewHeight() - 400);
        //tell user to start 
        font.draw(batch, "Click enter to start", getViewWidth() - 550, getViewHeight() - 550);
        

        batch.end();
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            //get the statemanager 
            StateManager gsm = getStateManager();
            //push on game screen
            gsm.push(new PlayState(gsm));
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
    }

}
