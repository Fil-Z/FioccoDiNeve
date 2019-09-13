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
