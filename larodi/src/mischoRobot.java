import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.*;

public class mischoRobot extends AdvancedRobot {

	public void run(){
		
		
		 while (true) {
             ahead(100);
             turnGunRight(10);
             //back(100);
             turnGunRight(20);
         }
    }
  
     public void onScannedRobot(ScannedRobotEvent e) {
    	 if (event.getDistance() < 100) {
             fire(3);
         } else {
             fire(1);
         }
     
     }
	
	
	
}
