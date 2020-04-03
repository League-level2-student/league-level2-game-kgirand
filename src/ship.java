
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ship extends gameObjects{
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;
	ship(int x, int y, int height, int width){
	super(x,y,width,height);
	speed = 15;
	loadImage("ship.jpg");
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
public bullets getBullet() {
	return new bullets(x+width/2,y,10,10);
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
