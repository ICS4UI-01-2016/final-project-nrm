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
import com.mygdx.game.Enemy;
import com.mygdx.game.GreenEnemy;
import com.mygdx.game.Missile;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Player;
import com.mygdx.game.RedEnemy;
import java.util.Iterator;

/**
 *
 * @author voigr4865
 */
public class PlayState extends State {

    private Array<Enemy> enemy;
    private Array<RedEnemy> redEnemy;
    private Array<GreenEnemy> green;
    private Player player;
    private SpriteBatch batch;
    private Texture bg;
    private Array<Missile> missile;
    public final int PLAYER_WIDTH = 28;
    public final int PLAYER_HEIGHT = 30;

    public PlayState(StateManager sm) {
        super(sm);
        player = new Player(MyGdxGame.WIDTH / 2 - PLAYER_WIDTH / 2, 50, PLAYER_WIDTH, PLAYER_HEIGHT);
        missile = new Array<Missile>();
        
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

        bg = new Texture("Galaga_Background.png");


        batch = new SpriteBatch();




        enemy = new Array<Enemy>();

        int count = 0;
        int y = 360;
        for (int i = 0; i < 8; i++) {
            enemy.add(new Enemy(150 + (count * 30), y));
//            y = 390;
//            enemy.add(new Enemy(150+(count * 30), y));
//            y= 360;
            count++;
        }

//        redEnemy = new Array<RedEnemy>();
//        int count1 = 0;
//        int y1 = 450;
//        for (int i = 0; i < 20; i++) {
//            redEnemy.add(new RedEnemy(180 + (count1 * 30), y1));
//            y1 = 480;
//            redEnemy.add(new RedEnemy(180 + (count1 * 30), y1));
//            y1 = 450;
//            count1++;
//        }

//        enemy = new Enemy[10];
//        int count = 0;
//        for (int i = 0; i < enemy.length; i++) {
//            enemy[i] = new Enemy(150 + (count * 30), 360);
//            count++;
//        }
//
//        redEnemy = new RedEnemy[8];
//        int c = 0;
//        for (int i = 0; i < redEnemy.length; i++) {
//            redEnemy[i] = new RedEnemy(180 + (c * 30), 425);
//            c++;
//        }
//
//        green = new GreenEnemy[4];
//        int x = 0;
//        for (int i = 0; i < green.length; i++) {
//            green[i] = new GreenEnemy(238 + (x * 30), 490);
//            x++;
//        }

    }

    @Override
    public void render(SpriteBatch batch) {

        batch.setProjectionMatrix(getCombinedCamera());

        batch.begin();

        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);

        player.render(batch);

//        for (int i = 0; i < enemy.length; i++) {
//            enemy[i].render(batch);
//        }
//
//        for (int i = 0; i < redEnemy.length; i++) {
//            redEnemy[i].render(batch);
//        }
//        
//
//        for (int i = 0; i < enemy.length; i++) {
//            enemy[i].render(batch);
//        }
//        
//
//
        for (int i = 0; i < missile.size; i++) {
            missile.get(i).render(batch);
        }
//        
//
//        for (int i = 0; i < green.length; i++) {
//            green[i].render(batch);
//        }

        for (int i = 0; i < enemy.size; i++) {
            enemy.get(i).render(batch);
        }

//        for(int i = 0; i < 8; i++){
//            redEnemy.get(i).render(batch);
//        }



batch.end();
    }

    @Override
    public void update(float deltaTime) {
        player.update(deltaTime);


        for (int i = 0; i < missile.size; i++) {
            missile.get(i).update(deltaTime);
        }

        Iterator<Missile> it = missile.iterator();
        while (it.hasNext()) {
            Missile m = it.next();
            if (m.getY() > 700) {
                it.remove();
            }else{
                Iterator<Enemy> ite = enemy.iterator();
                while (ite.hasNext()) {
                    Enemy e = ite.next();
                    if (m.collides(e)){
                        it.remove();
                        ite.remove();
                        break;
                    }
                }
            }
        }
        //collisions
        



    }

    @Override
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.getX() + PLAYER_WIDTH < MyGdxGame.WIDTH) {
            player.moveRight();
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.getX() > 0) {
            player.moveLeft();
        } else {
            player.zeroVelocity();
        }

        
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            missile.add(new Missile(player.getX() + PLAYER_WIDTH / 2 - 3, player.getY() + PLAYER_HEIGHT));

        }






    }

    @Override
    public void dispose() {

        player.dispose();

    }
}
