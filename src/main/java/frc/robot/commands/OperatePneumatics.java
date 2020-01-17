// Francis' Super Cool Code
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class OperatePneumatics extends Command {
    public OperatePneumatics() {
        requires(Robot.pneumatic);
    }

// Called just before this Command runs the first time
@Override
protected void initialize() {
    }

// Called repeatedly when this Command is scheduled to run
 @Override
 protected void execute() {

    boolean button_a = Robot.m_oi.getDriveAButton();
    boolean button_b = Robot.m_oi.getDriveBButton();
    boolean button_x = Robot.m_oi.getDriveXButton();
    boolean button_y = Robot.m_oi.getDriveYButton();
    
    // secondary pneumatics (climb)
    int dpadAngle = Robot.m_oi.printDpad();
    
    
   
    
    // Forward and reverse of wristS
    if (button_a) {
        Robot.pneumatic.firstForward();
    }
    else if (button_x) {
        Robot.pneumatic.firstReverse();
    }
    // Forward and reverse of boom
    if (button_b) {
        Robot.pneumatic.secondForward();
    }
    else if (button_y) {
        Robot.pneumatic.secondReverse();
    }

    // Mort function found in robot.oi
    
    //anti-boycott + drop deadclimb

    if (dpadAngle == 180) {
        Robot.pneumatic.thirdForward();
    }
    
 
 }

 public static void pause(){
    Timer.delay(1);
}
 
 // Make this return true when this Command no longer needs to run execute()
 @Override
 protected boolean isFinished() {
    return false;
 }

 // Called once after isFinished returns true
 @Override
 protected void end() {
 }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }


}


