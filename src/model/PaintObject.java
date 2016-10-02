package model;

import gui.GameFrame;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.jws.WebParam.Mode;
import javax.swing.tree.ExpandVetoException;

public class PaintObject {

    public enum Tag {MAIN_CHAR, KEY_ITEM, EXIT};

    public static final int MODE_LEFT = 1;
    public static final int MODE_RIGHT = 2;
    public static final int MODE_UP_LEFT = 3;
    public static final int MODE_UP_RIGHT = 4;
    
    private int mode;
    private ArrayList<LinkedList<Exp>> animations = new ArrayList<LinkedList<Exp>>();
    
    private interface Exp {
    	public void tick();
    }
    /**
     * Gets animation duration in miliseconds
     * @return
     */
    public long getAnimationDuration(){
    	return 1000;
    }
    public void tick(int tickCount){
    	ArrayList<LinkedList<Exp>> toRemove = new ArrayList<LinkedList<Exp>>();
    	for(LinkedList<Exp> animation : animations){
    		if(animation.isEmpty()){
    			toRemove.add(animation);
    			continue;
    		}
    		Exp e = animation.removeFirst();
    		e.tick();
    	}
    	animations.removeAll(toRemove);
    	if(animations.size() == 0){
    		moving = false;
    	}
    }
    
    public void setX(int x) {
    	LinkedList<Exp> list = new LinkedList<Exp>();
    	PaintObject obj = this;
    	int num = (int) (getAnimationDuration() / GameFrame.THREAD_SLEEP_DURATION);
    	double dx = (double)(x - this.x) / num;
    	
		
		for(int i = 0; i < num; i ++){
			final int  g = i;
			Exp e = new Exp() {
				
				@Override
				public void tick() {
					obj.x += dx;

				}
			};
			list.addFirst(e);
		}
		
		moving = true;
		animations.add(list);
	}
    

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	private boolean moving;
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	private double x, y;
	private int width, height;
    private String objectName;
    private Tag tag;
    private boolean isAlive;

    public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Tag getTag(){
        return this.tag;
    }

    public int getX() {
    return (int)this.x;
    }

    public int getY() {
	return (int)this.y;
    }

    public int getWidth() {
	return this.width;
    }

    public int getHeight() {
	return this.height;
    }

    public String getObjectName() {
    	return this.objectName;
    }
    
    public int getMode(){
    	return this.mode;
    }
    
    public void setMode(int mode){
    	this.mode = mode;
    }
    
    
    
    public PaintObject(String objectName, int X, int Y, 
        int Width, int Height, int mode, Tag tag) {
	this.x = X;
	this.y = Y;
	this.width = Width;
	this.height = Height;
	this.objectName = objectName;
	this.mode = mode;
    this.tag = tag;
    }

	public boolean contains(PaintObject another) {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,width, height).contains(new Rectangle((int)another.x, (int)another.y, another.width, another.height	));
	}
}
