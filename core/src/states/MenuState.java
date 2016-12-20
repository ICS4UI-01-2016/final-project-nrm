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
    //an integer to store highscore
    private Texture button;
    private int highScore;
    //the font
    private BitmapFont font;
    
    public MenuState (StateManager sm){
        //add the backround texture image
        bg = new Texture("Backround.jpg");
        //add the the playbutton texture image
        button = new Texture("playbutton.png");
        
        
    }

    @Override
    public void render(SpriteBatch batch) {
      batch.begin();
      batch.draw(bg, 0, 0, getViewWidth(), getViewHeight());
    }

    @Override
    public void update(float deltaTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
