package model;

/**
 * Name: Zhao Liu
 * Date: 10/01/2016
 * Purpose:
 */

import java.util.*;

import logic.GameController;
import logic.Statement;
import model.PaintObject.Tag;

public class World {
    
    public int worldWidth;
    public int worldHeight;
    public int timeDelay;
    public ArrayList<Event> events;
    
    public interface WorldCheck{
    	public void check();
    }
    public WorldCheck check;
    public PaintObject getMainCharacter(){
    	for(PaintObject obj : objects){
    		if(obj.getTag() == Tag.MAIN_CHAR){
    			return obj;
    		}
    	}
    	System.out.println("ERROR: MAIN CHARACTER NOT FOUND");
    	return null;
    }
    
    public String caption = "";
    public ArrayList<PaintObject> objects;
	public GameController controller;
	public void evalStatement(Statement statement) throws Exception {
		// TODO Auto-generated method stub
		World world = this;
		for(Event evt : new GlobleEvents().events){
			if(evt.getCategory().equals(statement.name)){
				if(evt.getName().equals(statement.property)){
					Action action = evt.getAssociatedAction();
					action.getDelegate().actionPerformed(world, statement.value);
				}
			}
		}
	}
}
