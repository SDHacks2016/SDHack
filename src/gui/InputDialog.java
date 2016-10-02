package gui;
/**
 *
 * @author Chutong
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class InputDialog extends JFrame implements ActionListener
{   
    public interface InputDialogDelegate
    { 
        public void didPressEnter(String text) throws Exception;
        public boolean isLegal(String text);
    }	
    private JTextField textField;
    private JTextArea text;
    private String input;
    private JPanel MyPanel = new JPanel(); 
    private final static String enter = "\n";
    private BorderLayout borderLayout1 = new BorderLayout();
    
    private InputDialogDelegate delegate;
    
    public void setDelegate(InputDialogDelegate delegate) {
		this.delegate = delegate;
	}
    
    public void setTextSize(int size){
    	Font font = text.getFont();
    	
    	textField.setFont(font.deriveFont((float)size));
    	text.setFont(font.deriveFont((float)size));
    }
    
    public InputDialog()
    {
        textField = new JTextField(25);
        text = new JTextArea(10,25);
        text.setEditable(false);
        textField.addActionListener(this);
        MyPanel = (JPanel) getContentPane();
        JScrollPane scrollPane = new JScrollPane(text);
        MyPanel.add(scrollPane, java.awt.BorderLayout.CENTER);
        MyPanel.add(textField, java.awt.BorderLayout.SOUTH);
        MyPanel.setBackground(Color.WHITE);
        input = text.getText();
        setTitle("Input");
        setLocation(200,200);
        setSize(new Dimension(200,200));
        setVisible(true);
        setResizable(true);
    }
    public void actionPerformed(ActionEvent evt) 
    {
        String text1 = textField.getText();
        if(delegate.isLegal(text1))
        {
            
            if(delegate != null)
            {
        	try {
				delegate.didPressEnter(text1);
				input = text1;
            text.append(text1 + enter);
            textField.selectAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				text.append("Runtime Error" + enter);

				textField.selectAll();
			}
            }
        } else {
        	text.append("Check Syntax" + enter);
            textField.selectAll();
        }
    }
    public String getString()
    {
        return input;
    }
}
