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
public class RedEnemy {

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

    public RedEnemy(float x, float y) {
        enemyX = x;
        enemyY = y;
        originalY = y;
        enemy = new Texture("Galaga_Enemy2.png");
        velocityX = 0;
        velocityY = 0;
        bounds = new Rectangle(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());
        moving = false;
        fired = false;
        enemyStop = false;
    }

    public void update(float deltaTime) {
        enemyX += velocityX * deltaTime;
        enemyY += velocityY * deltaTime;
        bounds.setPosition(enemyX, enemyY);
    }

    public void render(SpriteBatch batch) {
        batch.draw(enemy, enemyX, enemyY);
    }

    public void dispose(){
        enemy.dispose();
    }
    
    public void moveLeft() {
        velocityX = -90;
    }

    public void moveRight() {
        velocityX = 90;
    }

    public float getX() {
        return enemyX;
    }

    public float getY() {
        return enemyY;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void enemyAttack() {
        velocityY = -90;
    }

    public void enemyStopY() {
        velocityY = 0;
        moving = false;
    }

    public void setY(float y) {
        enemyY = y;
    }
    
    public float getOriginalY(){
        return originalY;
    }
    
    public void setMoving(){
        moving = !moving;
    }
    
    public boolean isEnemyMoving(){
        return moving;
    }
    
    public void fire(){
        fired = !fired;
    }
    
    public boolean hasEnemyFired(){
        return fired;
    }
    
    public void leaveScreen(){
        leftScreen = !leftScreen;
    }
    
    public boolean hasEnemyLeftScreen(){
        return leftScreen;
    }
    
    public void timeToStop(){
        enemyStop = true; 
    }
    
    public boolean stopEnemy(){
        return enemyStop;
    }

}
