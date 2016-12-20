/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author voigr4865
 */
public class PlayState extends State{
    
    private SpriteBatch batch;
    private Texture bg;
    
    public PlayState(StateManager sm){
        super(sm);
        
        setCameraView(MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        
        bg = new Texture("bg.jpg");
  
        
        
    }
    
    @Override
    public void render(SpriteBatch batch){
        
        batch.setProjectionMatrix(getCombinedCamera());
        
        batch.begin();
        
        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2);
        
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
        
    }
    
}
