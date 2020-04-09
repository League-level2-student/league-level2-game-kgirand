import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class obstacles extends gameObjects {
	obstacles(int x, int y, int width, int height){
		super(x,y,width,height);
		speed = 1;
	}
	public void update() {
		super.update();
		x+=speed;
	}
	void draw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
	}

}
