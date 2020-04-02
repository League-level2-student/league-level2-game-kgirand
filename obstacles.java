import java.awt.Color;

import javax.imageio.ImageIO;

public class obstacles extends gameO {
	public static BufferedImage image;
	public static bookeand needImage = true;
	public static boolean gotImage = false;
	obstacles(int x, int y, int width, int height){
		super(x,y,width,height);
		speed = 1;
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
		            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
			    gotImage = true;
		        } catch (Exception e) {
		            
		        }
		        needImage = false;
		    }	
	}
}
