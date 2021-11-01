import java.awt.Color;
import java.awt.Graphics;


public class Avoider2 extends DodgeObject{
	private Color color = Color.GREEN;
	
	public Avoider2(double x, double y){
		super(x, y, 6);
	}
	@Override
	public void drawSelf(Graphics g) {
		g.setColor(color);
		g.fillOval((int)getX(), (int)getY(), (int)(getRadius()*2), (int)getRadius()*2);
	}
	@Override
	public DodgeObject copy() {
		Avoider2 b = new Avoider2(0, 0);
		b.setVector(getVector());
		b.setSpeed(getSpeed());
		b.setRadius(getRadius());
		return b;
	}
}
