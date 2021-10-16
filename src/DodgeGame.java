import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DodgeGame {
	public static void main(String[] args) {
		DodgeFrame frame = new DodgeFrame();
		Thread thread = new Thread(frame);
		thread.start();
	}
}

class DodgeFrame extends Frame implements Runnable {
	public static final int WIDTH = 800, HEIGHT = 800;
	private final int INITIAL_ATTACKERS = 220;
	private final long DT = 20;
	private final double AVOIDER_SPEED = 4, ATTACKER_SPEED = 3;
	private ArrayList<Attacker> attackers;
	private ArrayList<AvoiderPilot> pilots, deads;
	Image buffImg;
	Graphics buffG;
	
	public DodgeFrame(){
		super("Our Own Dodge");
		initFrame();
	}
	
	public void initFrame(){
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();
				System.exit(0);
			}
		});
	}
	public void initVariables(){
		attackers = new ArrayList<Attacker>();
		pilots = new ArrayList<AvoiderPilot>();
		deads = new ArrayList<AvoiderPilot>();
		
		// Player
		AvoiderPilotPlayer player = new AvoiderPilotPlayer();
		addKeyListener(player);
		addAvoiderPilot(player);
		
		// AI
		//addAvoiderPilot(new AISsolabingbong());
		//addAvoiderPilot(new AIdobi());
		
	}
	
	private void addAvoiderPilot(AvoiderPilot ap){
		Avoider a = new Avoider(WIDTH/2, HEIGHT/2);
		a.setSpeed(AVOIDER_SPEED);
		ap.setAvoider(a);
		ap.setAttackers(attackers);
		pilots.add(ap);
	}
	
	public void run(){
		while(true){
			initVariables();
			runGame();
		}
	}
	
	private void runGame(){
		double wgap = 4.0*WIDTH/(INITIAL_ATTACKERS+4);
		double hgap = 4.0*HEIGHT/(INITIAL_ATTACKERS+4);
		
		for(int i=1;i<=INITIAL_ATTACKERS/4;i++){
			Attacker[] as = new Attacker[4];
			as[0] = new Attacker(wgap*i, 0);
			as[1] = new Attacker(wgap*i, HEIGHT);
			as[2] = new Attacker(0, hgap*i);
			as[3] = new Attacker(WIDTH, hgap*i);
			for(Attacker a: as){
				a.setSpeed(ATTACKER_SPEED);
				a.setDirection(Math.random()*2*Math.PI);
				attackers.add(a);
			}
		}
		while(true){
			for(AvoiderPilot ap: pilots){
				if(!ap.stillAlive()) deads.add(ap);
				ap.moveAvoider();
			}
			for(AvoiderPilot ap: deads){
				pilots.remove(ap);
			}
			if(pilots.size()==0) break;
			for(Attacker at: attackers) at.moveSelf();
			
			repaint();
			try{
				Thread.sleep(DT);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	@Override
	public void paint(Graphics g){
		buffImg=createImage( WIDTH, HEIGHT);
		buffG=buffImg.getGraphics();
		update(g);
	}
	@Override
	public void update(Graphics g){
		buffG.clearRect(0, 0,  WIDTH, HEIGHT);
		buffG.setColor(Color.WHITE);
		buffG.fillRect(0, 0, WIDTH, HEIGHT);
		for(AvoiderPilot ap: pilots) ap.drawSelf(buffG);
		for(Attacker at: attackers) at.drawSelf(buffG);
		g.drawImage(buffImg,0,0,this);
		repaint();
	}
}