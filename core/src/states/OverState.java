/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author voigr4865
 */
public class OverState extends State {

    private Texture bg;

    public OverState(StateManager sm) {
        super(sm);

        bg = new Texture("Galaga_Background.png");

    }

    @Override
    public void render(SpriteBatch batch) {

        batch.setProjectionMatrix(getCombinedCamera());

        batch.begin();

        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        
        

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
        bg.dispose();
    }
}
