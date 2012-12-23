 import robocode.*;
  
 public class rgod extends AdvancedRobot {
     public void run() {
         while (true) {
             ahead(100);
             turnGunRight(360);
             turnLeft(90);
             back(100);
             turnGunRight(360);
         }
     }
     
     public void onScannedRobot(ScannedRobotEvent e) {
         fire(7);
     }
     
     public void onHitRobot(HitRobotEvent event) {
         if (event.getBearing() > -90 && event.getBearing() <= 90) {
             setBack(100);
         } else {
             setAhead(100);
         }
     }
   
 }
  