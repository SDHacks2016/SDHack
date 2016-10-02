package gui;

import javax.swing.JFrame;

import logic.GameController;
import model.PaintObject;
import model.World;

public class GameFrame extends JFrame {

	GameController controller;
	GameView gameview;
	public static final int THREAD_SLEEP_DURATION = 20;
	
	public GameFrame(GameController controller){
		this.controller = controller;
		this.gameview = new GameView();
		add(gameview);
	}
	
	private World world;
	private Thread animation;

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
		this.world.controller = this.controller;
		this.setSize(world.worldWidth, world.worldHeight + 20);//20 for the compensations, no reasons found
		this.setResizable(false);
		gameview.setWorld(world);
		if(this.animation != null) this.animation.interrupt();
		this.animation = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int count = 0;
				while(true){
					try {
						for(PaintObject obj : world.objects){
							obj.tick(++count);
						}
						world.check.check();
						gameview.repaint();
						
						Thread.sleep(GameFrame.THREAD_SLEEP_DURATION);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		this.animation.run();
	}
	
	public void repaint(){
		this.gameview.repaint();
	}
	
}
