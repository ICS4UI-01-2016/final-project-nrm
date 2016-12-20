/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author joudn2217
 */
public abstract class State {
    private OrthographicCamera cam;
    private StateManager stateManager;
    
    public State(StateManager sm){
        cam = new OrthographicCamera();
        stateManager = sm;
    }
    
    public abstract void render(SpriteBatch batch);
    public abstract void update(float deltaTime);
    public abstract void handleInput();
    public abstract void dispose();
    
    public StateManager getStateManager(){
        return stateManager;
    }
    
    public OrthographicCamera getCamera(){
        return cam;
    }
    
}
