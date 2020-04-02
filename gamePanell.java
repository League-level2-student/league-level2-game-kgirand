import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JPanel;

public class gamePanell extends JPanel implements ActionListener, KeyListener{
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
Font title;
Font smaller;
Timer obstacleSpawn;
Timer frameDraw
ship ship = new ship(700,200,50,50);
objects object = new objects(ship);
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;
GamePanel(){
	titleFont = new Font("Arial", Font.PLAIN, 48);
	smallerF = new Font("Arial", Font.PLAIN, 25);
	frameDraw = new Timer(1000/60, this);
	frameDraw.start();
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
	objects.update();
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
