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
public class Player {
    private float playerX;
    private float playerY;
    private float velocityX;
    private Texture playerPic;
    private Rectangle bounds;
    private float lastMissileFired = 0;
    
    public Player(int x, int y, int width, int height){
        playerX = x;
        playerY = y;
        velocityX = 0;
        playerPic = new Texture ("Galaga_Fighter.png");
        bounds = new Rectangle(playerX, playerY, width, height);
    }
    
    public void moveLeft(){
        velocityX = -90;
    }
    
    public void moveRight(){
        velocityX = 90;
    }
    
    public void zeroVelocity(){
        velocityX = 0;
    }
    
    public float getX(){
        return playerX;
    }
    
    public float getY(){
        return playerY;
    }
    
    public Rectangle getBounds(){
        return bounds;
    }
    
    public void update(float deltaTime){
        //add velocityX to playerX
        playerX += velocityX*deltaTime;
        //update the bounds to playerX and playerY
        bounds.setPosition(playerX, playerY);
        if(lastMissileFired > 0){
            lastMissileFired = lastMissileFired - deltaTime;
        }
    }
    
    public void render(SpriteBatch batch){
        batch.draw(playerPic, playerX, playerY);
    }
    
    public void dispose(){
        playerPic.dispose();
    }
    
    
    
    
    public boolean fire(float time){
        
        if(lastMissileFired <= 0){
            lastMissileFired = 0.35f;
            return true;
        } else {
            System.out.println("false");
            return false;
        }
        
    }
    
    
    
}
