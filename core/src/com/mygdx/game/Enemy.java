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
    
    
    private Rectangle bounds;
    private int enemyX;
    private int enemyY;
    
    public Enemy(int x, int y){
        
        enemyX = x;
        enemyY = y;
        enemy = new Texture("Galaga_Enemy1.png");
        
        
       
        bounds = new Rectangle(enemyX, enemyY, enemy.getWidth(), enemy.getHeight());
    }
    
    public void render(SpriteBatch batch) {
//        
        batch.draw(enemy, enemyX, enemyY);
    }
    
    public void update(float deltaTime){
        
        
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
    
    
    
}
