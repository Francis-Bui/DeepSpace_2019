package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.OperateBallIntake;


/**
 * Subsystem class for the ball intake
 */
public class BallIntake extends Subsystem {

    VictorSP BALL_INTAKE_MOTOR;

    
	private static BallIntake instance = null;
    
	public BallIntake() {
        BALL_INTAKE_MOTOR = new VictorSP(RobotMap.BALL_INTAKE_MOTOR);
    }

	public static BallIntake getInstance(){
		if(instance == null)
			instance = new BallIntake();
		
		return instance;
	}

	/**
	 * 
	  @param speed 1.0 to -1.0, positive values bring balls into the robot.
	 */

    public void runintake(double speed){
        BALL_INTAKE_MOTOR.set(speed);
        
    }
	

    @Override
    public void initDefaultCommand() {
       setDefaultCommand(new OperateBallIntake());
    }
    public void button() {
        //sets the button int




    }
}
