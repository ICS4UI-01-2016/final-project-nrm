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
public class EnemyMissile {

    //instance variables
    private float enemyMissileY;
    private float enemyMissileX;
    private Texture enemyMissileTexture;
    private Rectangle bounds;
    private final float DOWNWARDS_VELOCITY = -150;

    /**
     * constructor method for enemy missiles
     *
     * @param x the x of the enemy missile
     * @param y the y of the enemy missile
     */
    public EnemyMissile(float x, float y) {
        //pass in enemy missile x and y
        enemyMissileY = y;
        enemyMissileX = x;
        //pass in texture
        enemyMissileTexture = new Texture("missile.png");
        //pass/set in bounds
        bounds = new Rectangle(enemyMissileX, enemyMissileY, enemyMissileTexture.getWidth(), enemyMissileTexture.getHeight());

    }

    /**
     * updates enemy missiles x and y using velocity
     *
     * @param deltaTime times passed between updates
     */
    public void update(float deltaTime) {
        //add velocityX to playerX
        enemyMissileY += DOWNWARDS_VELOCITY * deltaTime;
        //update the bounds to playerX and playerY
        bounds.setPosition(enemyMissileX, enemyMissileY);
    }

    /**
     * draw in the enemy missile
     *
     * @param batch a spritebatch to draw
     */
    public void render(SpriteBatch batch) {
        batch.draw(enemyMissileTexture, enemyMissileX, enemyMissileY);
    }

    /**
     * disposes of enemy missile texture
     */
    public void dispose() {
        enemyMissileTexture.dispose();
    }

    /**
     * accessor method to get y
     *
     * @return y position of missile
     */
    public float getY() {
        return enemyMissileY;
    }

    /**
     * return whether a missile has collided with a player
     *
     * @param p player passed in
     * @return whether or not a collision has occured
     */
    public boolean collides(Player p) {
        if (bounds.overlaps(p.getBounds())) {
            return true;
        }
        return false;
    }

}
