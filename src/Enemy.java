import acm.graphics.GImage;
import acm.graphics.GPoint;

/**
 * @author MeganA
 * This class will account for the functionality of both Enemy types, SHOOTERS and SCOOTERS.
 * Objects of this class have specified movement patters, move projectiles, and take damage. 
 * Objects can access projectile objects and will utilize timers to control all types of its movement.
 */

public class Enemy extends OurEntity {
	
	Enemy(int fD, int life, EntityType eT, GPoint entityLocation) {					// easier to have input be EntityType and location
		super(fD, life, eT);														// based on type, assign fD and life value
		
		switch(eT) {
			case PLAYER:
				break;
			case SCOOTER:
				canShoot = false;
				selectSCOOTER(entityLocation);
				break;
			case SHOOTER:
				selectSHOOTER(entityLocation);
				break;
		}
	}
	
	/**These are the functions called by Enemy constructor every time an enemy is created. Depending on the
	 * type of enemy, this function randomly selects from Enemy Sprites and randomly scales them.
	 */
	
	public void selectSCOOTER(GPoint entityLocation) {
		int min = 7;
	    int max = 12;
	    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	    image = new GImage(IMG_FILENAME_PATH + random_int + "Enemy" + IMG_EXTENSION, 
	    		entityLocation.getX(), entityLocation.getY());
	    int scaleMin = 0;
	    int scaleMax = 2;
	    int scaleRand = (int)Math.floor(Math.random()*(scaleMax-scaleMin+1)+scaleMin);
	    switch(scaleRand) {
	    	case 0:
	    		image.scale(0.25);			// might be too small for the speed
	    		break;
	    	case 1:
	    		image.scale(0.5);
	    		break;
	    	case 2:
	    		image.scale(0.75);
	    		break;
	    }
	}
	
	public void selectSHOOTER(GPoint entityLocation) {
		int min = 1;
	    int max = 6;
	    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	    image = new GImage(IMG_FILENAME_PATH + random_int + "Enemy" + IMG_EXTENSION, 
	    		entityLocation.getX(), entityLocation.getY());
	    int scaleMin = 0;
	    int scaleMax = 2;
	    int scaleRand = (int)Math.floor(Math.random()*(scaleMax-scaleMin+1)+scaleMin);
	    switch(scaleRand) {
	    	case 0:
	    		image.scale(0.5);
	    		break;
	    	case 1:
	    		image.scale(0.75);
	    		break;
	    	case 2:
	    		image.scale(1.15);
	    		break;
	    }
	}
		
	/**This is the function called by level every time the clock ticks. It's going to move the enemy
	 * towards the player, increase curFireDelay by 1 tick, and will even fire a bullet if enough time
	 * has passed.
	 * 
	 * @param player the playerShip that enemies are trying to move/shoot towards
	 */
	public void operateEnemy(float towardsPlayer) {
		curFireTime++;
		
		movePolar(towardsPlayer);
	}
	
	/**This is the move function that Enemy will be using. It mostly just runs through movePolar 
	 * from ourEntity, but this is needed to start the moveTimer for the Enemy's movement cooldown
	 * 
	 * @param angle the angle at which you plan on moving the ship
	 * @return true if the ship moved, otherwise false
	 */
	public void move(float angle) {				// takes in Type to change move rates
		movePolar(angle);
	}

}
