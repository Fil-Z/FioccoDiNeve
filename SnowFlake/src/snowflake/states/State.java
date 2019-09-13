/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowflake.states;

import java.awt.Graphics;

/**
 *
 * @author Filippo
 */
public abstract class State {
    
    private static State currentState;
    
    public State() {
        
    }

    public abstract void render(Graphics g);
    
    public void setState(State state) {
            currentState = state;
    }

    public State getState() {
            return currentState;
    }
}
