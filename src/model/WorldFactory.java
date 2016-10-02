package model;
import java.util.*;
import java.util.jar.Attributes.Name;

import javax.swing.JOptionPane;

import model.PaintObject.Tag;
import model.World.WorldCheck;
public  class WorldFactory {

	public static final String NAME_CHARACTER = "character";
	public static final String NAME_DOOR = "door";

	public static World WorldConfiguration(int level) {
		World world = new World();
		world.objects = new ArrayList<PaintObject>();
		world.check = new WorldCheck() {
			
			@Override
			public void check() {
				for(PaintObject obj : world.objects){
					if(obj.equals(world.getMainCharacter())){
						continue;
					} else if(obj.contains(world.getMainCharacter())){
						if(obj.getTag() == Tag.EXIT){
							world.controller.toLevel(level + 1);
						}
					}
					
				}
				
			}
		};
		world.worldWidth = 800;
		world.worldHeight = 400;
		
		
		
		switch(level) {
		case 1:
			
			
			PaintObject character = new PaintObject(NAME_CHARACTER, 200, 100, 50, 100, PaintObject.MODE_LEFT, Tag.MAIN_CHAR);
			world.objects.add(character);
PaintObject door = new PaintObject(NAME_DOOR, 0, 275, 50, 100, PaintObject.MODE_LEFT, Tag.EXIT);
			world.objects.add(door);
			
		break;	

		case 2:
			
			character = new PaintObject(NAME_CHARACTER, 200, 100, 50, 100, PaintObject.MODE_RIGHT, Tag.MAIN_CHAR);
			
			world.objects.add(character);
			door = new PaintObject(NAME_DOOR, 0, 25, 50, 100, PaintObject.MODE_UP_LEFT, Tag.EXIT);
			world.objects.add(door);
			break;
		default:
			JOptionPane.showMessageDialog(world.controller.getInputDialog(), "You have completed all levels. You Win!!!");

		}
		
		
		return world;
	}
}
