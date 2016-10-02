package logic;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.xml.transform.Templates;

import model.WorldFactory;
import gui.ControlFrame.ControlFrameDelegate;
import gui.GameFrame;
import gui.InputDialog;
import gui.InputDialog.InputDialogDelegate;

public class GameController implements ControlFrameDelegate, InputDialogDelegate {

	private InputDialog inputDialog;
	private GameFrame frame;
	
	public InputDialog getInputDialog() {
		return inputDialog;
	}

	public void setInputDialog(InputDialog inputDialog) {
		this.inputDialog = inputDialog;
		inputDialog.setDelegate(this);
	}

	public GameController(){
		frame = new GameFrame(this);
		frame.setVisible(true);
	}

	public void startGame() {
		
		toLevel(1);
	}

	@Override
	public void runProgram() {
		// TODO Auto-generated method stub
		String inputString = inputDialog.getString();
		try {
			didPressEnter(inputString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void didPressEnter(String text) throws Exception {
		// TODO Auto-generated method stub
		StringAnalysis analysis = new StringAnalysis();
		ArrayList<Statement> statements = analysis.analyzeString(text);
		for(Statement statement : statements){
			this.frame.getWorld().evalStatement(statement);
		}
		this.frame.repaint();
		
	}

	@Override
	public boolean isLegal(String text) {
		// TODO Auto-generated method stub
		return Pattern.matches(".+\\..+=.+", text) || Pattern.matches(".+\\..+\\(.*?\\)", text);
	}

	public void toLevel(int level) {
		// TODO Auto-generated method stub
		this.frame.setWorld(WorldFactory.WorldConfiguration(level));
		this.frame.repaint();
	}

	@Override
	public void setFontSize(int size) {
		// TODO Auto-generated method stub
		inputDialog.setTextSize(size);
	}

	
}
