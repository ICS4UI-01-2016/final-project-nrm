/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author joudn2217
 */
public class Player {
    private int playerX;
    private int playerY;
    private Texture playerPic;
    private Rectangle bounds;
    
    public Player(int x, int y){
        playerX = x;
        playerY = y;
        playerPic = new Texture ("Galaga_Fighter.png");
        bounds = new Rectangle(playerX, playerY, playerPic.getWidth(),playerPic.getHeight());
    }
    
    public void moveLeft(){
        
    }
    
    public void moveRight(){
        
    }
    
    public int getX(){
        return playerX;
    }
    
    public int getY(){
        return playerY;
    }
    
}
