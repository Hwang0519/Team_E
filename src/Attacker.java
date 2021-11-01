import java.awt.Color;
import java.awt.Graphics;

public class Attacker extends DodgeObject{
	private Color color = Color.CYAN;
	private Vector velocity;
	
	public Attacker(double x, double y){
		super(x, y, 5);
		velocity = new Vector(1, 0);
	}
	
	public void setDirection(double angle){
		velocity.setSize(speed);
		velocity.setAngle(angle);
	}
	public void moveSelf(){
		pos.plus(velocity);
		if(pos.getX()<0 || pos.getX()>1000){
			velocity.flopX();
			pos.plus(new Vector(velocity.getX()*2, 0));
		}
		if(pos.getY()<0 || pos.getY()>1000){
			velocity.flopY();
			pos.plus(new Vector(0, velocity.getY()*2));
		}
	}
	
	protected boolean invalidPos(){
		return false;
	}
	
	@Override
	public void drawSelf(Graphics g) {
		g.setColor(color);
		g.fillOval((int)getX(), (int)getY(), (int)(getRadius()*2), (int)(getRadius()*2));
	}

	@Override
	public DodgeObject copy() {
		Attacker a = new Attacker(0, 0);
		a.setVector(getVector());
		a.setSpeed(getSpeed());
		a.setRadius(getRadius());
		a.setDirection(this.velocity.getAngle());
		return a;
	}
}
