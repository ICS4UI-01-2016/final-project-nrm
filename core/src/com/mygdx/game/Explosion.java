package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joudn2217
 */
public class Explosion {
    private Animation explosion;
    private float explosionX;
    private float explosionY;
    private float time = 0;
    
    public Explosion(int x, int y){
        explosionX = x;
        explosionY = y;
     
        Texture explosion1 = new Texture("explosion1.png");
        Texture explosion2 = new Texture("explosion2.png");
        Texture explosion3 = new Texture("explosion3.png");
        TextureRegion[] frames = {new TextureRegion(explosion1),new TextureRegion(explosion2), new TextureRegion(explosion3)};
        explosion = new Animation(0.5f,frames);
        
    }
    
    public void update(float deltaTime){
        time += deltaTime;
    }
    
    public void render(SpriteBatch batch){
        batch.draw(explosion.getKeyFrame(time), explosionX, explosionY);
    }
    
    public void dispose(){
        for(TextureRegion tr: explosion.getKeyFrames()){
            tr.getTexture().dispose();
        }
    }
    
    public boolean isFinished(){
        return explosion.isAnimationFinished(time);
    }
}
