/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author munta
 */
public class MenuState extends State {

    //the backround

    private Texture bg;

    private int highScore;
    //the font
    private BitmapFont font;

    public MenuState(StateManager sm) {
        super(sm);
        //add the backround texture image
        bg = new Texture("Backround.png");

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
        batch.end();
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {
        bg.dispose();

    }

}
