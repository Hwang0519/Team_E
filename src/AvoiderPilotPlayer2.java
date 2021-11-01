import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class AvoiderPilotPlayer2 extends AvoiderPilot2 implements KeyListener{
	private Queue2 events2;
	private boolean[] pressed;
	private final int UP=0, DOWN=1, LEFT=2, RIGHT=3;
	private final int 
		K_UP=KeyEvent.VK_W,
		K_DOWN=KeyEvent.VK_S,
		K_LEFT=KeyEvent.VK_A,
		K_RIGHT=KeyEvent.VK_D;
	
	public AvoiderPilotPlayer2(){
		this(null, null, null, null);
	}
	public AvoiderPilotPlayer2(Avoider2 b, ArrayList<Attacker> as, ArrayList<HPItem> ss, ArrayList<AttackerNew> pp) {
		super(b, as, ss,pp);
		events2 = new Queue2(200);
		pressed = new boolean[4];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code){
		case K_UP:
		case K_DOWN:
		case K_LEFT:
		case K_RIGHT:
			events2.push(code);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code){
		case K_UP:
		case K_DOWN:
		case K_LEFT:
		case K_RIGHT:
			events2.push(-code);
		}
	}

	@Override
	public void moveAvoider() {
		int event, xdir=0, ydir=0;
		
		while(!events2.isEmpty()){
			event = events2.pop();
			
			switch(Math.abs(event)){
			case K_UP:
				pressed[UP] = event>0;
				break;
			case K_DOWN:
				pressed[DOWN] = event>0;
				break;
			case K_LEFT:
				pressed[LEFT] = event>0;
				break;
			case K_RIGHT:
				pressed[RIGHT] = event>0;
				break;
			}
		}
		
		if(pressed[UP])		ydir--;
		if(pressed[DOWN])	ydir++;
		if(pressed[LEFT])	xdir--;
		if(pressed[RIGHT])	xdir++;
		
		avoider2.move(xdir, ydir);
	}

}

class Queue2{
	int size, push, pop;
	int[] queue2;
	
	public Queue2(int n) {
		size = n;
		push = 0;
		pop = 0;
		queue2 = new int[n];
	}
	
	public void push(int item) {
		queue2[push] = item;
		push = (push+1)%size;
	}
	public int pop() {
		int r = queue2[pop];
		pop = (pop+1)%size;
		return r;
	}
	public boolean isEmpty() {
		return push == pop;
	}
}

