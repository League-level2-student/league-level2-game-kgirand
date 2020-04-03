import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gamePanell extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
	final int INSTRUCTIONS = 1;
	final int GAME = 2;
	final int END = 3;
	double currentState = MENU;
	Font title;
	Font smaller;
	Timer obstacleSpawn;
	Timer frameDraw;
	ship ship = new ship(700,200, 10, 10);
	objectManager objectm = new objectManager(ship);
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
	}else if(currentState == INSTRUCTIONS) {
		drawInstructionsState(g);
	}
}
void updateMenuState(){
	
}
void updateInstructionsState() {
	
}
void updateGameState() {
	objectm.update();
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
	g.drawString("dodging and shooting", 100, 100);
	g.setFont(smaller);
	g.drawString("press ENTER to play", 300, 200);
	g.drawString("press SPACE for instructions", 400, 300);
}
void drawInstructionsState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	g.setFont(title);
	g.setColor(Color.YELLOW);
	g.drawString("instructions", 100, 100);
	g.setFont(smaller);
	g.drawString("shoot normal astroids once to destroy", 300, 200);
	g.drawString("shoot astroids on fire 3 times to destroy", 300, 250);
	g.drawString("press space to play", 300, 400);
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
	g.drawString(Integer.toString(objectm.score), 100, 200);
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	g.setFont(title);
	g.setColor(Color.YELLOW);
	g.drawString("GAME OVER", 100, 100);
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
	}else if(currentState == INSTRUCTIONS) {
		updateInstructionsState();
	}
	repaint();
}
void startGame() {
	obstacleSpawn = new Timer(1000/60, objectm);
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
				ship newShip = new ship(100, 200, ship.height, ship.width);
				ship = newShip;
				objectm = new objectManager(newShip);
			}else if(currentState == MENU) {
				startGame();
				currentState = GAME;
			}else {
				currentState++;
			}
		}
		if(currentState == MENU && e.getKeyCode()==KeyEvent.VK_SPACE) {
			currentState+=1;
		}
		if(currentState == INSTRUCTIONS && e.getKeyCode()==KeyEvent.VK_SPACE) {
			currentState+=1;
		}
		if(currentState == GAME && e.getKeyCode()==KeyEvent.VK_SPACE) {
			objectm.addBullet(ship.getBullet());
		}
		if(currentState==2) {
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
