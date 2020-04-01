import javax.swing.JFrame;

public class Game {
JFrame frame;
GamePanel gp;
public static int HEIGHT;
public static int  WEIGHT;

Game(){
	frame = new JFrame();
	gp = new GamePanel();
}
void setup() {
	frame.add(gp);
	frame.addKeyListener(gp);
	HEIGHT = 500;
	WIDTH = 800;
	frame.setSize(HEIGHT, WIDTH);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args) {
	Game game = new Game();
	game.setup();
}
}
