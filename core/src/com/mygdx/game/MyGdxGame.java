package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import states.MenuState;
import states.State;
import states.StateManager;

public class MyGdxGame extends ApplicationAdapter {
    public static int WIDTH;
    public static int HEIGHT;

    SpriteBatch batch;
    Texture img;
    private StateManager stateManager; // look after the different states

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        stateManager = new StateManager();
        State firstScreen = new MenuState(stateManager);
        stateManager.push(firstScreen); // load the first screen
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateManager.render(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
