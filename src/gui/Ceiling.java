package gui;

/**
 *
 * @author Chutong
 */
import java.awt.Graphics;
import java.awt.*;
public class Ceiling 
{
    private int chaX = 0;
    private int chaY = 0;
    private int width = 0;
    private int height = 0;
    private Graphics g = null;
    public Ceiling(int x, int y, int wid, int hei, Graphics gra)
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
        g.drawLine(chaX, chaY + height, chaX + width, chaY + height);
        for(int i = 0;i <= width;i = i + width/20)
        {
            g.drawLine(chaX + i, chaY + height, chaX + i + width/20, chaY);
        }
    }
}