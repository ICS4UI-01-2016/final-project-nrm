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
 * @author voigr4865
 */
public class EnemyMissile {
     private float enemyMissileY;
    private float enemyMissileX;
    private Texture enemyMissileTexture;
    private Rectangle bounds;
    private boolean hasHit;
    
    private final float DOWNWARDS_VELOCITY = -150;
    
     public EnemyMissile(float x, float y){
        enemyMissileY = y;
        enemyMissileX = x;
        enemyMissileTexture = new Texture("missile.png");
        bounds = new Rectangle(enemyMissileX, enemyMissileY, enemyMissileTexture.getWidth(), enemyMissileTexture.getHeight());
        
    }
     
     public void update(float deltaTime){
        //add velocityX to playerX
        enemyMissileY += DOWNWARDS_VELOCITY*deltaTime;
        //update the bounds to playerX and playerY
        bounds.setPosition(enemyMissileX, enemyMissileY);
    }
    
    public void render(SpriteBatch batch){
        batch.draw(enemyMissileTexture, enemyMissileX, enemyMissileY);
    }
    
    public void dispose(){
        enemyMissileTexture.dispose();
    }
    
    public float getY(){
        return enemyMissileY;
    }
    
    public boolean collides(Player p){
        if(bounds.overlaps(p.getBounds())){
            return true;
        }
        
        return false;
    }
    
}
