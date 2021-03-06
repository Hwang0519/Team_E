import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;



class VeryHardFrame extends Frame implements Runnable {
	public static final int WIDTH = 1000, HEIGHT = 1000;
	private final int INITIAL_ATTACKERS = 220;	
	private final int New_INITIAL_ATTACKERS = 10;
	private long DT = 20;
	private final double AVOIDER_SPEED = 5, ATTACKER_SPEED = 5, NewATTACKER_SPEED = 6;
	private ArrayList<Attacker> attackers;
	private ArrayList<AvoiderPilot> pilots, deads;
	private ArrayList<AttackerNew> pattern;
	private long Time;
	Image buffImg;
	Graphics buffG;
	
	public VeryHardFrame(){
		super("Our Own Dodge");
		initFrame();
	}
	
	public void initFrame(){
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();
				new Main();
			}
		});
	}
	public void initVariables(){
		attackers = new ArrayList<Attacker>();
		pilots = new ArrayList<AvoiderPilot>();
		deads = new ArrayList<AvoiderPilot>();
		pattern = new ArrayList<AttackerNew>();
		// Player
		AvoiderPilotPlayer player = new AvoiderPilotPlayer();
		addKeyListener(player);
		addAvoiderPilot(player);
		
		
	}
	
	private void addAvoiderPilot(AvoiderPilot ap){
		Avoider a = new Avoider(WIDTH/2, HEIGHT/2);
		a.setSpeed(AVOIDER_SPEED);
		ap.setAvoider(a);
		ap.setAttackers(attackers);
		ap.setNewAttackers(pattern);
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
		
		
		
		double WGAP = 4.0*WIDTH/(New_INITIAL_ATTACKERS+4);
		double HGAP = 4.0*HEIGHT/(New_INITIAL_ATTACKERS+4);
		
		long beforeTime = System.nanoTime();
		
		
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
		for(int k=1; k<=New_INITIAL_ATTACKERS/4; k++){
			AttackerNew[] an = new AttackerNew[4];
			an[0] = new AttackerNew(WGAP*i, 0);
			an[1] = new AttackerNew(WGAP*i, HEIGHT);
			an[2] = new AttackerNew(0, HGAP*i);
			an[3] = new AttackerNew(WIDTH, HGAP*i);
			for(AttackerNew p: an) {
				p.setSpeed(NewATTACKER_SPEED);
				p.setDirection(Math.random()*2*Math.PI);
				pattern.add(p);
			}
		}
			
		}
		while(true){
			
			for(AvoiderPilot ap: pilots){
				if(!ap.HardstillAlive()) {
					deads.add(ap);
				}
				if(!ap.NewHardstillAlive()) {
					deads.add(ap);
				}
				
				ap.moveAvoider();
			}
			for(AvoiderPilot ap: deads){
				pilots.remove(ap);
			}
			if(pilots.size()==0) {
				
				if(isActive()) {
				long afterTime = System.nanoTime();
				Time = ((afterTime-beforeTime)/1000000000);

	            JOptionPane.showMessageDialog(this,Time +"?? ?????????????? ");
				break;
				}
			}
			
			for(AttackerNew pt: pattern) pt.moveSelf();    
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
		buffImg=createImage(getWidth(), getHeight());
		buffG=buffImg.getGraphics();
		
		
		
		update(g);
	}
	@Override
	public void update(Graphics g){
		buffG.clearRect(0, 0, WIDTH, HEIGHT);
		buffG.setColor(Color.WHITE);
		buffG.fillRect(0, 0, 0, 0);
		for(AvoiderPilot ap: pilots) {
			ap.drawSelf(buffG);
            buffG.drawString("One Coin ", 800, 50);
		}
		for(Attacker at: attackers) at.drawSelf(buffG);
		for(AttackerNew pt: pattern) pt.drawSelf(buffG);
		g.drawImage(buffImg,0,0,this);
		repaint();
	}
}