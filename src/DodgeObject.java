import java.awt.Graphics;

public abstract class DodgeObject {
	protected double r, speed;
	protected Vector pos;
	
	public DodgeObject(){
		this(10);
	}
	public DodgeObject(double r){
		this(0, 0, r);
	}
	public DodgeObject(double x, double y){
		this(x, y, 10);
	}
	public DodgeObject(Vector v){
		this(v.getX(), v.getY(), 10);
	}
	public DodgeObject(Vector v, double r){
		this(v.getX(), v.getY(), r);
	}
	public DodgeObject(double x, double y, double r){
		pos = new Vector(x, y);
		setRadius(r);
		speed = 0;
	}
	
	public abstract DodgeObject copy();
	
	public double getX(){
		return pos.getX()-r;
	}
	public double getY(){
		return pos.getY()-r;
	}
	public double getCenterX(){
		return pos.getX();
	}
	public double getCenterY(){
		return pos.getY();
	}
	public Vector getVector(){
		return pos;
	}
	public double getRadius(){
		return r;
	}
	public double getSpeed(){
		return speed;
	}
	public void setX(double x){
		pos.setX(x + r);
	}
	public void setY(double y){
		pos.setY(y + r);
	}
	public void setCenterX(double x){
		pos.setX(x);
	}
	public void setCenterY(double y){
		pos.setY(y);
	}
	public void setVector(Vector v){
		pos.set(v);
	}
	public void setRadius(double r){
		this.r = r;
	}
	public void setSpeed(double s){
		speed =  s;
	}
	
	public void move(double dx, double dy){
		pos.setX(pos.getX()+dx);
		pos.setY(pos.getY()+dy);
	}
	public void move(Vector dv){
		pos.plus(dv);
	}
	public void move(int xdir, int ydir){
		Vector v = new Vector(xdir, ydir);
		v.setSize(speed);
		pos.plus(v);
		if(invalidPos()){
			makeValidPos();
		}
	}
	
	public static double distance(DodgeObject a, DodgeObject b){
		return a.getVector().getMinus(b.getVector()).getSize();
	}
	public static boolean collide(DodgeObject a, DodgeObject b){
		return a.getRadius()+b.getRadius() > distance(a, b);
	}
	abstract public void drawSelf(Graphics g);
	protected boolean invalidPos(){
		return
			pos.getX()<0 || pos.getX()>DodgeFrame.WIDTH
		||	pos.getY()<0 || pos.getY()>DodgeFrame.HEIGHT;
	}
	protected void makeValidPos(){
		if(pos.getX()<0) pos.setX(0);
		else if(pos.getX()>DodgeFrame.WIDTH) pos.setX(DodgeFrame.WIDTH);
		if(pos.getY()<0) pos.setY(0);
		else if(pos.getY()>DodgeFrame.HEIGHT) pos.setY(DodgeFrame.HEIGHT);
	}
}