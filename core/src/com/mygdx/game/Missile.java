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
    private float missileY;
    private float missileX;
    private Texture missileTexture;
    private Rectangle bounds;
    private boolean hasHit;
    private boolean leftScreen;
    
    private final float UPWARDS_VELOCITY = 90;
    
    
    public Missile(float x, float y){
        missileY = y;
        missileX = x;
        missileTexture = new Texture("missile.png");
        bounds = new Rectangle(missileX, missileY, missileTexture.getWidth(), missileTexture.getHeight());
        
    }
    
    public void update(float deltaTime){
        //add velocityX to playerX
        missileY += UPWARDS_VELOCITY*deltaTime;
        //update the bounds to playerX and playerY
        bounds.setPosition(missileX, missileY);
    }
    
    public void render(SpriteBatch batch){
        batch.draw(missileTexture, missileX, missileY);
    }
    
    public void dispose(){
        missileTexture.dispose();
    }
    
    
}
