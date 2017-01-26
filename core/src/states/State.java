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
    //instance variables
    private OrthographicCamera cam;
    private StateManager stateManager;
    
    /**
     * constructor for state
     * @param sm statemanager to change state
     */
    public State(StateManager sm) {
        //pass in cam and state manager
        cam = new OrthographicCamera();
        stateManager = sm;
    }
    
    /**
     * method to draw
     * @param batch sprite batch to draw
     */
    public abstract void render(SpriteBatch batch);
    
    /**
     * method to update
     * @param deltaTime time between updates
     */
    public abstract void update(float deltaTime);
    
    /**
     * method to handle player input
     */
    public abstract void handleInput();

    /**
     * method to dispose of things
     */
    public abstract void dispose();

    /**
     * accessor for statemanger
     * @return statemanager
     */
    public StateManager getStateManager() {
        return stateManager;
    }
    /**
     * accessor for camera
     * @return orthocam
     */
    public OrthographicCamera getCamera() {
        return cam;
    }

    /**
     * method to set camera view
     * @param width camera width
     * @param height camera height
     */
    public void setCameraView(float width, float height) {
        cam.setToOrtho(false, width, height);
        cam.update();
    }
    
    /**
     * method to get combined camera
     * @return combined camera
     */
    public Matrix4 getCombinedCamera() {
        return cam.combined;
    }

    /**
     * accessor for camera x
     * @return camera x 
     */
    public float getCameraX() {
        return cam.position.x;
    }

    /**
     * accessor for camera y
     * @return camera y
     */
    public float getCameraY() {
        return cam.position.y;
    }

    /**
     * accessor for cam width
     * @return cam width
     */
    public float getViewWidth() {
        return cam.viewportWidth;
    }

    /**
     * accessor for cam height
     * @return cam height
     */
    public float getViewHeight() {
        return cam.viewportHeight;
    }

}
