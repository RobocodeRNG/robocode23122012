import robocode.*;

public class mischoRobot extends AdvancedRobot {

	public void run(){
		
		
		 while (true) {
             ahead(100);
             turnGunRight(360);
             back(100);
             turnGunRight(360);
         }
    }
  
     public void onScannedRobot(ScannedRobotEvent e) {
         fire(1);
     
     }
	
	
	
}
