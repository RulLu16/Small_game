package fighting;

import javax.swing.JTextPane;

public class thief extends basic_character{
	thief(){
		this.hp=150;
		this.max_hp=hp;
		this.name="Thief";
		this.ev_pro=80;
	}
	
	void skill(basic_character enemy, JTextPane w) {
		if(cool_time>0) {
			cool_time--;
			w.setText(w.getText()+"Skill failed.. Have cool time: "+cool_time+" turns.\n");
		}
		else {
			if(enemy.command==3) {
				w.setText(w.getText()+"Special skill: Assassination! Stop the heal and give huge damage.\n");
				int ehp=enemy.get_hp();
				ehp=ehp-enemy.damage-10;
				enemy.set_hp(ehp);
				cool_time=2;
			}
			else if(enemy.command==4 && (enemy.name.equals("Tanker")|| enemy.name.equals("Healer"))) {
				
			}
			else{
				w.setText(w.getText()+"Special skill: Assassination! Avoid opponent's command, give huge damage.\n");
				int ehp=enemy.get_hp();
				ehp=ehp-enemy.damage-10;
				enemy.set_hp(ehp);
				cool_time=2;
			}
		}
	}

}
