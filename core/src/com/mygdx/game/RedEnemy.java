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
    
    private Texture red;
    
    private Rectangle bounds;
    
    private int enemyX;
    private int enemyY;
    
    public RedEnemy(int x, int y){
        
        enemyX = x;
        enemyY = y;
        
        red = new Texture("Galaga_Enemy2.png");
        
        
        bounds = new Rectangle(enemyX, enemyY, red.getWidth(), red.getHeight());
        
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(red, enemyX, enemyY);
       
    }
    
    public void update(float deltaTime){
        
        
    }
    
    public int getX(){
        return enemyX;
    }
    
    public int getY(){
        return enemyY;
    }
}
