package fighting;

import javax.swing.JTextPane;

public class light_dealer extends basic_character{
	light_dealer(){
		super();
		this.name="Light Dealer";
		this.damage=20;
		this.at_pro=90;
	}
	
	void skill(basic_character enemy, JTextPane w) {
		if(enemy.command==0) {
			w.setText(w.getText()+"Special skill: Counter! Give back greak damage.\n");
			int ehp=enemy.get_hp();
			ehp=ehp-enemy.damage-10;
			enemy.set_hp(ehp);
		}
		else
			w.setText(w.getText()+"Special skill: Counter! But there's no attack, skill failed...\n");
	}

}
