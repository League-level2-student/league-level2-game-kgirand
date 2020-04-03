import java.awt.image.BufferedImage;

public class bullets extends gameObjects {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	bullets(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
		speed = 10;

	}
	void update() {
		x+=speed;
		super.update();
	}
}
