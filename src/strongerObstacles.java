import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

	public class strongerObstacles extends gameObjects {
		strongerObstacles(int x, int y, int width, int height){
			super(x,y,width,height);
			speed = 1;
		}
		public void update() {
			x-=speed;
			super.update();
		}
		void draw(Graphics g) {
			g.setColor(Color.RED);
			g.fillRect(x, y, 20, 20);
			super.draw(g);
		}

	}

