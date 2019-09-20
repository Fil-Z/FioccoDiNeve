/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowflake;

import java.awt.Graphics;
import snowflake.states.State;

/**
 *
 * @author Filippo
 */
public class BuilderState extends State {
    
    private PolygonBuilder pb;
    
    public BuilderState() {
        super();
        pb = new PolygonBuilder();
        
    }

    @Override
    public void render(Graphics g) {
        
    }
    
}
