import java.awt.Rectangle;

public class gameObjects {
int x;
int y;
int width;
int height;
int speed = 0;
boolean isActive = false; 
Rectangle  collisionBox;
gameObjects(int x, int y, int height, int width){
	this.x = x;
	this.y = y;
	this.height = height;
	this.width = width;
	collisionBox = new Rectangle(x,y,height,width);
}
void update() {
	collisionBox.setBounds(x,y,height,width);
}
}
