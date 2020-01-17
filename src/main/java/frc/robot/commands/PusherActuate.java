/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//Thanks Greg

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class PusherActuate extends Command {
  boolean state;
  public PusherActuate(boolean state) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.state = state;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("pusher actuate " + state);
    if(state){
      Robot.pneumatic.fourthForward();
    }else{
      Robot.pneumatic.fourthReverse();
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(state){
      System.out.println("activate hatch" + state);
      Robot.pneumatic.fourthForward();
    }else{
      Robot.pneumatic.fourthReverse();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
