import java.awt.Color;
import java.awt.Graphics;

import javax.imageio.ImageIO;

public class ship extends gameO{
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;
	ship(int x, int y, height, width){
	super(x,y,height,width)
	speed = 15;
}
void draw(Graphics g) {
	g.setColor(Color.YELLOW);
	g.fillRect(x, y, width, height);
}
void up() {
	y-=speed;
}
void down() {
	y+=speed;
}
public obstacle getObstacle() {
	return new obstacle(x+width/2,y,10,10);
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
