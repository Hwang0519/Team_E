import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Screen extends Canvas implements KeyListener {

	private int x = 0;
	private int y = 0;
	public Car Car[];
	private BufferedImage image;
	private static final long serialVersionUID = 1L;
	
	public Screen() {
		try {
			image = ImageIO.read(new File("src/car.png"));
			Car = new Car[2];
			Car[0] = new Car(0,0);
			Car[1] = new Car(0,50);
			addKeyListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(image, Car[0].x, Car[0].y, this);
		g.drawImage(image, Car[1].x, Car[1].y, this);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int gap = 10;
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			Car[0].y -= gap;
			Car[1].y -= gap;
			break;
		case KeyEvent.VK_DOWN:
			Car[0].y += gap;
			Car[1].y += gap;
			break;
		case KeyEvent.VK_LEFT:
			Car[0].x -= gap;
			Car[1].x -= gap;
			break;
		case KeyEvent.VK_RIGHT:
			Car[0].x += gap;
			Car[1].x += gap;
			break;
		}
		System.out.println(Car[0].x+", "+Car[0].y);
		System.out.println(Car[1].x+", "+Car[1].y);
		repaint();
	}

}
