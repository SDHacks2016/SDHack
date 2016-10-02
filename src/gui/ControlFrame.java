package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlFrame extends JFrame {

	public interface ControlFrameDelegate{
		public void runProgram();
		public void setFontSize(int size);
	}
	
	public int fontSize = 14;
	
	public ControlFrame(ControlFrameDelegate delegate){
		JPanel myPanel = new JPanel();
		add(myPanel);
		JButton run = new JButton("Run");
		myPanel.setLayout(new GridLayout(10, 1));
		myPanel.add(run);
		
		JButton addFontSize = new JButton("+");
		addFontSize.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delegate.setFontSize(++fontSize);
			}
		});
		myPanel.add(addFontSize);
		
		JButton decreaseFontSize = new JButton("-");
		decreaseFontSize.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				delegate.setFontSize(--fontSize);
				
			}
		});
		myPanel.add(decreaseFontSize);
		
		run.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				delegate.runProgram();
			}
		});
		this.setSize(100,300);
	}
}
