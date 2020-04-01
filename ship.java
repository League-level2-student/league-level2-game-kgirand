import java.awt.Color;
import java.awt.Graphics;

public class ship extends gameO{
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
}
