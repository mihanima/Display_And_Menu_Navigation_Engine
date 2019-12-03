import Damn.DamnComponent;
import DamnCollision.DamnCollisionClass;


public class DamnCollisionClassTest extends DamnCollisionClass{

	@Override
	public void onCollision(DamnComponent Active, DamnComponent Passive, int LastXBeforeCollision,int LastYBeforeCollision) {
	
		System.out.println("keeek from DamnCollisionClassTest");
		
		Active.x = LastXBeforeCollision;
		Active.y = LastYBeforeCollision;
		
	}


}
