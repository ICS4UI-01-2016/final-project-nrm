/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

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
    
}
