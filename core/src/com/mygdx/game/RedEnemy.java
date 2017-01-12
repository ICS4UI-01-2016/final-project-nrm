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
    
    private Texture topEnemy;
    private Texture bottomEnemy;
    private Rectangle bounds1;
    private Rectangle bounds2;
    private int enemyX;
    private int enemyY;
    
    public RedEnemy(int x, int y){
        
        enemyX = x;
        enemyY = y;
        
        topEnemy = new Texture("Galaga_Enemy2.png");
        bottomEnemy = new Texture("Galaga_Enemy2.png");
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(topEnemy, enemyX, enemyY);
        batch.draw(bottomEnemy, enemyX, enemyY + 30);
    }
}
