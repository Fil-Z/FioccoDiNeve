/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowflake;

import java.awt.Polygon;
import java.util.List;

/**
 *
 * @author Filippo
 */
interface BuilderListener {
    public void builderStateChanged(List<Polygon> ps, double bX, double bY);
}
