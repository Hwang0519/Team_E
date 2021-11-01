import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;



class P2Frame extends Frame implements Runnable {
	public static final int WIDTH = 1000, HEIGHT = 1000;
	private final int INITIAL_ATTACKERS = 220;
	private final int Sleep_Event = 5;
	private long DT = 20;
	private final double AVOIDER_SPEED = 5, ATTACKER_SPEED = 4, SLEEP_SPEED= 4;
	private ArrayList<HPItem> Sleep;
	private ArrayList<Attacker> attackers;
	private ArrayList<AvoiderPilot> pilots, deads;
	private ArrayList<AvoiderPilot2> pilots2, deads2;
	private long Time;
	private long Time2;
	Image buffImg;
	Graphics buffG;
	
	
	public P2Frame(){
		super("Our Own Dodge");
		initFrame();
		
	}
	
	public void initFrame(){
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				dispose();
				new P2mode();
			    
			}
		});
	}
	public void initVariables(){
		attackers = new ArrayList<Attacker>();
		Sleep = new ArrayList<HPItem>();
		pilots = new ArrayList<AvoiderPilot>();
		deads = new ArrayList<AvoiderPilot>();
		pilots2 = new ArrayList<AvoiderPilot2>();
		deads2 = new ArrayList<AvoiderPilot2>();
		// Player
		AvoiderPilotPlayer player = new AvoiderPilotPlayer();
		addKeyListener(player);
		addAvoiderPilot(player);
		
		AvoiderPilotPlayer2 player2 = new AvoiderPilotPlayer2();
		addKeyListener(player2);
		addAvoiderPilot2(player2);
		
	}
	
	private void addAvoiderPilot(AvoiderPilot ap){
		Avoider a = new Avoider(WIDTH/2, HEIGHT/2);
		a.setSpeed(AVOIDER_SPEED);
		ap.setAvoider(a);
		ap.setAttackers(attackers);
		ap.setEvent(Sleep);
		pilots.add(ap);
	}
	private void addAvoiderPilot2(AvoiderPilotPlayer2 tp){
		Avoider2 b = new Avoider2(WIDTH/2, HEIGHT/2);
		b.setSpeed(AVOIDER_SPEED);
		tp.setAvoider(b);
		tp.setAttackers(attackers);
		tp.setEvent(Sleep);
		pilots2.add(tp);
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
				
				
				
				
			}
			for(AvoiderPilot ap: pilots){
				if(!ap.event()) {
					if(ap.hp < 20) {
					ap.hp ++;
					}
				}
				
			}
			for(AvoiderPilot2 tp: pilots2){
				if(!tp.stillAlive()) deads2.add(tp);
				
				tp.moveAvoider();
				
			}
			for(AvoiderPilot2 tp: deads2){
				pilots2.remove(tp);
				
			}
			if(pilots2.size()==0) {
				

			}
			
			for(AvoiderPilot2 tp: pilots2){
				if(!tp.event()) {
					if(tp.hp < 20) {
					tp.hp ++;
					}
				}
				
			}
			if(pilots.size()==0 || pilots2.size()==0) {
				if(isActive()) {
				if(pilots.size()==0 && pilots2.size()>0) {
					JOptionPane.showMessageDialog(this,"P2 铰府");
				}else if(pilots.size()> 0 && pilots2.size() ==0) {
					JOptionPane.showMessageDialog(this,"P1 铰府");
				}else {
					JOptionPane.showMessageDialog(this,"公铰何");
				}
				break;
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
            buffG.drawString("Player P1 HP: "+ap.hp, 800, 50);
		}
		for(AvoiderPilot2 tp: pilots2) {
			tp.drawSelf(buffG);
            buffG.drawString("Player P2 HP: "+tp.hp, 700, 50);
		}
		for(Attacker at: attackers) at.drawSelf(buffG);
		for(HPItem sp: Sleep) sp.drawSelf(buffG);
		g.drawImage(buffImg,0,0,this);
		repaint();
	}
}