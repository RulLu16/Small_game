package fighting;

import javax.swing.JTextPane;

public class heavy_dealer extends basic_character{

	heavy_dealer(){
		super();
		this.name="Heavy Dealer";
		this.damage=30;
		this.at_pro=70;
	}
	
	void skill(basic_character enemy, JTextPane w) {
		if(enemy.command==1) {
			w.setText(w.getText()+"Special skill: Guard break! Break guard and disable guard for 2 turs.\n");
			enemy.can_shield=2;
		}
		else
			w.setText(w.getText()+"Special skill: Guard break! But there's no guard, skill failed...\n");
	}

}
