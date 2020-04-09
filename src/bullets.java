import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class bullets extends gameObjects {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	bullets(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
		speed = 10;

	}
	void update() {
		x+=speed;
		super.update();
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 10, 10);
		super.draw(g);
	}
}
