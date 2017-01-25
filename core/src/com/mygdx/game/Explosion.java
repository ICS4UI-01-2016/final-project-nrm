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

    //instance variables

    private Animation explosion;
    private float explosionX;
    private float explosionY;
    private float time = 0;

    /**
     * constructor method for an explosion
     *
     * @param x at which the explosion will be drawn
     * @param y at which the explosion will be drawn
     */
    public Explosion(float x, float y) {
        //pass in x and y
        explosionX = x;
        explosionY = y;
        //pass in all 8 textures
        Texture explosion1 = new Texture("explosion1.png");
        Texture explosion2 = new Texture("explosion2.png");
        Texture explosion3 = new Texture("explosion3.png");
        Texture explosion4 = new Texture("explosion4.png");
        Texture explosion5 = new Texture("explosion5.png");
        Texture explosion6 = new Texture("explosion6.png");
        Texture explosion7 = new Texture("explosion7.png");
        Texture explosion8 = new Texture("explosion8.png");
        //create a texture region called frames using the textures
        TextureRegion[] frames = {new TextureRegion(explosion1), new TextureRegion(explosion2), new TextureRegion(explosion3), new TextureRegion(explosion4), new TextureRegion(explosion5), new TextureRegion(explosion6), new TextureRegion(explosion7), new TextureRegion(explosion8)};
        //set the explosion animation as the frames and set the timing
        explosion = new Animation(0.035f, frames);

    }

    /**
     * update the time by constantly added deltatime
     *
     * @param deltaTime amount of time between updates
     */
    public void update(float deltaTime) {
        time += deltaTime;
    }

    /**
     * draw the explosion
     *
     * @param batch spritebatch used to draw explosion
     */
    public void render(SpriteBatch batch) {
        batch.draw(explosion.getKeyFrame(time), explosionX, explosionY);
    }

    /**
     * dispose of animation
     */
    public void dispose() {
        for (TextureRegion tr : explosion.getKeyFrames()) {
            tr.getTexture().dispose();
        }
    }

    /**
     * accessor method for whether the explosion is finished or not
     *
     * @return whether or not explosion animation has finished
     */
    public boolean isFinished() {
        return explosion.isAnimationFinished(time);
    }
}
