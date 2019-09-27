/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowflake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2d;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import static javax.swing;

/**
 *
 * @author Filippo
 */
public class SnowFlake extends JPanel implements MouseListener, MouseMotionListener {

    private Polygon poly = new Polygon();
    private List<Point> pts = new ArrayList<>();
    private Polygon triangle = new Polygon();
    private List<Polygon> ts = new ArrayList<>();
    private Random rand;
    private boolean removeLast = false;
    
    
    public SnowFlake() {
        
        JFrame f = new JFrame("SnowFlake");
        //super("SnowFlake");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setContentPane(this);
        //this
        //this.setSize(500, 500);
        this.setPreferredSize(new Dimension(500, 500));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        triangle.addPoint(350, 450);
        triangle.addPoint(350, 50);
        triangle.addPoint(150, 50);
        rand = new Random();
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillPolygon(triangle);
        g.setColor(Color.red);
        for (int i = 0; i < pts.size() - 1; i++) {
            Point p = pts.get(i);
            g.drawLine(pts.get(i).x, pts.get(i).y, pts.get(i+1).x, pts.get(i+1).y);
        }
        for (Point p : pts) {
            g.fillOval(p.x - pSize / 2, p.y - pSize / 2, pSize, pSize);
        }
        for(Polygon p : ts) {
            //g.setColor(getRandomColor());
            g.fillPolygon(p);
        }
        
        if (removeLast) {
            pts.remove(pts.size()-1);
            removeLast = false;
            ts.clear();
        }
        g.dispose();
    }
    
    public Color getRandomColor() {
        float r = rand.nextFloat();
        return new Color(r, v, b);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SnowFlake sf = new SnowFlake();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pts.add(e.getPoint());
        poly.addPoint(e.getX(), e.getY());
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    
    @Override
    public void mouseExited(MouseEvent e) {
        ts.clear();
        pts.add(pts.get(0));

        poly.reset();
        for (Point p : pts) {
            poly.addPoint(p.x, p.y);
        }
        removeLast = true;
        repaint();
        System.out.println(getSVG());
    }
    
    public String getSVG() {
        String fz;
        return fz;
    }
    
    public void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(SnowFlake.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        poly.xpoints[poly.xpoints.length-1] = e.getX();
        poly.ypoints[poly.xpoints.length-1] = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
