package fighting;
import javax.swing.*;

public class basic_character {

	int hp;
	int can_shield=0;
	int heal_chance=2;
	String name;
	
	basic_character(){
		this.hp=200;		
	}
	void attack(int enemy, JTextPane w) {
		w.setText(w.getText()+"hello\n");
		
	}
	void shield(int enemy, JTextPane w) {
		
	}
	void evasive(int enemy, JTextPane w) {
		
	}
	void heal(int enemy, JTextPane w) {
		
	}
	void skill(int enemy, JTextPane w) {
		
	}
}
