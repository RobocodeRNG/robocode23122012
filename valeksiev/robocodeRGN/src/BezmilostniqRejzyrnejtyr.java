import robocode.*;
import java.awt.Color;
public class BezmilostniqRejzyrnejtyr extends AdvancedRobot {
    static double prevEnergy=100.0;
    double gunTurnAmt;
    String trackName;

    @Override
    public void run() {

        /*
         * Set Colors of the Robot: Body, Gun, Radar
         */    	
        setColors(Color.blue,Color.orange,Color.green);
        setBulletColor(Color.green);
        setScanColor(Color.yellow);
        trackName = null;                    // Initialize to not tracking anyone
        setAdjustGunForRobotTurn(true);
        gunTurnAmt = 10;

        while (true) {

            setTurnGunRight(gunTurnAmt);
            execute();
        }
    }

    /**
     *onScannedRobot
     */
    @Override
    public void onScannedRobot(ScannedRobotEvent e) {
        if(100-prevEnergy>=1 && 100-prevEnergy>=3){
            setTurnRight(90);
            setAhead(20);
        }
        if (trackName != null && !e.getName().equals(trackName))
            return;

        if (trackName == null) {
            trackName = e.getName();
        }

        if (e.getDistance() > 150)
        {
            gunTurnAmt = normalRelativeAngle(e.getBearing() + (getHeading() - getRadarHeading()));

            setTurnGunRight(gunTurnAmt);
            setTurnRight(e.getBearing());

            setAhead(e.getDistance() - 140);
            if(e.getDistance()>50){
                fire(1);
            }

            else{
                fire(3);
            }
            prevEnergy=e.getEnergy();
            return;
        }


        gunTurnAmt = normalRelativeAngle(e.getBearing() + (getHeading() - getRadarHeading()));
        setTurnGunRight(gunTurnAmt);
        setFire(3);
        scan();

    }


    /**
     * onWin:  Do a victory dance
     */

    @Override
    public void onWin(WinEvent e) {

        /*
         * Set Colors of the Robot: Body, Gun, Radar
         */
        setColors(Color.red,Color.red,Color.red);

        for (int i = 0; i < 150; i++)
        {
            turnRight(30);
            turnLeft(30);
        }
    }

    /**
     * normalRelativeAngle:  returns angle such that -180<angle<=180
     */

    public double normalRelativeAngle(double angle) {
        if (angle > -180 && angle <= 180)
            return angle;
        double fixedAngle = angle;
        while (fixedAngle <= -180) {
            fixedAngle += 360;
        }
        while (fixedAngle > 180) {
            fixedAngle -= 360;
        }
        return fixedAngle;
    }

}
