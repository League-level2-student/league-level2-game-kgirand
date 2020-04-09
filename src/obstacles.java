import java.awt.Color;
import java.awt.Graphics;

public class obstacles extends gameObjects {
	obstacles(int x, int y, int width, int height){
		super(x,y,width,height);
		speed = 1;
	}
	public void update() {
		x-=speed;
		super.update();
	}
	void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
		super.draw(g);
	}

}
