/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

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
    
    public void setCameraView(float width, float height){
        cam.setToOrtho(false, width, height);
        cam.update();
    }
    
    public Matrix4 getCombinedCamera(){
        return cam.combined;
    }
    
    public float getCameraX(){
        return cam.position.x;
    }
    
    public float getCameraY(){
        return cam.position.y;
    }
    
    public float getViewWidth(){
        return cam.viewportWidth;
    }
    
    public float getViewHeight(){
        return cam.viewportHeight;
    }
    
}
