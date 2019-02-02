/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class OperateIntake extends Command {
  public OperateIntake() {
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
    
    double engage; 
    // Forward or reverse based on trigger pressed
    if (leftTrigger) {
      engage = -1; // Reverse
    }
    else if (rightTrigger) {
      engage = 1; // fUlL SeNd
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
