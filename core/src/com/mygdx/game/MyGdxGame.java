package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import states.PlayState;
import states.State;
import states.StateManager;

public class MyGdxGame extends ApplicationAdapter {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 700;
    private SpriteBatch batch;
    private StateManager stateManager;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(1, 0, 0, 1);

        stateManager = new StateManager();
        State firstScreen = new PlayState(stateManager);
        stateManager.push(firstScreen);// load the first screen

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        stateManager.handleInput();
        stateManager.update(Gdx.graphics.getDeltaTime());
        
        
        stateManager.render(batch);
    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
