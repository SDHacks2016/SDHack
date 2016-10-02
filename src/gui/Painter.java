package gui;

import java.awt.*;
import java.util.Random;
/**
 *
 * @author Chutong
 */
public class Painter 
{
    private int chaX = 0;
    private int chaY = 0;
    private int width = 0;
    private int height = 0;
    private int mode = 0;
    private Graphics g = null;
    private int count = 0;
    public Painter(int x, int y, int wid, int hei, Graphics gra, int m, boolean moving, int movingRef)
    
    {
        chaX = x;
        chaY = y;
        width = wid;
        height = hei;
        mode = m;
        g = gra;
        
        paint(g, moving,  movingRef);
    }
 public void drawLegs(Graphics g, boolean moving, int movingRef){
    	if(moving){
        	switch (movingRef %3) {
			case 0:
        	g.drawLine(chaX + width/2, chaY + 2*height/3, chaX, chaY + height);
        	g.drawLine(chaX + width/2, chaY + 2*height/3, chaX + width, chaY + height);
				
				break;
			case 1:
			g.drawLine(chaX + width/2, chaY + 2*height/3, chaX + width / 2, chaY + height);
        	g.drawLine(chaX + width/2, chaY + 2*height/3, chaX + width, chaY + height);
				break;
			case 2:
        	g.drawLine(chaX + width/2, chaY + 2*height/3, chaX, chaY + height);
			g.drawLine(chaX + width/2, chaY + 2*height/3, chaX + width / 2, chaY + height);
				break;
				

			default:
				break;
			}
        } else {
        	g.drawLine(chaX + width/2, chaY + 2*height/3, chaX, chaY + height);
        	g.drawLine(chaX + width/2, chaY + 2*height/3, chaX + width, chaY + height);
        }
    }
    public void paint(Graphics g, boolean moving, int movingRef)
    {
        g.setColor(Color.BLACK);
        if(mode == 1)
        {
            g.fillOval(chaX +(width-height/3)/2,chaY, height/3, height/3);
            g.drawLine(chaX + width/2, chaY + height/3, chaX + width/2, chaY + 2*height/3);
            g.drawLine(chaX + width/2, chaY + height/2, chaX, chaY + height/2);
            g.drawLine(chaX, chaY + height/2, chaX, chaY + height/3);
            g.drawLine(chaX + width/2, chaY + height/2, chaX + width, chaY + height/2);
            g.drawLine(chaX + width, chaY + height/2, chaX + width, chaY + 2*height/3);
            drawLegs(g, moving, movingRef);
        }
        else if(mode == 2)
        {
            g.fillOval(chaX +(width-height/3)/2,chaY, height/3, height/3);
            g.drawLine(chaX + width/2, chaY + height/3, chaX + width/2, chaY + 2*height/3);
            g.drawLine(chaX + width/2, chaY + height/2, chaX, chaY + height/2);
            g.drawLine(chaX, chaY + height/2, chaX, chaY + 2*height/3);
            g.drawLine(chaX + width/2, chaY + height/2, chaX + width, chaY + height/2);
g.drawLine(chaX + width, chaY + height/2, chaX + width, chaY + height/3);
drawLegs(g, moving, movingRef);
        }
        else if(mode == 3)
        {
            g.fillOval(chaX +(width-height/3)/2,chaY + 2*height/3, height/3, height/3);
            g.drawLine(chaX + width/2, chaY + height/3, chaX + width/2, chaY + 2*height/3);
            g.drawLine(chaX + width/2, chaY + height/2, chaX, chaY + height/2);
            g.drawLine(chaX, chaY + height/2, chaX, chaY + 2*height/3);
            g.drawLine(chaX + width/2, chaY + height/2, chaX + width, chaY + height/2);
            g.drawLine(chaX + width, chaY + height/2, chaX + width, chaY + height/3);
            drawUpLegs(g, moving, movingRef);
        }
        else if(mode == 4)
        {
            g.fillOval(chaX +(width-height/3)/2,chaY + 2*height/3, height/3, height/3);
            g.drawLine(chaX + width/2, chaY + height/3, chaX + width/2, chaY + 2*height/3);
            g.drawLine(chaX + width/2, chaY + height/2, chaX, chaY + height/2);
            g.drawLine(chaX, chaY + height/2, chaX, chaY + height/3);
            g.drawLine(chaX + width/2, chaY + height/2, chaX + width, chaY + height/2);
            g.drawLine(chaX + width, chaY + height/2, chaX + width, chaY + 2*height/3);
           drawUpLegs(g, moving, movingRef); 
        }
    }
    public void drawUpLegs(Graphics g, boolean moving, int movingRef){
    	if(moving){
        	switch (movingRef %3) {
			case 0:
	            g.drawLine(chaX + width/2, chaY + height/3, chaX + width / 2, chaY);
	            g.drawLine(chaX + width/2, chaY + height/3, chaX + width, chaY);
				
				break;
			case 1:
				g.drawLine(chaX + width/2, chaY + height/3, chaX, chaY);
	            g.drawLine(chaX + width/2, chaY + height/3, chaX + width, chaY);
				break;
			case 2:
				g.drawLine(chaX + width/2, chaY + height/3, chaX, chaY);
	            g.drawLine(chaX + width/2, chaY + height/3, chaX + width / 2, chaY);
				break;
				

			default:
				break;
			}
        } else {
        	g.drawLine(chaX + width/2, chaY + height/3, chaX, chaY);
            g.drawLine(chaX + width/2, chaY + height/3, chaX + width, chaY);
        }
    }
}
