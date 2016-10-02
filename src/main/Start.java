package main;
import logic.GameController;
import gui.ControlFrame;
import gui.InputDialog;

public class Start {

	public static void main(String[] args){
		InputDialog inputDialog = new InputDialog();
		inputDialog.setVisible(true);
		GameController controller = new GameController();
		controller.setInputDialog(inputDialog);
		ControlFrame frame = new ControlFrame(controller);
		frame.setVisible(true);
		controller.startGame();
		
	}
	
	
}
