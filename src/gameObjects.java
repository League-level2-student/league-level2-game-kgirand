import java.awt.Rectangle;

public class gameObjects {
int x;
int y;
int width;
int height;
int speed = 0;
boolean isActive = true; 
int hits = 0;
Rectangle  collisionBox;
gameObjects(int x, int y, int width, int height){
	this.x = x;
	this.y = y;
	this.height = height;
	this.width = width;
	collisionBox = new Rectangle(x,y,width,height);
}
void update() {
	collisionBox.setBounds(x,y,width,height);
}
}
