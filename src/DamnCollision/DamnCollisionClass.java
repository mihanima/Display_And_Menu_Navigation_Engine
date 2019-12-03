package DamnCollision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Damn.DamnComponent;

public abstract class DamnCollisionClass {

	ArrayList<DamnComponent> collisionObjects = new ArrayList<DamnComponent>();
	
	
	public void addObjectToDamnCollision(DamnComponent _obj){
		
		collisionObjects.add(_obj);
	}
	
	
	public void RemoveObjectToDamnCollision(DamnComponent _obj){
		
		collisionObjects.remove(_obj);
	}
	
	
	public abstract void onCollision(DamnComponent _Active,DamnComponent _Passive,int _LastXBeforeCollision,int _LastYBeforeCollision);
	
	public void checkCollisions(){
		
		for(DamnComponent activeObj : collisionObjects){
			
			if(!activeObj.isActive)
				continue;
			
			for(DamnComponent passiveObj : collisionObjects){
				
				if(passiveObj.equals(activeObj))
					continue;
				
				
				boolean preCollision = false;
				DamnComponent bigObj;
				DamnComponent smallObj;
				
				if(activeObj.area > passiveObj.area){
					
					bigObj = activeObj;
					smallObj = passiveObj;
					
				} else{
					
					bigObj = passiveObj;
					smallObj = activeObj;
					
				}
				
				
				int[][] smallObjApexes = { {smallObj.x , smallObj.y},{smallObj.x + smallObj.width, smallObj.y} ,{smallObj.x , smallObj.y + smallObj.height},{smallObj.x + smallObj.width, smallObj.y + smallObj.height}};
				
				for(int i = 0;i < 4;i++)
					
					if(smallObjApexes[i][0] >= bigObj.x & smallObjApexes[i][0] <= bigObj.x + bigObj.width)
						
						if(smallObjApexes[i][1] >= bigObj.y & smallObjApexes[i][1] <= bigObj.y + bigObj.height){
							
							preCollision = true;
							break;
						}
						
				
				if(!preCollision)
					continue;
				
				Map<String,Boolean> passiveObjHashMap = new HashMap<String,Boolean>();
				
				int[][] passiveObjBorderLinePolygon = passiveObj.textureObject.borderLinePolygon;
				
				for(int i = 0;i < passiveObjBorderLinePolygon.length;i++){
					
					String key = String.valueOf(passiveObjBorderLinePolygon[i][0] + passiveObj.x) + String.valueOf(passiveObjBorderLinePolygon[i][1] + passiveObj.y);
 					
					passiveObjHashMap.put(key,true);
					
				}
				
				
				if(!checkMethod(activeObj,passiveObjHashMap,activeObj.x,activeObj.y))
					continue;
				
				int deltaX = activeObj.x -activeObj.lastX;
				int deltaY = activeObj.y - activeObj.lastY;
				
				boolean xIsBigger = false;
				
				if(deltaY != 0){
					if(deltaX / deltaY >= 1)
						xIsBigger = true;
				}else if(deltaY / deltaX < 1)
					xIsBigger = true;
				
				float testX = activeObj.lastX;
				float testY = activeObj.lastY;
				
				int LastSuccesfullX = activeObj.lastX;
				int LastSuccesfullY = activeObj.lastY;
				

				while(testX != activeObj.x & testY != activeObj.y){
					
					if(checkMethod(activeObj,passiveObjHashMap,(int)(testX),(int)(testY)))
						break;
					
					LastSuccesfullX = (int)(testX);
					LastSuccesfullY = (int)(testY);
					
					if(xIsBigger){
						
						testX++;
						testY+= testY/ testX;
						
					}else{
						
						testY++;
						testX += testX/testY;
						
					}
				}
				
				onCollision(activeObj,passiveObj,LastSuccesfullX,LastSuccesfullY);
				
			}
			
		}
		
	}
	
	private boolean checkMethod(DamnComponent activeObj,Map passiveObjHashMap,int deltaX,int deltaY){
		
		//создаю ассоциативный массив для activeObj а пролистываюсь через passiveObj
		//проверяет обЪекты на каксание,если да,топопикседьно находит последнее месте без каксания 
		
		int[][] activeObjBorderLinePolygon = activeObj.textureObject.borderLinePolygon;
		
		for(int i = 0;i < activeObjBorderLinePolygon.length;i++){
			
			String currientPos = String.valueOf(activeObjBorderLinePolygon[i][0] + deltaX )+ String.valueOf(activeObjBorderLinePolygon[i][1] + deltaY);

			if(passiveObjHashMap.containsKey(currientPos)){
				
				return true;
				
			}
			
		}
		
		
		return false;
	}
	
}

