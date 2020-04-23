import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class objectManager implements ActionListener {
	ship ship;
	ArrayList<bullets> bullets = new ArrayList<bullets>();
	ArrayList<obstacles> obstacles = new ArrayList<obstacles>();
	ArrayList<obstacles> strongerObstacles = new ArrayList<obstacles>();
	Random randy = new Random();
	public int health = 0;
	public int getHealth() {
		return this.health;
	}
	public int score = 0;
	public int getScore() {
		return this.score;
	}
	objectManager(ship ship) {
		this.ship = ship;
	}

	public void addBullet(bullets object) {
		bullets.add(object);
		System.out.println("bullets" + bullets.size());
	}
	void addObstacle() {
		obstacles.add(new obstacles(800, randy.nextInt(Game.WIDTH), 20, 20));
	}

	void addStrongerObstacle() {
		strongerObstacles.add(new obstacles(800, randy.nextInt(Game.WIDTH), 40, 40));
	}

	void checkCollision() {
		for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < obstacles.size(); j++) {
				if (bullets.get(i).collisionBox.intersects(obstacles.get(j).collisionBox)) {
					obstacles.get(j).hits++;
					bullets.get(i).isActive = false;
					score ++;
				}
			}
			for (int j = 0; j < strongerObstacles.size(); j++) {
				if (bullets.get(i).collisionBox.intersects(strongerObstacles.get(j).collisionBox)) {
					strongerObstacles.get(j).hits++;
					bullets.get(i).isActive = false;
					score ++;
				}
			}
		}
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).collisionBox.intersects(ship.collisionBox)) {
				ship.isActive = false;
			}
		}
		for (int i = 0; i < strongerObstacles.size(); i++) {
			if (strongerObstacles.get(i).collisionBox.intersects(ship.collisionBox)) {
				ship.isActive = false;
			}
		}
	
	}

	void update() {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
			if (obstacles.get(i).y > Game.HEIGHT) {
				obstacles.remove(i);
				i--;
			}
			else if(obstacles.get(i).x<0) {
				obstacles.remove(i);
				i--;
				System.out.println("ox");
				health ++;
			}
		}
		for (int i = 0; i < strongerObstacles.size(); i++) {
			strongerObstacles.get(i).update();
			if (strongerObstacles.get(i).y > Game.HEIGHT) {
				strongerObstacles.remove(i);
				i--;
			}
			else if(strongerObstacles.get(i).x<0) {
				strongerObstacles.remove(i);
				i --;
				health ++;
			}
		}
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).update();
			if (bullets.get(i).y > Game.HEIGHT) {
				bullets.get(i).isActive = false;
			}
		}
		ship.update();
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		ship.draw(g);
		for(int i = 0; i<bullets.size();i++) {
			bullets.get(i).draw(g);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
		for (int i = 0; i < strongerObstacles.size(); i++) {
			strongerObstacles.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = obstacles.size() - 1; i >= 0; i--) {
			if (obstacles.get(i).hits > 0) {
				obstacles.remove(obstacles.get(i));
			}
		}
		for (int i = strongerObstacles.size() - 1; i >= 0; i--) {
			if (strongerObstacles.get(i).hits > 2) {
				strongerObstacles.remove(i);
			}
		}
		for(int i = 0; i<bullets.size();i++) {
			if(!bullets.get(i).isActive) {
				bullets.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addObstacle();
		addStrongerObstacle();
	}
}
