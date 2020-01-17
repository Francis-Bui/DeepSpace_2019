//Francis' Super Cool Code
//UNDER CONSTRUCTION DONT PUSH

package frc.robot.subsystems;
import frc.robot.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GyroFix extends Subsystem {

    public void gyroAngle(){
        //Gyro.getAngle();
      }
    




    private static GyroFix instance = null;

    public static GyroFix getInstance(){
        if(instance == null)
            instance = new GyroFix();
        
        return instance;
    }

    @Override
    public void initDefaultCommand() {
       setDefaultCommand(new ArcadeDrive());
    }


};

















