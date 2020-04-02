import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game {
JFrame frame;
GamePanel gp;
public static int HEIGHT;
public static int  WIDTH;
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;
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
