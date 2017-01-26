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
    //instance variables
    private float playerX;
    private float playerY;
    private float velocityX;
    private Texture playerPic;
    private Rectangle bounds;
    private float lastMissileFired = 0;
    private float lives;
    
    /**
     * constructor of player
     * @param x position of player
     * @param y position of player
     * @param width width of player
     * @param height height of player
     */
    public Player(int x, int y, int width, int height){
        //pass in lives, x, y velocity of x, player pic and bounds
        lives = 3;
        playerX = x;
        playerY = y;
        velocityX = 0;
        playerPic = new Texture ("Galaga_Fighter.png");
        bounds = new Rectangle(playerX, playerY, width, height);
    }
    
    /**
     * set velocity to move left
     */
    public void moveLeft(){
        velocityX = -90;
    }
    
    /**
     * set velocity to move right
     */
    public void moveRight(){
        velocityX = 90;
    }
    
    /**
     * set velocity to stop enemy
     */
    public void zeroVelocity(){
        velocityX = 0;
    }
    
    /**
     * accessor for play x
     * @return player x
     */
    public float getX(){
        return playerX;
    }
    
    /**
     * accessor for player y
     * @return player y
     */
    public float getY(){
        return playerY;
    }
    
    /**
     * accessor for player bounds
     * @return player bounds
     */
    public Rectangle getBounds(){
        return bounds;
    }
    
    /**
     * update player x, bonds and missile timer
     * @param deltaTime time passed between updates
     */
    public void update(float deltaTime){
        //add velocityX to playerX
        playerX += velocityX*deltaTime;
        //update the bounds to playerX and playerY
        bounds.setPosition(playerX, playerY);
        if(lastMissileFired > 0){
            lastMissileFired = lastMissileFired - deltaTime;
        }
    }
    
    /**
     * draw player
     * @param batch sprite batch used to draw player
     */
    public void render(SpriteBatch batch){
        batch.draw(playerPic, playerX, playerY);
    }
    
    /**
     * dispose of player pic
     */
    public void dispose(){
        playerPic.dispose();
    }
    
    /**
     * method to determine whether or not 350 ms has passed between player shooting
     * @param time current time
     * @return whether or not 350 ms has passed
     */
    public boolean fire(float time){
        if(lastMissileFired <= 0){
            lastMissileFired = 0.35f;
            return true;
        } else {
            return false;
        }
        
    }
    
    /**
     * subtract one life
     */
    public void playerHit(){
        lives -= 1;
    }
    
    /**
     * accessor for player lives
     * @return player lives
     */
    public float getLives(){
        return lives;
    }
}
