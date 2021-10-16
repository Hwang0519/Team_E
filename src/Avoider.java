import java.awt.Color;
import java.awt.Graphics;

public class Avoider extends DodgeObject{
	private Color color = Color.RED;
	
	public Avoider(double x, double y){
		super(x, y, 6);
	}
	@Override
	public void drawSelf(Graphics g) {
		g.setColor(color);
		g.fillOval((int)getX(), (int)getY(), (int)(getRadius()*2), (int)getRadius()*2);
	}
	@Override
	public DodgeObject copy() {
		Avoider a = new Avoider(0, 0);
		a.setVector(getVector());
		a.setSpeed(getSpeed());
		a.setRadius(getRadius());
		return a;
	}
}
