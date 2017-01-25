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
public class Enemy {
    //instance variables
    private Texture enemy;
    private Rectangle bounds;
    private float enemyX;
    private float enemyY;
    private float velocityX;
    private float velocityY;
    private float originalY;
    private boolean moving;
    private boolean fired;
    private boolean leftScreen;
    private boolean enemyStop;
    
    /**
     * constructor method for enemy
     *
     * @param x enemy x position
     * @param y enemy y position
     */
    public Enemy(float x, float y) {
        //pass in x and y
        enemyX = x;
        enemyY = y;
        //set original y
        originalY = y;
        //set texture
        enemy = new Texture("Galaga_Enemy1.png");
        //set x and y velocity to 0
        velocityX = 0;
        velocityY = 0;
        //sets enemy bounds
        bounds = new Rectangle(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());
        //moving, fired and enemyStop are all false
        moving = false;
        fired = false;
        enemyStop = false;
    }
    
    /**
     * update method
     * @param deltaTime amount of time passed between updates
     */
    public void update(float deltaTime) {
        //update enemy x and y using the velocities
        enemyX += velocityX * deltaTime;
        enemyY += velocityY * deltaTime;
        //update enemy bounds
        bounds.setPosition(enemyX, enemyY);
    }
    
    /**
     * method to draw enemy
     * @param batch spritebatch used to draw enemy
     */
    public void render(SpriteBatch batch) {
        batch.draw(enemy, enemyX, enemyY);
    }
    
    /**
     * method to dispose of enemy texture
     */
    public void dispose(){
        enemy.dispose();
    }
    
    /**
     * move left by making velocity negative
     */
    public void moveLeft() {
        velocityX = -90;
    }
    
    /**
     * move right by making velocity positive
     */
    public void moveRight() {
        velocityX = 90;
    }
    
    /**
     * accessor method to get enemy x
     * @return enemy x position
     */
    public float getX() {
        return enemyX;
    }
    
    /**
     * accessor method to get y
     * @return enemy y position
     */
    public float getY() {
        return enemyY;
    }
    
    /**
     * accessor method to get enemy bounds
     * @return enemy bounds
     */
    public Rectangle getBounds() {
        return bounds;
    }
    
    /**
     * make enemy go forwards
     */
    public void enemyAttack() {
        velocityY = -90;
    }
    
    /**
     * stop enemy and set moving to false
     */
    public void enemyStopY() {
        velocityY = 0;
        moving = false;
    }
    
    /**
     * change enemy y
     * @param y new y value
     */
    public void setY(float y) {
        enemyY = y;
    }
    
    /**
     * accessor method for original y
     * @return original y
     */
    public float getOriginalY(){
        return originalY;
    }
    
    /**
     * change whether enemy is moving or not
     */
    public void setMoving(){
        moving = !moving;
    }
    //
    /**
     * accessor method for whether or not enemy is moving
     * @return whether or not enemy is moving
     */
    public boolean isEnemyMoving(){
        return moving;
    }
    
    /**
     * change whether enemy has fired or not
     */
    public void fire(){
        fired = !fired;
    }
    //
    /**
     * accessor method for whether or not enemy has fired or not
     * @return whether enemy has fired or not
     */
    public boolean hasEnemyFired(){
        return fired;
    }
    
    /**
     * change whether enemy has left screen
     */
    public void leaveScreen(){
        leftScreen = !leftScreen;
    }
    
    /**
     * accessor method for if enemy has left screen or not
     * @return if enemy has left screen or not
     */
    public boolean hasEnemyLeftScreen(){
        return leftScreen;
    }
    
    /**
     * change whether is is time to stop or not
     */
    public void timeToStop(){
        enemyStop = !enemyStop; 
    }
    
    /**
     * accessor method for whether enemy is stopped or not
     * @return whether or not enemy is stopped
     */
    public boolean stopEnemy(){
        return enemyStop;
    }
    
    /**
     * has enemy collided with player?
     * @param p player passed in
     * @return whether or not enemy and player collided
     */
    public boolean collides(Player p){
        //if bounds of enemy and player overlap
        if(bounds.overlaps(p.getBounds())){
            return true;
        }
        return false;
    }

}
