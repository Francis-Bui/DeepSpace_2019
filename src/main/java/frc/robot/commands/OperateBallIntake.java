//Francis' Super Cool Code

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class OperateBallIntake extends Command {
  public OperateBallIntake() {
    requires(Robot.ballIntake);
  }

  
  private static final float INTAKE_POWER_PERCENT = 0.7f;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    boolean leftTrigger = Robot.m_oi.getDriveLeftTrigger();
    boolean rightTrigger = Robot.m_oi.getDriveRightTrigger();
    boolean backButton = Robot.m_oi.getDriveBackButton();

    double engage; 
    // Forward or reverse based on trigger pressed
    if (leftTrigger) {
      engage = 0.8; // Reverse <-1 for full power shoot
    }
    else if (rightTrigger) {
      engage = -1; // fUlL SeNd
    }
    else if (backButton) {
      engage = 1.142857;
    }
    else {         
      engage = 0; // stop
    }
    Robot.ballIntake.runintake(INTAKE_POWER_PERCENT*engage);
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
