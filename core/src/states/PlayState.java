/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Enemy;

import com.mygdx.game.EnemyMissile;

import com.mygdx.game.Explosion;

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
    private Array<EnemyMissile> enemyMissile;
    private Player player;
    private SpriteBatch batch;
    private Texture bg;
    private Texture getHit;
    private Array<Missile> missile;
    private Array<Explosion> explosion;
    public final int PLAYER_WIDTH = 28;
    public final int PLAYER_HEIGHT = 30;
    private float enemytime = 0;
    private int score=0;
    public BitmapFont font;
    private Texture lives;

    public PlayState(StateManager sm) {
        super(sm);
        player = new Player(MyGdxGame.WIDTH / 2 - PLAYER_WIDTH / 2, 50, PLAYER_WIDTH, PLAYER_HEIGHT);
        missile = new Array<Missile>();
        explosion = new Array<Explosion>();
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        bg = new Texture("Galaga_Background.png");
        lives = new Texture("Galaga_Fighter.png");
        batch = new SpriteBatch();
        enemy = new Array<Enemy>();
        int count = 0;
        int y = 360;
        for (int i = 0; i < 10; i++) {
            enemy.add(new Enemy(50 + (count * 30), y));
            y = 390;
            enemy.add(new Enemy(50 + (count * 30), y));
            y = 360;
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
        //create the font generator
        FreeTypeFontGenerator fontGenerator = new
        //grab the font from the fonts avalible in assets 
        FreeTypeFontGenerator(Gdx.files.internal("COOPBL.ttf"));
        //create the new font type 
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new
        //actually generate the font         
        FreeTypeFontGenerator.FreeTypeFontParameter();
        //chaze the size of th font 
        fontParameter.size = 18;
        
        font= fontGenerator.generateFont(fontParameter);
      
        //set camera view
        font.setColor(com.badlogic.gdx.graphics.Color.GREEN);
     score=0;


    }

    @Override
    public void render(SpriteBatch batch) {

        batch.setProjectionMatrix(getCombinedCamera());

        batch.begin();
        

        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        font.draw(batch," score: " + score, getViewWidth()-150,getViewHeight()-50);
        player.render(batch);

       
            for (int i = 0; i < missile.size; i++) {
            missile.get(i).render(batch);
        }


        for (int i = 0; i < enemy.size; i++) {
            enemy.get(i).render(batch);
        }

//        for(int i = 0; i < 8; i++){
//            redEnemy.get(i).render(batch);
//      }

        //draw explosion
        for (int i = 0; i < explosion.size; i++) {
            explosion.get(i).render(batch);
        }
        
        if(player.getLives() == 3){
            batch.draw(lives, 5, 5);
            batch.draw(lives, 30, 5);
        }
        
        if(player.getLives() == 2){
            batch.draw(lives, 5, 5);
        }
        

        batch.end();
    }

    
    
    
    
     
    
    
    
    @Override
    public void update(float deltaTime) {
        player.update(deltaTime);

        for (int i = 0; i < enemy.size; i++) {
            enemy.get(i).update(deltaTime);
        }



        enemytime += deltaTime;
        if (enemytime > 8) {
            enemytime = enemytime - 8;
        }

        if (enemytime <= 4) {

            for (int i = 0; i < enemy.size; i++) {
                enemy.get(i).moveRight();

            }
        }


        if (enemytime > 4) {
            for (int i = 0; i < enemy.size; i++) {

                enemy.get(i).moveLeft();


            }

        }

        for (int i = 0; i < missile.size; i++) {
            missile.get(i).update(deltaTime);
        }

        //remove explosion after animation
        Iterator<Explosion> itex = explosion.iterator();
        while (itex.hasNext()) {
            Explosion ex = itex.next();
            ex.update(deltaTime);
            if (ex.isFinished()) {
                itex.remove();
            }
        }

        Iterator<Missile> it = missile.iterator();
        while (it.hasNext()) {
            Missile m = it.next();
            if (m.getY() > 700) {
                it.remove();
            } else {
                Iterator<Enemy> ite = enemy.iterator();
                while (ite.hasNext()) {
                    Enemy e = ite.next();
                    if (m.collides(e)) {
                        explosion.add(new Explosion(e.getX(), e.getY()));
                        it.remove();
                        ite.remove();
                        score=score+50;
                        break;
                    }
                }
            }
        }

        if(player.getLives() == 0){
            //get the statemanager 
             StateManager gsm = getStateManager();
             //push on game screen
             gsm.set(new OverState(gsm));
        }

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

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && player.fire(System.currentTimeMillis())) {
            missile.add(new Missile(player.getX() + PLAYER_WIDTH / 2 - 3, player.getY() + PLAYER_HEIGHT));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            player.playerHit();
        }

    }

    @Override
    public void dispose() {
        player.dispose();
    }
}
