/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author joudn2217
 */
public class Missile {
    //instance variables
    private float missileY;
    private float missileX;
    private Texture missileTexture;
    private Rectangle bounds;
    private final float UPWARDS_VELOCITY = 150;
    
    /**
     * constructor method for missiles
     *
     * @param x the x of the missile
     * @param y the y of the missile
     */
    public Missile(float x, float y){
        //pass in enemy missile x and y
        missileY = y;
        missileX = x;
        //pass in texture
        missileTexture = new Texture("missile.png");
        //pass/set in bounds
        bounds = new Rectangle(missileX, missileY, missileTexture.getWidth(), missileTexture.getHeight());
    }
    
    /**
     * updates missiles x and y using velocity
     *
     * @param deltaTime times passed between updates
     */
    public void update(float deltaTime){
        //add velocityX to playerX
        missileY += UPWARDS_VELOCITY*deltaTime;
        //update the bounds to playerX and playerY
        bounds.setPosition(missileX, missileY);
    }
    
    /**
     * draw in the missile
     *
     * @param batch a spritebatch to draw
     */
    public void render(SpriteBatch batch){
        batch.draw(missileTexture, missileX, missileY);
    }
    
    /**
     * disposes of missile texture
     */
    public void dispose(){
        missileTexture.dispose();
    }
    
    /**
     * accessor method to get y
     *
     * @return y position of missile
     */
    public float getY(){
        return missileY;
    }
    
    /**
     * return whether a missile has collided with a enemy
     *
     * @param e enemy passed in
     * @return whether or not a collision has occured
     */
    public boolean collides(Enemy e){
        if(bounds.overlaps(e.getBounds())){
            return true;
        }
        
        return false;
    }
    
    /**
     * return whether a missile has collided with a red enemy
     *
     * @param r red enemy passed in
     * @return whether or not a collision has occured
     */
    public boolean rCollides(RedEnemy r){
        if(bounds.overlaps(r.getBounds())){
            return true;
        }
        
        return false;
    }
}
