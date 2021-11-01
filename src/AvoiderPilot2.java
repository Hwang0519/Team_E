import java.awt.Graphics;
import java.util.ArrayList;

public abstract class AvoiderPilot2 {
	protected Avoider2 avoider2;
	protected ArrayList<Attacker> attackers;
	protected ArrayList<HPItem> Sleep;
	protected ArrayList<AttackerNew> pattern;
	public int hp = 10;
	public AvoiderPilot2(Avoider2 b, ArrayList<Attacker> as, ArrayList<HPItem> ss,ArrayList<AttackerNew> pp ){
		avoider2 = b;
		attackers = as;
		Sleep = ss;
		pattern = pp;
	}
	
	public boolean stillAlive(){
		
		for(Attacker attacker: attackers){
			if(DodgeObject.collide(avoider2, attacker)){
				hp = hp -1;
				if(hp == 0) {
					return false;
				}
			}
				
		}
		return true;
	}
    public boolean event(){
		
		for(HPItem Sleep: Sleep){
			if(DodgeObject.collide(avoider2, Sleep))return false;
				
			}
		    return true;
	}
    public boolean NewstillAlive() {
    	for(AttackerNew pattern: pattern) {
    		if(DodgeObject.collide(avoider2, pattern)) {
    			hp = hp -2;
    			if(hp == 0) {
					return false;
				}
    		}
    	}
    	return true;
	
    }
    public boolean HardstillAlive() {
    	for(Attacker attacker: attackers) {
    		if(DodgeObject.collide(avoider2, attacker)) {
    			hp = 1;
    			hp--;
    			if(hp == 0) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    public boolean NewHardstillAlive() {
    	for(AttackerNew pattern: pattern) {
    		if(DodgeObject.collide(avoider2, pattern)) {
    			hp = 1;
    			hp--;
    			if(hp == 0) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
	public Avoider2 getAvoider(){
		return avoider2;
	}
	
	public void setAvoider(Avoider2 b){
		avoider2 = b;
	}
	public void setAttackers(ArrayList<Attacker> as){
		attackers = as;
	}
	public void setEvent(ArrayList<HPItem> ss){
		Sleep = ss;
	}
	public void setNewAttackers(ArrayList<AttackerNew> pp){
		pattern = pp;
	}
	
	public abstract void moveAvoider();
	public void drawSelf(Graphics g){
		avoider2.drawSelf(g);
	}
}
