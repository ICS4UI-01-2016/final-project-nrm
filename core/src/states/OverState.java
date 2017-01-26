/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author voigr4865
 */
public class OverState extends State {

    //instance varibles
    private BitmapFont font;
    private Texture gameOver;
    private int score;
    private Sound sound;
    
    /**
     * constructor for game over state
     * @param sm statemanager to change states
     * @param score score to use as final score
     */
    public OverState(StateManager sm, int score) {
        //pass in state manager, score and texture game over
        super(sm);
        this.score = score;
        gameOver = new Texture("game-over.png");
        //create the font generator
        FreeTypeFontGenerator fontGenerator = new //grab the font from the fonts avalible in assets 
        //get fron type from assets 
        FreeTypeFontGenerator(Gdx.files.internal("COOPBL.ttf"));
        //create the new font type 
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new //actually generate the font  
        //actually generate the font 
        FreeTypeFontGenerator.FreeTypeFontParameter();
        //chage the size of the font 
        fontParameter.size = 24;
        //acutlly sett he font into the "font" variable 
        font = fontGenerator.generateFont(fontParameter);
        //set the font color
        font.setColor(com.badlogic.gdx.graphics.Color.ORANGE);
        //set the camera view
        sound = Gdx.audio.newSound(Gdx.files.internal("gameover.mp3"));
        //play the sound
        sound.play();
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

    }

    @Override
    /**
     * method to draw game over screen
     */
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        //draw gameover
        batch.draw(gameOver, 0, 0, getViewWidth(), getViewHeight());
        //draw score
        font.draw(batch, " Game Score: " + score, getViewWidth() / 2 - 100, getViewHeight() - 100);
        //draw instructions
        font.draw(batch, "press space to return to menu", getViewWidth() / 2 - 200, getViewHeight() - 500);
        batch.end();
    }

    @Override
    /**
     * method to update overstate
     */
    public void update(float deltaTime) {
    }

    @Override
    /**
     * method to handle player input
     */
    public void handleInput() {
        //if space is pressed
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            //get the statemanager 
            StateManager gsm = getStateManager();
            //stop sound
            sound.stop();
            //set menu state
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    /**
     * method to dispose of things needing disposing
     */
    public void dispose() {
        gameOver.dispose();
    }
}
