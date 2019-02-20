
package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.OperateHatchIntake;

public class HatchIntake extends Subsystem {

    VictorSP HATCH_INTAKE_MOTOR;

    private static HatchIntake instance = null;
    
	public HatchIntake() {
        HATCH_INTAKE_MOTOR = new VictorSP(RobotMap.HATCH_INTAKE_MOTOR);
    }

	public static HatchIntake getInstance(){
		if(instance == null)
			instance = new HatchIntake();
		
        return instance;
        

    }



    @Override
    public void initDefaultCommand() {
       setDefaultCommand(new OperateHatchIntake());
    }


    public void runintake(double speed){
        HATCH_INTAKE_MOTOR.set(speed);
        
    }

}
