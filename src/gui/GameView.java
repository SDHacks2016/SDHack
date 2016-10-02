package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.PaintObject;
import model.World;
import model.WorldFactory;
import model.GlobleEvents;

public class GameView extends JPanel {

	private World world;
	private int count = 0;

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		count ++;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		for(PaintObject obj : world.objects){
			switch (obj.getTag()) {
			case EXIT:
				new Door(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g, obj.getMode());	
				break;
			case MAIN_CHAR:
				new Painter(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g, obj.getMode(), obj.isMoving(), count);
				break;
			case KEY_ITEM:
				String name = obj.getObjectName();
				if(name.equals(GlobleEvents.CEILING)){
					new Ceiling(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
				} else if(name.equals(GlobleEvents.GROUND)){
					new Ground(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
				} else if (name.equals(GlobleEvents.APPLE)){
					new Apple(obj.getX(), obj.getY(), obj.getWidth(), obj.getHeight(), g);
				}

			default:
				break;
			}


			
		}
	}
	
}
