package gui;

import java.awt.Graphics;
/**
 *
 * @author Chutong
 */
public class Apple 
{
    private int chaX = 0;
    private int chaY = 0;
    private int width = 0;
    private int height = 0;
    private Graphics g = null;
    public Apple(int x, int y, int wid, int hei, Graphics gra)
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
        g.drawLine(chaX, chaY, chaX + width, chaY);
        g.drawLine(chaX + width/2, chaY, chaX + width/2, chaY + height/4);
        g.drawOval(chaX, chaY + height/4, width, height);
    }
}
