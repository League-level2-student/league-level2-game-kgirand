import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class bullets extends gameObjects {
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
	}
}
