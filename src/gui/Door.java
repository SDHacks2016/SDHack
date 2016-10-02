package gui;

/**
 *
 * @author Chutong
 */
import java.awt.Graphics;
import java.awt.*;
public class Door 
{
    private int chaX = 0;
    private int chaY = 0;
    private int width = 0;
    private int height = 0;
    private int mode = 0;
    private Graphics g = null;
    public Door(int x, int y, int wid, int hei, Graphics gra, int m)
    {
        chaX = x;
        chaY = y;
        width = wid;
        height = hei;
        mode = m;
        g = gra;
        paint(g);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        if(mode == 1)
        {
            g.drawLine(chaX, chaY, chaX + width, chaY);
            g.drawLine(chaX, chaY, chaX, chaY + height);
            g.drawLine(chaX, chaY + height, chaX + width, chaY + height);
            g.drawLine(chaX + width, chaY + height, chaX + width, chaY);
            g.drawOval(chaX + width/8, chaY + height/2, width/10, width/10);
        }
        if(mode == 3)
        {
            g.drawLine(chaX, chaY, chaX + width, chaY);
            g.drawLine(chaX, chaY, chaX, chaY + height);
            g.drawLine(chaX, chaY + height, chaX + width, chaY + height);
            g.drawLine(chaX + width, chaY + height, chaX + width, chaY);
            g.drawOval(chaX + 3*width/4, chaY + height/2, width/10, width/10);
        }
    }
}
