import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	int x;
	int y;
	int width = 10;
	int height = 10;
	int speedx;
	int speedy;
	boolean exist;
	Players pl1;
	Players pl2;

	public void spawn(int _x, int _y, int _speedx, int _speedy) {
		
		exist = true;
		
		x = _x;
		y = _y;

		if (new Random().nextBoolean()) {
			speedx = _speedx;
		} else {
			speedx = -_speedx;
		}

		//speedx = _speedx;
		
		if (new Random().nextBoolean()) {
			speedy = _speedy;
		} else {
			speedy = -_speedy;
		}
		
		speedx = speedx/2 + 1;
		speedy = speedy/2 + 1;

	}

	public void setPl(Players _pl1, Players _pl2) {
		pl1 = _pl1;
		pl2 = _pl2;
	}

	public void update() {
		x += speedx;
		y += speedy;

		if (y <= 1 | y >= 440) {
			speedy = -speedy;
		}
		if (x < 50) {
			checkColision(pl1.x, pl1.y, pl1.width, pl1.height, 1);
		} else if (x > 640) {
			checkColision(pl2.x, pl2.y, pl2.width, pl2.height, 0);
		}
		
		if(speedx > 70)
			speedx = 70;
		
		if(speedy > 70)
			speedy = 70;

	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 10, 10);
	}

	public void checkColision(int _x, int _y, int _width, int _height, int i) {
		if (i == 1) {
			if (x <= _x | x + width <= _x + _width) {
				if (y >= _y & y <= _y + _height | y + height >= _y & y + height <= _y + _height) {
					speedx = -speedx;

					if (y <= _y + _height / 2) {

						if (y <= _y + _height / 8) {
						//	System.out.println("1");
							speedy -= 2;
						} else if (y <= _y + _height / 4) {
						//	System.out.println("2");
							speedy -= 1;
						}

					} else {

						if (y >= _y + _height / 2 + _height / 4) {
						//	System.out.println("3");
							speedy += 1;
						}
						if (y >= _y + _height / 2 + _height / 4 + _height / 8) {
						//	System.out.println("4");
							speedy += 1;
						}

					}

				}
			}

		} else {

			if (x >= _x | x + width >= _x + _width) {
				if (y >= _y & y <= _y + _height | y + height >= _y & y + height <= _y + _height) {
					speedx = -speedx;

					if (y <= _y + _height / 2) {

						if (y <= _y + _height / 8) {
						//	System.out.println("1");
							speedy -= 2;
						} else if (y <= _y + _height / 4) {
						//	System.out.println("2");
							speedy -= 1;
						}

					} else {

						if (y >= _y + _height / 2 + _height / 4) {
						//	System.out.println("3");
							speedy += 1;
						}
						if (y >= _y + _height / 2 + _height / 4 + _height / 8) {
						//	System.out.println("4");
							speedy += 1;
						}

					}
					
				}
			}

		}
	}

	public void destroy(){
		
		exist = false;
		x = 100;
		y = -100;
		speedx = 0;
		speedy = 0;
		
	}	
	
}


 