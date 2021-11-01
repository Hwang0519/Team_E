import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;



class NomalFrame extends Frame implements Runnable {
	public static final int WIDTH = 1000, HEIGHT = 1000;
	private final int INITIAL_ATTACKERS = 220;
	private final int Sleep_Event = 5;
	private long DT = 20;
	private final double AVOIDER_SPEED = 5, ATTACKER_SPEED = 4, SLEEP_SPEED= 4;
	private ArrayList<HPItem> Sleep;
	private ArrayList<Attacker> attackers;
	private ArrayList<AvoiderPilot> pilots, deads;
	private long Time;
	Image buffImg;
	Graphics buffG;
	
	
	public NomalFrame(){
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
		Sleep = new ArrayList<HPItem>();
		pilots = new ArrayList<AvoiderPilot>();
		deads = new ArrayList<AvoiderPilot>();
		
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
		ap.setEvent(Sleep);
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
		
		double Wgap = 4.0*WIDTH/(Sleep_Event+4);
		double Hgap = 4.0*HEIGHT/(Sleep_Event+4);
		
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
		for(int j=1;j<=Sleep_Event/4;j++) {
			HPItem[] sp = new HPItem[4];
			sp[0] = new HPItem(Wgap*j, 0);
			sp[1] = new HPItem(Wgap*j, HEIGHT);
			sp[2] = new HPItem(0, Hgap*j);
			sp[3] = new HPItem(WIDTH, Hgap*j);
			for(HPItem s: sp) {
				s.setSpeed(SLEEP_SPEED);
				s.setDirection(100);
				Sleep.add(s);
			}
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
			if(pilots.size()==0) {
				
				if(isActive()) {
				long afterTime = System.nanoTime();
				Time = ((afterTime-beforeTime)/1000000000);

	            JOptionPane.showMessageDialog(this,Time +"초 생존하였습니다 ");
				break;
				}
			}
			for(AvoiderPilot ap: pilots){
				if(!ap.event()) {
					if(ap.hp < 20) {
					ap.hp ++;
					}
				}
				
			}
			
			   
			for(Attacker at: attackers) at.moveSelf();
			for(HPItem sp : Sleep) {
				sp.moveSelf();
			}
			
			
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
            buffG.drawString("Player HP : "+ap.hp, 800, 50);
		}
		for(Attacker at: attackers) at.drawSelf(buffG);
		for(HPItem sp: Sleep) sp.drawSelf(buffG);
		g.drawImage(buffImg,0,0,this);
		repaint();
	}
}