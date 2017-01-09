/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Enemy;
import com.mygdx.game.MyGdxGame;

/**
 *
 * @author voigr4865
 */
public class PlayState extends State {

    private Enemy[] enemy;
    private SpriteBatch batch;
    private Texture bg;

    public PlayState(StateManager sm) {
        super(sm);

        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

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

        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

        for (int i = 0; i < enemy.length; i++) {
            enemy[i].render(batch);
        }
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
