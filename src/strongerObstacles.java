import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

	public class strongerObstacles extends gameObjects {
		public static BufferedImage image;
		public static boolean needImage = true;
		public static boolean gotImage = false;
		strongerObstacles(int x, int y, int width, int height){
			super(x,y,width,height);
			speed = 1;
			loadImage("o.png");
		}
		public void update() {
			x-=speed;
			super.update();
		}
		void draw(Graphics g) {
			if (gotImage) {
				g.drawImage(image, x, y, width, height, null);
			} else {
				g.setColor(Color.RED);
				g.fillRect(x, y, 20, 20);
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

