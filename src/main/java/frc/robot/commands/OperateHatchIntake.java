/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;


public class OperateHatchIntake extends Command {
  public OperateHatchIntake() {
    requires(Robot.hatchIntake);
  }

  
  private static final float HATCH_INTAKE_POWER = 1f;
  private static final float HATCH_INTAKE_TIMEOUT = 2f; // must be > .0020 
  private static final float HATCH_INTAKE_MOVE_DURATION = 1f;
  

// Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(HATCH_INTAKE_TIMEOUT);  // set 2 second timeout
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    boolean leftBumper = Robot.m_oi.getDriveLeftBumper();
    boolean rightBumper = Robot.m_oi.getDriveRightBumper();
    
     
    // Down or Up for the time period of X seconds based on bumper pressed
    if (leftBumper) { // Down
      moveHatchDown();
         
      }
    else if (rightBumper) { // Up   
     moveHatchUp();
 
    }
    else {         
     stopHatch();
    }

  }

  private void moveHatchUp() {
    moveHatch(1);
  }

  private void moveHatchDown() {
    moveHatch(-1);  
  }

  private void stopHatch() {
    moveHatch(0);
  }
  
  private void moveHatch(float speed){
    Timer timer = new Timer();
    timer.start();
    Robot.hatchIntake.runintake(speed*HATCH_INTAKE_POWER);
    while (timer.get() < HATCH_INTAKE_MOVE_DURATION); 
    timer.reset();
    }
  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return  isTimedOut();
    //return false;
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
};



