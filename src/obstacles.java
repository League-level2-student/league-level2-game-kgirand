import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class obstacles extends gameObjects {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	obstacles(int x, int y, int width, int height){
		super(x,y,width,height);
		speed = 1;
		loadImage("obstacle.jpg");
	}
	public void update() {
		super.update();
		y+=speed;
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}	
	}
	void loadImage(String ImageFile) {
		 if (needImage) {
		        try {
		            image = ImageIO.read(this.getClass().getResourceAsStream(ImageFile));
			    gotImage = true;
		        } catch (Exception e) {
		            
		        }
		        needImage = false;
		    }	
	}
}
