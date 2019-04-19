package fighting;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.*;

public class first_page extends Frame implements WindowListener, KeyListener{
	String choose="->";
	String first="Welcome to the JAVA Fighting Game!!\n\n";
	String menu="New game\nExit";
	JTextPane fr;
	
	first_page(){
		fr=new JTextPane();
		fr.setPreferredSize(new Dimension(300,300));
		fr.setEditable(false);
		fr.setForeground(new Color(255,255,255));
		fr.setBackground(new Color(0,0,0));
		StyledDocument doc = fr.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		fr.setText(first+choose+menu);
		
		this.setSize(350,350);
		this.add("Center",fr);
		this.setTitle("Fighting game");
		this.setVisible(true);
		WindowDestroyer listener = new WindowDestroyer(); 
		this.addWindowListener(listener);
		
	}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {	}

}
