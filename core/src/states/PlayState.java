/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Missile;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Player;
import java.util.Iterator;

/**
 *
 * @author voigr4865
 */
public class PlayState extends State{
    
    private Player player;
    private SpriteBatch batch;
    private Texture bg;
    private Array<Missile> missile;
    private int missileCount;
    
    public final int PLAYER_WIDTH = 28;
    public final int PLAYER_HEIGHT = 30;
    
    public PlayState(StateManager sm){
        super(sm);
        player = new Player(MyGdxGame.WIDTH/2 - PLAYER_WIDTH/2, 50, PLAYER_WIDTH, PLAYER_HEIGHT);
        missile = new Array<Missile>();
        missileCount = 0;
        
        setCameraView(MyGdxGame.WIDTH , MyGdxGame.HEIGHT );
        
        bg = new Texture("Galaga_Background.png");
  
        batch = new SpriteBatch();
        
    }
    
    @Override
    public void render(SpriteBatch batch){
        
        batch.setProjectionMatrix(getCombinedCamera());
        
        batch.begin();
        
        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2, MyGdxGame.WIDTH , MyGdxGame.HEIGHT);
        
        player.render(batch);
        
        for(int i = 0; i < missile.size; i++){
            missile.get(i).render(batch);
        }
        
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        player.update(deltaTime);
        
        for(int i = 0; i < missile.size; i++){
            missile.get(i).update(deltaTime);
        }
        
        
//        Iterator<Missile> it = missile.iterator();
//        while(it.hasNext()){
//            Missile m = it.next();
//            if(/when do i remove missiles?){
//                it.remove();
//            }
//        }
        
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
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            missile.add(new Missile(player.getX() + PLAYER_WIDTH/2 - 3, player.getY() + PLAYER_HEIGHT));
            missileCount++;
        }
        
        
        
    }

    @Override
    public void dispose() {
        player.dispose();
    }
    
}
