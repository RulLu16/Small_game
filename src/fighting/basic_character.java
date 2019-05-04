package fighting;
import javax.swing.*;

public class basic_character {

	protected int hp;
	protected int can_shield;
	protected int heal_chance;
	String name;
	int command;
	int at_pro;
	protected int gu_pro;
	protected int ev_pro;
	protected int damage; 
	
	basic_character(){
		this.hp=200;	
		this.damage=25;
		this.can_shield=0;
		this.at_pro=80;
		this.heal_chance=2;
		this.gu_pro=90;
		this.ev_pro=70;
	}
	void attack(basic_character enemy, JTextPane w) {
		int succ=(int)(Math.random()*100);
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
	void shield(basic_character enemy, JTextPane w) {
		int g_succ=(int)(Math.random()*100);
		if(enemy.command==0) {
			if(g_succ<gu_pro) {
				w.setText(w.getText()+"Guard success. There's little damage.\n");
				int ehp=enemy.get_hp();
				ehp=ehp-damage+15;
				enemy.set_hp(ehp);
			}
			else {
				int a_succ=(int)(Math.random()*100);
				if(a_succ<enemy.at_pro) {
					w.setText(w.getText()+"Guard failed.. Get original damage.\n");
					int ehp=enemy.get_hp();
					ehp=ehp-damage;
					enemy.set_hp(ehp);
				}
				else
					w.setText(w.getText()+"Guard failed. But attack also failed, there's no damage!\n");
			}
		}
		
	}
	void evasive(basic_character enemy, JTextPane w) {
		int e_succ=(int)(Math.random()*100);
		if(enemy.command==0) {
			if(e_succ<ev_pro) 
				w.setText(w.getText()+"Evasion success! There's no damage.\n");
			else {
				int a_succ=(int)(Math.random()*100);
				if(a_succ<enemy.at_pro) {
					w.setText(w.getText()+"Evasion failed.. Get damage.\n");
					int ehp=enemy.get_hp();
					ehp=ehp-damage;
					enemy.set_hp(ehp);
				}				
				else
					w.setText(w.getText()+"Evasion failed. But attack also failed, there's no damage!\n");
			}
		}
	}
	void heal(basic_character enemy, JTextPane w) {
		if(heal_chance>0) {
			if(enemy.command==0) {
				w.setText(w.getText()+"Heal failed... Heal count down.\n");
				heal_chance--;
			}
			else {
				w.setText(w.getText()+"Heal success!! Hp recovered.\n");
				hp=hp+35;
				heal_chance--;
			}
		}
		else
			w.setText(w.getText()+"There are no heal chance. Heal failed.\n");
	}
	void skill(basic_character enemy, JTextPane w) {
		if(enemy.command==0) {
			w.setText(w.getText()+"Basic character has no skill.. Get damage.\n");
			hp=hp-enemy.damage;
		}
		else
			w.setText(w.getText()+"Basic character has no skill.. Get damage.\n");
	}
	int get_hp() {
		return this.hp;
	}
	void set_hp(int hp) {
		this.hp=hp;
	}
}
