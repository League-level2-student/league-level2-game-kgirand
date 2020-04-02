import java.awt.event.ActionEvent;
import java.util.Random;

public class objectsManager implements ActionListener {
ship ship;
ArrayList<bullets> bullets = new ArrayList<bullets>;
ArrayList<obstacles> obstacles = new ArrayList<obstacles>;
ArrayList<obstacles> strongerObstacles = new ArrayList<obstacles>;
Random randy = new Random();
int score = 0;
int getScore() {
	return this.score;
}
objects(ship ship) {
	this.ship = ship;
}
void addBullet(bullets object) {
	bullet.add(object);
}
void addObstacle(obstacle object) {
	obstacle.add(new obstacle(randy.nextInt(game.WIDTH),0,20,20));
}
void addStrongerObstacle(strongerObstacle object) {
	StrongerObstacle.add(new StrongerObstacle(randy.nextInt(game.WIDTH),0,20,20));
}
void checkCollision() {
	for(int i = 0;i<bullets.size();i++) {
		if(bullets.get(i).collisionBox.intersects(obstacles.get(i).collisionBox)) {
			hit++;
		}
		if(bullets.get(i).collisionBox.intersects(strongerObstacles.get(i).collisionBox)) {
			hit++;
		}
	}
	for(int j = 1; i<obstacles.size();j++) {
		if(obstacles.get(i).collisionBox.intersects(ship.collisionBox)) {
			currentState++;
		}
	}
	for(int i = 1; i<strongerObstacles.size();i++) {
		if(strongerObstacles.get(i).collisionBox.intersects(ship.collisionBox)) {
			currentState++;
		}
	}
}
void update() {
	for(int i = 1; i<obstacles.size();i++) {
		obstacles.get(i).update();
		if(obstacles.get(i).y>)Game.HEIGHT){
			obstacles.get(i).isActive = false;
		}
	}
	for(int i = 1; i<strongerObstacles.size();i++) {
		strongerObstacles.get(i).update();
		if(strongerObstacles.get(i).y>)Game.HEIGHT){
			strongerObstacles.get(i).isActive = false;
		}
	}
	for(int i = 1; i<bullets.size();i++) {
		bullets.get(i).update();
		if(bullets.get(i).y>Game.HEIGHT) {
			bullets.get(i).isActive = false;
		}
	}
	ship.update();
	checkCollision();
	purgeObjects();
}
void draw(Graphics g) {
	ship.draw(g);
	for(int i = 1; i < obstacles.size();i++) {
		obstacles.get(i).draw(g);
	}
	for(int i = 1; i < strongerObstacles.size(); i++) {
		strongerObstacles.get(i).draw(g);
	}
}
void purgeObjects() {
	for(int i = obstacles.size()-1; i>=0;i--) {
		if(obstacles.get(i).hits>0) {
			obstacles.remove(obstacles.get(i));
		}
	}
	for(int i = strongerObstacles.size()-1; i>=0;i--) {
		if(strongerObstacles.get(i).hits>2) {
			strongerObstacles.remove(strongerObstacles.get(i));
		}
	}
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addObstacles();
	addStrongerObstacles();
}
}

