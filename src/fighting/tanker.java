package fighting;

import javax.swing.JTextPane;

public class tanker extends basic_character{
	private int ab_guard;
	tanker(){
		this.hp=270;
		this.max_hp=hp;
		this.name="Tanker";
		ab_guard=5;
		this.gu_pro=95;
	}
	
	void skill(basic_character enemy, JTextPane w) {
		if(enemy.command==4 && enemy.name.equals("Thief") && enemy.cool_time==0) {
			if(ab_guard>0) {
				w.setText(w.getText()+"Special Skill: Absolute guard! Guard all damage.\n");
				w.setText(w.getText()+"Special skill: Assassination! But opponent's absolute guard avoid damage.. \n");
				enemy.cool_time=2;
				ab_guard--;
				hp=hp+45;
			}
			else {
				w.setText(w.getText()+"Skill failed.. Can only use skill for 5 times.\n");
				w.setText(w.getText()+"Special skill: Assassination! Give huge damage. \n");
				int ehp=enemy.get_hp();
				ehp=ehp-enemy.damage-10;
				enemy.set_hp(ehp);
				enemy.cool_time=2;
			}
		}
		else {
			if(ab_guard>0) {
				w.setText(w.getText()+"Special Skill: Absolute guard! Guard all damage.\n");
				ab_guard--;
			}
			else {
				int succ=(int)(Math.random()*100);
				w.setText(w.getText()+"Skill failed.. Can only use skill for 5 times.\n");
				if(enemy.command==0) {
					if(succ<at_pro) {
						w.setText(w.getText()+"Attack success. Give some damage.\n");
						int ehp=enemy.get_hp();
						ehp=ehp-damage;
						enemy.set_hp(ehp);
					}
					else
						w.setText(w.getText()+"Attack failed. There's no damage.\n");
				}
			}
		}
	}

}
