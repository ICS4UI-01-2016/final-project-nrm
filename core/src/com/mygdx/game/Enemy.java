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
    
    private Texture enemy;
    private boolean hasEnemyBeenHit;
    private Rectangle bounds;
    private int enemyX;
    private int enemyY;
    private float velocityX;
    private float velocityY;
    
    public Enemy(int x, int y){
        enemyX = x;
        enemyY = y;
        enemy = new Texture("Galaga_Enemy1.png");

        hasEnemyBeenHit = false;

        velocityX = 0;
        velocityY = 0;
       

        bounds = new Rectangle(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());
    }
    

         
    public void moveLeft(){
        velocityX = -45;
    }
    
    public void moveRight(){
        velocityX = 90;
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(enemy, enemyX, enemyY);
    }
    
    public void update(float deltaTime){

        
        
        
        enemyX += velocityX*deltaTime;
        enemyY += velocityY*deltaTime;
        

        bounds.setPosition(enemyX, enemyY);
        
    }
    
    public int getX(){
        return enemyX;
    }
    
    public int getY(){
        return enemyY;
    }
    
    public Rectangle getBounds(){
        return bounds;
    }
    
    public void enemyHit(){
        hasEnemyBeenHit = true;
    }
    
    public boolean hasEnemyBeenHit(){
        return hasEnemyBeenHit;
    }
    
    public void enemyAttack(){
        enemyY = -90;
    }
    
    
    
}
