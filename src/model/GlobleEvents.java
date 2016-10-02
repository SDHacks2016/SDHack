package model;

import java.util.*;
import java.lang.*;

import model.Action.ActionDelegate;
import model.PaintObject.Tag;

public class GlobleEvents {
	public ArrayList<Event> events = new ArrayList<Event>();
	public static final String ITEM = "item";
	public static final String CHAR = "Rick";
	public static final String CEILING = "ceiling";
	public static final String GROUND = "ground";
	public static final String GRAVITY = "gravity";
	public static final String WORLD = "world";
	public static final String APPLE = "apple";
	public static final String DOOR = "door";

	public static final int GEAVITY_VALUE = 10;
	public static final int APPLE_HEIGHT = 25;
	public static final int APPLE_WIDTH = 25;
	public static final int DOOR_HEIGHT = 100;
	public static final int DOOR_WIDTH = 50;
	public static final int CEILING_HEIGHT = 25;
	public static final int GROUND_HEIGHT = 25;

 	public String[] turns = new String[]{"turnAround","turnLeft","turnRight"};
 	public String[] moves = new String[]{"move","walk","forward","backward","step","getTo"};
 	public String[] appears = new String[]{"appear","create","add","make","show"};
 	public String[] objects = new String[]{"object","objects","world","item","items","things"};
	public GlobleEvents(){
		
		addAppaerEvents();
		addMoveEvent();
		addTurnEvents();
		addGravityEvent();
		
		//move

	}

	public void addAppaerEvents(){
		for(String addAppear: appears){
			ActionDelegate delegate = new ActionDelegate() {
				
				@Override
				public void actionPerformed(World world, String parameters)
						throws Exception {
					// TODO Auto-generated method stub
					String[] items = new String[]{APPLE, GROUND, CEILING, DOOR};
					 int[] items_x = new int[]{10, 0, 0, 15};
					 int[] items_y = new int[]{10, world.worldHeight-GROUND_HEIGHT, 0, world.worldHeight-DOOR_HEIGHT};
					 int[] items_width = new int[]{APPLE_WIDTH, world.worldWidth, world.worldWidth, DOOR_WIDTH};
					 int[] items_height = new int[]{APPLE_HEIGHT, GROUND_HEIGHT, CEILING_HEIGHT, DOOR_HEIGHT};
						String[] params = parameters.split(",");
					if(!Arrays.asList(items).contains(params[0])) throw new Exception();
					int i = Arrays.asList(items).indexOf(params[0]);
					if(params.length == 3)
					{
						items_x[i] = Integer.parseInt(params[1].trim());
						items_y[i] = Integer.parseInt(params[2].trim());
					}
					world.objects.add(new PaintObject( 
							parameters, items_x[i], items_y[i], items_width[i], items_height[i], 1,
							i==3?Tag.EXIT:PaintObject.Tag.KEY_ITEM)
					);
				}
			};
			for(String itemObjet: objects){
			events.add(new Event(itemObjet, addAppear, new Action(delegate))); 
			}
		}
	}

	public void addMoveEvent(){
		for(String moveWalk: moves){	
			events.add(
				new Event(CHAR, moveWalk, new Action(
						new ActionDelegate(){
							public void actionPerformed(World world, String parameters){
								int moveDis = Integer.parseInt(parameters);
								PaintObject mainCharacter = world.getMainCharacter();
								
								if(moveWalk.equals("backward")) moveDis = -moveDis;

								switch(mainCharacter.getMode()){
									case PaintObject.MODE_LEFT: 
									case PaintObject.MODE_UP_LEFT: 
										mainCharacter.setX(mainCharacter.getX()- moveDis);
										break;
									case PaintObject.MODE_RIGHT: 
									case PaintObject.MODE_UP_RIGHT:
										mainCharacter.setX(mainCharacter.getX()+ moveDis);
										break;
								}
							}
						}
					)
				)
			);
		}
	}

	public void addTurnEvents(){
		for(String turn: turns)
		events.add(
			new Event(CHAR, turn, new Action(
					new ActionDelegate(){
						public void actionPerformed(World world, String parameters) throws Exception{
							
							PaintObject mainCharacter = world.getMainCharacter();
							int mode = mainCharacter.getMode();
							if(turn.equals("turnAround") ) mainCharacter.setMode((mode%2==1)?(mode+1):(mode-1));
							else if(turn.equals("turnLeft")) mainCharacter.setMode((mode==1||mode==2)?1:3);
							else if(turn.equals("turnRight")) mainCharacter.setMode((mode==1||mode==2)?2:4);
						}
					}
				)
			)
		);
	}

	public void addGravityEvent(){
		for(String itemObejct: objects){
		events.add(
			new Event(itemObejct, GRAVITY, new Action(
					new ActionDelegate(){
						public void actionPerformed(World world, String parameters) throws Exception{
							PaintObject mainCharacter = world.getMainCharacter();
							int gravity_value = Integer.parseInt(parameters);
							int rick_height = mainCharacter.getHeight();
							int rick_mode = mainCharacter.getMode();
    						if(gravity_value == GEAVITY_VALUE) {
    							if(rick_mode > 2) mainCharacter.setMode(rick_mode - 2);
    							mainCharacter.setY(world.worldHeight - rick_height - GROUND_HEIGHT);
    						}

    						if(gravity_value == - GEAVITY_VALUE) {
    							if(rick_mode < 3) mainCharacter.setMode(rick_mode + 2);
    							mainCharacter.setMode(3);
    							mainCharacter.setY(CEILING_HEIGHT);
    						}
						}
					}
				)
			)
		);
		}
	}
	
	public void addAliveEvent(){
		events.add(
			new Event(CHAR, "alive", new Action(
					new ActionDelegate() {
						public void actionPerformed(World world, String parameters){
							PaintObject mainCharacter = world.getMainCharacter();
							if(!mainCharacter.isAlive()){
								PaintObject character = new PaintObject("Rick", 200, 100, 50, 100, PaintObject.MODE_LEFT, Tag.MAIN_CHAR);
								world.objects.add(character);
								character.setAlive(true);
							}
						}
					}
				)
			)
		);
	}

}