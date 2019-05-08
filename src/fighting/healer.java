package fighting;

import javax.swing.JTextPane;

public class healer extends basic_character{
	private int heal_guard;
	healer(){
		super();
		heal_guard=2;
		this.name="Healer";
	}
	
	void skill(basic_character enemy, JTextPane w) {
		if(enemy.command==4 && enemy.name.equals("Thief")) {
			if(heal_guard>0) {
				w.setText(w.getText()+"Special Skill: Great heal! Avoid all damage, have great hp recover.\n");
				w.setText(w.getText()+"Special skill: Assassination! But opponent's heal guard avoid damage.. \n");
				enemy.cool_time=2;
				heal_guard--;
				hp=hp+45;
			}
			else {
				w.setText(w.getText()+"Skill failed.. Can only use skill for 2 times.\n");
				w.setText(w.getText()+"Special skill: Assassination! Give huge damage. \n");
				int ehp=enemy.get_hp();
				ehp=ehp-enemy.damage-10;
				enemy.set_hp(ehp);
				cool_time=2;
			}
		}
		else {
			if(heal_guard>0) {
				w.setText(w.getText()+"Special Skill: Great heal! Avoid all damage, have great hp recover.\n");
				heal_guard--;
				hp=hp+45;
			}
			else {
				int succ=(int)(Math.random()*100);
				w.setText(w.getText()+"Skill failed.. Can only use skill for 2 times.\n");
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
