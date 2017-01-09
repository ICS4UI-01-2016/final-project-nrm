/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Enemy;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Player;

/**
 *
 * @author voigr4865
 */
public class PlayState extends State{
    
    private Player player;
    private SpriteBatch batch;
    private Texture bg;
    
    public final int PLAYER_WIDTH = 28;
    public final int PLAYER_HEIGHT = 30;
    
    public PlayState(StateManager sm){
        super(sm);
        player = new Player(MyGdxGame.WIDTH/2 - PLAYER_WIDTH/2, 50, PLAYER_WIDTH, PLAYER_HEIGHT);
        setCameraView(MyGdxGame.WIDTH , MyGdxGame.HEIGHT );
        
        bg = new Texture("Galaga_Background.png");

        enemy = new Enemy[10];
        int count = 0;
        for (int i = 0; i < enemy.length; i++) {
            enemy[i] = new Enemy(150 + (count * 30), 360);
            count++;
        }
      
    }
    

    @Override
    public void render(SpriteBatch batch) {

        batch.setProjectionMatrix(getCombinedCamera());

        batch.begin();
        
        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2, MyGdxGame.WIDTH , MyGdxGame.HEIGHT);
        
        player.render(batch);
        
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        player.update(deltaTime);
        
        
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.getX()+PLAYER_WIDTH < MyGdxGame.WIDTH){
            player.moveRight();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.getX() > 0){
            player.moveLeft(); 
        }else{
            player.zeroVelocity();
        }
        
        
    }

    @Override
    public void dispose() {
    }
}
