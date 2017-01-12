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
public class GreenEnemy {
    
    private Texture green;
    private Rectangle bounds;
    private int enemyX;
    private int enemyY;
    
    public GreenEnemy(int x, int y){
        
        enemyX = x;
        enemyY = y;
        
        green = new Texture("Galaga_Enemy3.png");
        
        bounds = new Rectangle(enemyX, enemyY, green.getWidth(), green.getHeight());
        
    }
    
     public void render(SpriteBatch batch) {
        batch.draw(green, enemyX, enemyY);
        
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
