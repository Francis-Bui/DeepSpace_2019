/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

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

    // Forward and reverse of wrist
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


