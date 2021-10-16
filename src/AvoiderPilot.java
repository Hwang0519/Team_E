import java.awt.Graphics;
import java.util.ArrayList;

public abstract class AvoiderPilot {
	protected Avoider avoider;
	protected ArrayList<Attacker> attackers;
	
	public AvoiderPilot(Avoider a, ArrayList<Attacker> as){
		avoider = a;
		attackers = as;
	}
	
	public boolean stillAlive(){
		for(Attacker attacker: attackers){
			if(DodgeObject.collide(avoider, attacker)) return false;
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
	public abstract void moveAvoider();
	public void drawSelf(Graphics g){
		avoider.drawSelf(g);
	}
}
