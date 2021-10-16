
public class Vector {
	private double x, y;
	
	public Vector(){
		this(0, 0);
	}
	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}
	public Vector copy(){
		return new Vector(x, y);
	}
	
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void set(Vector v){
		x = v.x;
		y = v.y;
	}
	
	public void setSize(double size){
		double org, rate;
		
		org = getSize();
		if(org==0) return;
		rate = size/org;
		
		x *= rate;
		y *= rate;
	}
	public double getSize(){
		return Math.sqrt(x*x+y*y);
	}
	public void setAngle(double a){
		double size = getSize();
		x = size*Math.cos(a);
		y = size*Math.sin(a);
	}
	public double getAngle(){
		return Math.atan2(y, x);
	}
	
	public void plus(Vector v){
		x += v.x;
		y += v.y;
	}
	public Vector getPlus(Vector v){
		return new Vector(x+v.x, y+v.y);
	}
	public void minus(Vector v){
		x -= v.x;
		y -= v.y;
	}
	public Vector getMinus(Vector v){
		return new Vector(x-v.x, y-v.y);
	}
	public void times(double d){
		x += d;
		y += d;
	}
	public Vector getTimes(double d){
		return new Vector(x*d, y*d);
	}
	public void flopX(){
		x *= -1;
	}
	public Vector getFlopX(){
		return new Vector(-x, y);
	}
	public void flopY(){
		y *= -1;
	}
	public Vector getFlopY(){
		return new Vector(x, -y);
	}
	
	public void matchDirection(Vector v){
		set(getMatchDirection(v));
	}
	public Vector getMatchDirection(Vector tv){
		Vector v = tv.copy();
		v.setSize(getSize());
		return v;
	}
}
