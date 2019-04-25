package fighting;
import java.awt.*;
import java.awt.event.*;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class game_play implements WindowListener, KeyListener {

	JTextPane ch,gp,hpbar,cd; /* ch=character choose frame, cd=character description frame, 
								hpbar=hpbar frame, gp=real game play frame.*/
	String choose="->";
	String first="Welcome to the JAVA Fighting Game!!\n\n";
	String ng="New game\n";
	String exit="Exit";
	String c_first="Choose your character.\n\n";
	int present;
	int arrow;
	JTextPane fr; //first page frame
	Frame fr_f,c_f,gp_f; // all frame
	String[] command_menu= {"Attack","Guard","Evasion","Heal","Skill"};
	String[] char_menu= {"Beginner\n","Tanker\n","Heavy Dealer\n",
			"Theif\n","Light Dealer\n","Healer\n"};
	String[] descrip={
			"Basic character. All ability is basic. Have no skill\n",
			"Tanker. Have lots of hp, low damage when guard. But have more risk on evasion.\n"
			+ "Special skill : Perfect guard. Can guard all attacks.",
			"Heavy Dealer. Have more risk on attack but more damage.\n "
			+ "Special skill : Guard brake. Can break enemy's guard and make enemy can't use guard.",
			"Theif. Have low hp, low risk on evasion. \n"
			+ "Special skill : Assassination. Even enemy uses guard or evasion, can deal to enemy.",
			"Light Dealer. Have low risk on attack but low damage. \n"
			+ "Special skill : Counter. Can return the damage of enemy's attack.",
			"Healer. All ability is basic.\n"
			+ "Special skill : Heal guard. Can ignore enemy's attack when heal."
	};
	String[] command= {"Attack","Guard","Evasion","Heal","Skill"};
	
	basic_character player;
	basic_character pc;
	
	
	private void first_page(){
		fr=make_frame(fr,300,300);
		StyledDocument doc = fr.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		fr.setText(first+choose+ng+exit);
		fr.addKeyListener(this);
		arrow=0;
		present=0;
		
		fr_f=new_frame(fr_f,350,350);
		fr_f.add("Center",fr);
		
	}
	
	private JTextPane make_frame(JTextPane t, int x, int y) {
		t=new JTextPane();
		t.setPreferredSize(new Dimension(x,y));
		t.setEditable(false);
		t.setForeground(new Color(255,255,255));
		t.setBackground(new Color(0,0,0));
		
		return t;		
	}
	private Frame new_frame(Frame f, int x, int y) {
		f=new Frame();
		f.setSize(x,y);
		f.setTitle("Fighting game");
		f.setVisible(true);
		WindowDestroyer listener = new WindowDestroyer(); 
		f.addWindowListener(listener);
		return f;
	}
	private void character_menu() {
		ch=make_frame(ch,300,500);
		cd=make_frame(cd,400,500);
		
		c_f=new_frame(c_f,750,550);
		c_f.add("West",ch);
		c_f.add("East",cd);	
		ch.setText(c_first+choose);
		for(int i=0;i<6;i++) 
			ch.setText(ch.getText()+char_menu[i]);
		ch.addKeyListener(this);
		arrow=0;
		present=1;
	}
	private void real_play(int choice) {
		int pc_choice;
		
		gp=make_frame(gp,700,450);
		hpbar=make_frame(hpbar,700,100);
		
		gp_f=new_frame(gp_f,750,550);
		gp_f.add("North",hpbar);
		gp_f.add("South",gp);
		
		gp.addKeyListener(this);
		arrow=0;
		present=2;
		
		while(true) {
			pc_choice=(int)(Math.random()*5+1);
			if(pc_choice!=choice)
				break;
		}
		player=make_char(player, choice);
		pc=make_char(pc,pc_choice);
	}
	
	private void fight(int command) {
		//case number 25
		
	}
	
	private basic_character make_char(basic_character result,int c) {
		switch(c) {
		case 0:
			result=new basic_character();
			break;
		case 1:
			result=new tanker();
			break;
		case 2:
			result=new heavy_dealer();
			break;
		case 3:
			result=new thief();
			break;
		case 4:
			result=new light_dealer();
			break;
		case 5:
			result=new healer();
			break;
		}
		return result;
	}
	public void play() {
		first_page();
	}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		int command=e.getKeyCode();
		switch(present) {
		case 0:
			if (command==KeyEvent.VK_UP && arrow==1) {
				fr.setText(first+choose+ng+exit);
				arrow--;
			}
			
			else if(command==KeyEvent.VK_DOWN && arrow==0) {
				fr.setText(first+ng+choose+exit);
				arrow++;
			}
			else if(command==KeyEvent.VK_ENTER) {
				if(arrow==0) {
					fr_f.dispose();
					character_menu();
				}
				else
					System.exit(0);
			}
			break;
		case 1:
			if (command==KeyEvent.VK_UP && arrow>0) {
				arrow--;
				ch.setText(c_first);
				for(int i=0;i<arrow;i++)
					ch.setText(ch.getText()+char_menu[i]);
				ch.setText(ch.getText()+choose);
				for(int i=arrow;i<6;i++)
					ch.setText(ch.getText()+char_menu[i]);
				cd.setText(descrip[arrow]);
			}
			
			else if(command==KeyEvent.VK_DOWN && arrow<5) {
				arrow++;
				ch.setText(c_first);
				for(int i=0;i<arrow;i++)
					ch.setText(ch.getText()+char_menu[i]);
				ch.setText(ch.getText()+choose);
				for(int i=arrow;i<6;i++)
					ch.setText(ch.getText()+char_menu[i]);
				cd.setText(descrip[arrow]);				
			}
			else if(command==KeyEvent.VK_ENTER) {
				real_play(arrow);
				c_f.dispose();
			}
			break;
		case 2:
			if (command==KeyEvent.VK_UP && arrow==1) {
				arrow--;
			}
			
			else if(command==KeyEvent.VK_DOWN && arrow==0) {
				
				arrow++;
			}
			else if(command==KeyEvent.VK_ENTER) {
				
			}
			break;
		}
		
	}
	public void keyReleased(KeyEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {	}

}
