/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Stack;

/**
 *
 * @author joudn2217
 */
public class StateManager {
    //instance variable
    private Stack<State> states;
    
    /**
     * constructor for statemanager
     */
    public StateManager() {
        //pass in states
        states = new Stack<State>();
    }

    /**
     * push a state on top of whatever is currently on
     * @param s state being pushed
     */
    public void push(State s) {
        //push state
        states.push(s);
    }

    /**
     * remove current state
     */
    public void pop() {
        //pop current state
        State s = states.pop();
        //dispose of state
        s.dispose();
    }

    /**
     * remove current state and push the new one
     * @param s state being pushed
     */
    public void set(State s) {
        //remove
        pop();
        //push new state
        push(s);
    }

    /**
     * method to update
     * @param deltaTime time between updates
     */
    public void update(float deltaTime) {
        states.peek().update(deltaTime);
    }

    /**
     * method to render
     * @param batch spritebatch used to draw
     */
    public void render(SpriteBatch batch) {
        states.peek().render(batch);
    }
    /**
     * method to handle user input
     */
    public void handleInput() {
        states.peek().handleInput();
    }
}
