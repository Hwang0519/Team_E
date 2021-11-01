import java.awt.Graphics;
import java.util.ArrayList;

public abstract class AvoiderPilot {
	protected Avoider avoider;
	protected ArrayList<Attacker> attackers;
	protected ArrayList<HPItem> Sleep;
	protected ArrayList<AttackerNew> pattern;
	public int hp = 10;
	public AvoiderPilot(Avoider a, ArrayList<Attacker> as, ArrayList<HPItem> ss,ArrayList<AttackerNew> pp ){
		avoider = a;
		attackers = as;
		Sleep = ss;
		pattern = pp;
	}
	
	public boolean stillAlive(){
		
		for(Attacker attacker: attackers){
			if(DodgeObject.collide(avoider, attacker)){
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
			if(DodgeObject.collide(avoider, Sleep))return false;
				
			}
		    return true;
	}
    public boolean NewstillAlive() {
    	for(AttackerNew pattern: pattern) {
    		if(DodgeObject.collide(avoider, pattern)) {
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
    		if(DodgeObject.collide(avoider, attacker)) {
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
    		if(DodgeObject.collide(avoider, pattern)) {
    			hp = 1;
    			hp--;
    			if(hp == 0) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
	public Avoider getAvoider(){
		return avoider;
	}
	
	public void setAvoider(Avoider a){
		avoider = a;
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
		avoider.drawSelf(g);
	}
}