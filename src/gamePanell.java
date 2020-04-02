import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class gamePanell extends JPanel implements ActionListener, KeyListener{
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
Font title;
Font smaller;
Timer obstacleSpawn;
Timer frameDraw;
ship ship = new ship(700,200, 10, 10);
objectManager object = new objectManager(ship);
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;
gamePanell(){
	title = new Font("Arial", Font.PLAIN, 48);
	smaller= new Font("Arial", Font.PLAIN, 25);
	frameDraw = new Timer(1000/60, this);
	frameDraw.start();
	loadImage("background.jpg");
}
public void paintComponent(Graphics g) {
	if(currentState == MENU) {
		drawMenuState(g);
	}else if(currentState == GAME) {
		drawGameState(g);
	}else if(currentState == END) {
		drawEndState(g);
	}
}
void updateMenuState(){
	
}
void updateGameState() {
	object.update();
	if(ship.isActive == false) {
		currentState++;
	}
}
void updateEndState() {
	
}
void drawMenuState(Graphics g) {
	g.setColor(Color.CYAN);
	g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	g.setFont(title);
	g.setColor(Color.YELLOW);
	g.drawString("dodging and shooting", 100, 23);
	g.setFont(smaller);
	g.drawString("press ENTER to stop", 400, 115);
	g.drawString("press SPACE for instructions", 500, 90);
}
void drawGameState(Graphics g) {
	if(gotImage) {
		g.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
	}else {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	}
	g.setFont(smaller);
	g.setColor(Color.YELLOW);
	g.drawString(Integer.toString(object.score), 100, 200);
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	g.setFont(title);
	g.setColor(Color.YELLOW);
	g.drawString("GAME OVER", 100, 23);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(currentState==MENU) {
		updateMenuState();
	}else if(currentState == GAME) {
		updateGameState();
	}else if(currentState == END) {
		updateEndState();
	}
	repaint();
}
void startGame() {
	obstacleSpawn = new Timer(1000,object);
	obstacleSpawn.start();
}
@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(currentState == END) {
				currentState = MENU;
				ship newShip;
				ship = newShip;
				object = new objectManager(newShip);
			}else if(currentState == MENU) {
				startGame();
				currentState = GAME;
			}else {
				currentState++;
			}
		}
		if(currentState == GAME && e.getKeyCode()==KeyEvent.VK_SPACE) {
			object.addBullet(ship.getBullet());
		}
		if(currentState==1) {
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				ship.up();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				ship.down();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	}
	void loadImage(String imageFile) {
		if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
