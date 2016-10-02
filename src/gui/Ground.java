package gui;

import java.awt.Graphics;

/**
 *
 * @author Chutong
 */
public class Ground 
{
    private int chaX = 0;
    private int chaY = 0;
    private int width = 0;
    private int height = 0;
    private Graphics g = null;
    public Ground(int x, int y, int wid, int hei, Graphics gra)
    {
        chaX = x;
        chaY = y;
        width = wid;
        height = hei;
        g = gra;
        paint(g);
    }
    public void paint(Graphics g)
    {
        g.fillRect(chaX, chaY, width, height);
    }
}
