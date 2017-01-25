/*
 * To change this template, choose Tools | Templates
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
 * @author voigr4865
 */
public class OverState extends State {

    
    private Texture gameOver;
    public BitmapFont font;

    public OverState(StateManager sm) {
        super(sm);

        
        gameOver = new Texture("game-over.png");
        
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        
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

    }

    @Override
    public void render(SpriteBatch batch) {

        batch.setProjectionMatrix(getCombinedCamera());

        batch.begin();

        
        batch.draw(gameOver, 0, 0, getViewWidth(), getViewHeight());
        font.draw(batch, "press space to \nreturn to menu", 120, 200);
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {
        
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            //get the statemanager 
             StateManager gsm = getStateManager();
             
             gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void dispose() {
        gameOver.dispose();
    }
}
