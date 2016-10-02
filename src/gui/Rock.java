package gui;

import java.awt.Graphics;

public class Rock {
	private int chaX = 0;
    private int chaY = 0;
    private int width = 0;
    private int height = 0;
    private Graphics g = null;
    public Rock(int x, int y, int wid, int hei, Graphics gra)
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
        g.drawLine(chaX + width/2, chaY, chaX, chaY + height);
        g.drawLine(chaX + width/2, chaY, chaX + width, chaY + height);
        g.drawLine(chaX, chaY + height, chaX + width, chaY + height);
    }
}
