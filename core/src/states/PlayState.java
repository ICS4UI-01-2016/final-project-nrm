/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Enemy;

import com.mygdx.game.EnemyMissile;

import com.mygdx.game.Explosion;

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

    //instance variables
    private Array<Enemy> enemy;
    private Array<RedEnemy> redEnemy;
    private Array<EnemyMissile> enemyMissile;
    private Player player;
    private SpriteBatch batch;
    private Texture bg;
    private Array<Missile> missile;
    private Array<Explosion> explosion;
    public final int PLAYER_WIDTH = 28;
    public final int PLAYER_HEIGHT = 30;
    private float enemytime = 0;
    private int score = 0;
    public BitmapFont font;
    private Texture lives;
    private boolean areEnemiesAttacking;
    private boolean areRedEnemiesAttacking;
    private int enemyNumber;
    private int redEnemyNumber;
    private Music sound;

    /**
     * constructor method for playstate
     *
     * @param sm statemanager to change states
     */
    public PlayState(StateManager sm) {
        //pass in statemanager
        super(sm);
        //create a player
        player = new Player(MyGdxGame.WIDTH / 2 - PLAYER_WIDTH / 2, 50, PLAYER_WIDTH, PLAYER_HEIGHT);
        //create a missile array
        missile = new Array<Missile>();
        //create an explosion array
        explosion = new Array<Explosion>();
        //create an enemy missile array
        enemyMissile = new Array<EnemyMissile>();
        //set camera view
        setCameraView(MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        //pass in background and lives texture
        bg = new Texture("Galaga_Background.png");
        lives = new Texture("Galaga_Fighter.png");
        //pass in batch
        batch = new SpriteBatch();
        //create an enemy array
        enemy = new Array<Enemy>();
        //create a red enemy array
        redEnemy = new Array<RedEnemy>();
        //set enemy attacking to false
        areEnemiesAttacking = false;
        areRedEnemiesAttacking = false;

        //spawn in enemies
        int count = 0;
        int y = 360;
        for (int i = 0; i < 10; i++) {
            enemy.add(new Enemy(20 + (count * 30), y));
            y = 390;
            enemy.add(new Enemy(20 + (count * 30), y));
            y = 360;
            count++;
        }

        //spawn in red enemies
        int count1 = 0;
        int y1 = 430;
        for (int i = 0; i < 8; i++) {
            redEnemy.add(new RedEnemy(50 + (count1 * 30), y1));
            y1 = 460;
            redEnemy.add(new RedEnemy(50 + (count1 * 30), y1));
            y1 = 430;
            count1++;
        }
        //create the font generator
        FreeTypeFontGenerator fontGenerator = new //grab the font from the fonts avalible in assets 
                FreeTypeFontGenerator(Gdx.files.internal("COOPBL.ttf"));
        //create the new font type 
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new //actually generate the font         
                FreeTypeFontGenerator.FreeTypeFontParameter();
        //chaze the size of th font 
        fontParameter.size = 18;
        font = fontGenerator.generateFont(fontParameter);
        //set camera view
        font.setColor(com.badlogic.gdx.graphics.Color.GREEN);
        score = 0;
        //set the sound 
        sound = Gdx.audio.newMusic(Gdx.files.internal("game.wav"));
        //play the sound
        sound.play();

    }

    @Override
    /**
     * method to draw game
     */
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        //draw background
        batch.draw(bg, getCameraX() - getViewWidth() / 2, getCameraY() - getViewHeight() / 2, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        //draw score
        font.draw(batch, " score: " + score, getViewWidth() - 150, getViewHeight() - 50);
        //draw player
        player.render(batch);
        //draw missiles
        for (int i = 0; i < missile.size; i++) {
            missile.get(i).render(batch);
        }
        //draw enemy missiles
        for (int i = 0; i < enemyMissile.size; i++) {
            enemyMissile.get(i).render(batch);
        }
        //draw enemies
        for (int i = 0; i < enemy.size; i++) {
            enemy.get(i).render(batch);
        }
        //draw red enemies
        for (int i = 0; i < redEnemy.size; i++) {
            redEnemy.get(i).render(batch);
        }
        //draw explosion
        for (int i = 0; i < explosion.size; i++) {
            explosion.get(i).render(batch);
        }
        //draw in 2 player lives
        if (player.getLives() == 3) {
            batch.draw(lives, 5, 5);
            batch.draw(lives, 40, 5);
        }
        //draw in one player life
        if (player.getLives() == 2) {
            batch.draw(lives, 5, 5);
        }
        batch.end();
    }

    @Override
    /**
     * method to update game
     */
    public void update(float deltaTime) {
        //update player
        player.update(deltaTime);
        //update enemies
        for (int i = 0; i < enemy.size; i++) {
            enemy.get(i).update(deltaTime);
        }
        //update red enemies
        for (int i = 0; i < redEnemy.size; i++) {
            redEnemy.get(i).update(deltaTime);
        }
        //enemy and red enemy back and fourth movement
        enemytime += deltaTime;
        if (enemytime > 6) {
            enemytime = enemytime - 6;
        }
        if (enemytime <= 3) {

            for (int i = 0; i < enemy.size; i++) {
                enemy.get(i).moveRight();
            }
            for (int i = 0; i < redEnemy.size; i++) {
                redEnemy.get(i).moveRight();
            }
        }
        if (enemytime > 3) {
            for (int i = 0; i < enemy.size; i++) {
                enemy.get(i).moveLeft();
            }
            for (int i = 0; i < redEnemy.size; i++) {
                redEnemy.get(i).moveLeft();
            }

        }
        //update missiles
        for (int i = 0; i < missile.size; i++) {
            missile.get(i).update(deltaTime);
        }
        //update enemy missiles
        for (int i = 0; i < enemyMissile.size; i++) {
            enemyMissile.get(i).update(deltaTime);
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
        //remove enemy or red enemy and missile when they collide
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
                        score = score + 50;
                        if (e.isEnemyMoving()) {
                            areEnemiesAttacking = false;
                        }
                        break;
                    }
                    Iterator<RedEnemy> itre = redEnemy.iterator();
                    while (itre.hasNext()) {
                        RedEnemy r = itre.next();
                        if (m.rCollides(r)) {
                            explosion.add(new Explosion(r.getX(), r.getY()));
                            it.remove();
                            itre.remove();
                            score = score + 100;
                            if (r.isEnemyMoving()) {
                                areRedEnemiesAttacking = false;
                            }
                            break;
                        }
                    }
                }
            }
        }

        //if player runs out of lives game over go to game over screen
        if (player.getLives() == 0) {
            //get the statemanager 
            StateManager gsm = getStateManager();
            //push on game screen
            gsm.set(new OverState(gsm, score));
            sound.stop();
        }
        //is the enemy moving
        for (int i = 0; i < enemy.size; i++) {
            if (enemy.get(i).getY() != enemy.get(i).getOriginalY()) {
                enemy.get(i).setMoving();
            }
        }
        //has the enemy left the screen
        for (int i = 0; i < enemy.size; i++) {
            if (enemy.get(i).getY() < 0) {
                enemy.get(i).leaveScreen();
            }
        }
        //are enemies attacking?
        if (!areEnemiesAttacking) {
            areEnemiesAttacking = !areEnemiesAttacking;
            enemyNumber = (int) (Math.random() * enemy.size);
            enemyAttack(enemy.get(enemyNumber));
        }
        //update enemy attack
        if (areEnemiesAttacking) {
            enemyAttack(enemy.get(enemyNumber));
        }

        // is the red enemy moving
        for (int i = 0; i < redEnemy.size; i++) {
            if (redEnemy.get(i).getY() != redEnemy.get(i).getOriginalY()) {
                redEnemy.get(i).setMoving();
            }
        }
        //has enemy left the screen
        for (int i = 0; i < redEnemy.size; i++) {
            if (redEnemy.get(i).getY() < 0) {
                redEnemy.get(i).leaveScreen();
            }
        }
        //are red enemies attacking?
        if (!areRedEnemiesAttacking) {
            areRedEnemiesAttacking = !areRedEnemiesAttacking;
            redEnemyNumber = (int) (Math.random() * redEnemy.size);
            redEnemyAttack(redEnemy.get(redEnemyNumber));
        }
        //update enemy attack
        if (areRedEnemiesAttacking) {
            redEnemyAttack(redEnemy.get(redEnemyNumber));
        }
        //remove enemy missile, a life and create an explosion if enemy missile hits player
        for (int i = 0; i < enemyMissile.size; i++) {
            if (enemyMissile.get(i).collides(player)) {
                enemyMissile.clear();
                explosion.add(new Explosion(player.getX(), player.getY()));
                player.playerHit();

            }
        }
        //remove enemy a life and create explosion if enemy and player collide
        Iterator<Enemy> itee = enemy.iterator();
        while (itee.hasNext()) {
            Enemy e = itee.next();
            if (e.collides(player)) {
                itee.remove();
                player.playerHit();
                explosion.add(new Explosion(player.getX(), player.getY()));
            }
        }
        //remove red enemy a life and create explosion if red enemy and player collide
        Iterator<RedEnemy> itre = redEnemy.iterator();
        while (itre.hasNext()) {
            RedEnemy r = itre.next();
            if (r.collides(player)) {
                itre.remove();
                player.playerHit();
                explosion.add(new Explosion(player.getX(), player.getY()));
            }
        }
        //get/set highscore
        Preferences pref = Gdx.app.getPreferences("highscore");
        int highScore = pref.getInteger("highscore", 0);
        if (score > highScore) {
            pref.putInteger("highScore", score);
            pref.flush();
        }

    }

    //red enemy attack method
    private void redEnemyAttack(RedEnemy r) {
        //send enemy forward
        r.enemyAttack();

        //fire missile
        if (r.getY() < 200 && !r.hasEnemyFired()) {
            enemyMissile.add(new EnemyMissile(r.getX(), r.getY()));
            r.fire();
        }
        //set to top of screen
        if (r.hasEnemyLeftScreen()) {
            r.setY(MyGdxGame.HEIGHT);
            r.leaveScreen();
            r.timeToStop();

        }
        //stop enemy 
        if (r.getY() < r.getOriginalY() && r.stopEnemy()) {
            r.enemyStopY();
            r.setY(r.getOriginalY());
            r.timeToStop();
            areRedEnemiesAttacking = false;
        }
    }

    //enemy attack method
    private void enemyAttack(Enemy e) {
        e.enemyAttack();

        //make enemy fire
        if (e.getY() < 200 && !e.hasEnemyFired()) {
            enemyMissile.add(new EnemyMissile(e.getX(), e.getY()));
            e.fire();
        }
        //set enemy to top of screen when they leave
        if (e.hasEnemyLeftScreen()) {
            e.setY(MyGdxGame.HEIGHT);
            e.leaveScreen();
            e.timeToStop();

        }

        //stop enemy in original position
        if (e.getY() < e.getOriginalY() && e.stopEnemy()) {
            e.enemyStopY();
            e.setY(e.getOriginalY());
            e.timeToStop();
            areEnemiesAttacking = false;
        }
    }

    @Override
    /**
     * method to handle player input
     */
    public void handleInput() {
        //player move right
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.getX() + PLAYER_WIDTH < MyGdxGame.WIDTH) {
            player.moveRight();
            //player move left
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.getX() > 0) {
            player.moveLeft();
            //don't move
        } else {
            player.zeroVelocity();
        }
        //add a missile
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && player.fire(System.currentTimeMillis())) {
            missile.add(new Missile(player.getX() + PLAYER_WIDTH / 2 - 3, player.getY() + PLAYER_HEIGHT));
        }

    }

    @Override
    /**
     * method to dispose of things
     */
    public void dispose() {
        player.dispose();
        for (int i = 0; i < enemy.size; i++) {
            enemy.get(i).dispose();
        }
        for (int i = 0; i < redEnemy.size; i++) {
            redEnemy.get(i).dispose();
        }
        for (int i = 0; i < enemyMissile.size; i++) {
            enemyMissile.get(i).dispose();
        }
        for (int i = 0; i < missile.size; i++) {
            missile.get(i).dispose();
        }
        for (int i = 0; i < explosion.size; i++) {
            explosion.get(i).dispose();
        }
        lives.dispose();
        bg.dispose();
        sound.dispose();
    }
}
