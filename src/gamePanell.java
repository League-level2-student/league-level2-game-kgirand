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
	ship ship = new ship(20,250, 25, 50);
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
	}else if(currentState == INSTRUCTIONS) {
		drawInstructionsState(g);
	}else if(currentState == GAME) {
		drawGameState(g);
	}else if(currentState == END) {
		drawEndState(g);
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
	g.setColor(Color.darkGray);
	g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	g.setFont(title);
	g.setColor(Color.YELLOW);
	g.drawString("shooting game", 100, 100);
	g.setFont(smaller);
	g.drawString("press ENTER to start", 300, 200);
	g.drawString("press SPACE for instructions", 400, 300);
}
void drawInstructionsState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	g.setFont(title);
	g.setColor(Color.YELLOW);
	g.drawString("instructions", 70, 50);
	g.setFont(smaller);
	g.drawString("press SPACE to shoot", 100, 100);
	g.drawString("press the UP and DOWN keys to go up and down", 100, 150);
	g.drawString("shoot small astroids once to destroy", 100, 200);
	g.drawString("shoot big astroids 3 times to destroy", 100, 250);
	g.drawString("everytime you hit a obstacle your score will go up by 1", 100, 300);
	g.drawString("your score will be shown in the top left corner", 100, 350);
	g.drawString("press SPACE to go back to the menu", 100, 450);
}
void drawGameState(Graphics g) {
	if (gotImage) {
		g.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
	} else {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	}
	g.setFont(smaller);
	g.setColor(Color.YELLOW);
	g.drawString(Integer.toString(objectm.score), 10, 25);
	objectm.draw(g);
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
	g.setFont(title);
	g.setColor(Color.YELLOW);
	g.drawString("GAME OVER", 80, 100);
	String score = Integer.toString(objectm.score);
	g.setFont(smaller);
	g.drawString("your score was", 100, 150);
	g.setFont(title);
	g.drawString(score, 200, 200);
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(currentState==MENU) {
		updateMenuState();
	}else if(currentState == INSTRUCTIONS) {
		updateInstructionsState();
	}else if(currentState == GAME) {
		updateGameState();
	}else if(currentState == END) {
		updateEndState();
	}
	repaint();
}
void startGame() {
	obstacleSpawn = new Timer(1000, objectm);
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
				ship newShip = new ship(20, 250, ship.height, ship.width);
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
		}else if(currentState == INSTRUCTIONS && e.getKeyCode()==KeyEvent.VK_SPACE) {
			currentState-=1;
		}else if(currentState == GAME && e.getKeyCode()==KeyEvent.VK_SPACE) {
			objectm.addBullet(ship.getBullet());
			System.out.println("bullet");
		}
		if(currentState==2) {
			if(e.getKeyCode()==KeyEvent.VK_UP && ship.y>0) {
				ship.up();
			}else if(e.getKeyCode()==KeyEvent.VK_DOWN && ship.y<460) {
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
