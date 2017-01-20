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
    
    public Explosion(float x, float y){
        explosionX = x;
        explosionY = y;
     
        Texture explosion1 = new Texture("explosion1.png");
        Texture explosion2 = new Texture("explosion2.png");
        Texture explosion3 = new Texture("explosion3.png");
        Texture explosion4 = new Texture("explosion4.png");
        Texture explosion5 = new Texture("explosion5.png");
        Texture explosion6 = new Texture("explosion6.png");
        Texture explosion7 = new Texture("explosion7.png");
        Texture explosion8 = new Texture("explosion8.png");
        
        TextureRegion[] frames = {new TextureRegion(explosion1),new TextureRegion(explosion2), new TextureRegion(explosion3), new TextureRegion(explosion4),new TextureRegion(explosion5),new TextureRegion(explosion6),new TextureRegion(explosion7),new TextureRegion(explosion8)};
        explosion = new Animation(0.035f,frames);
        
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
