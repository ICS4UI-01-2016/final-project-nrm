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
    
    private Texture topRed;
    private Texture bottomRed;
    private Rectangle bounds1;
    private Rectangle bounds2;
    private int enemyX;
    private int enemyY;
    
    public RedEnemy(int x, int y){
        
        enemyX = x;
        enemyY = y;
        
        topRed = new Texture("Galaga_Enemy2.png");
        bottomRed = new Texture("Galaga_Enemy2.png");
        
        bounds1 = new Rectangle(enemyX, enemyY, topRed.getWidth(), topRed.getHeight());
        bounds2 = new Rectangle(enemyX, enemyY, bottomRed.getHeight(), bottomRed.getWidth());
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(topRed, enemyX, enemyY);
        batch.draw(bottomRed, enemyX, enemyY + 30);
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
