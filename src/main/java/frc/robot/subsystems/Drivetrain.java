/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;


public class Drivetrain extends Subsystem {

  VictorSP leftDriveFront,leftDriveBack, rightDriveFront, rightDriveBack;
  SpeedControllerGroup rightDrive;
  SpeedControllerGroup leftDrive;

  public Drivetrain(){
    leftDriveFront = new VictorSP(RobotMap.leftDriveFront);
    leftDriveBack = new VictorSP(RobotMap.leftDriveBack);

    rightDriveFront = new VictorSP(RobotMap.rightDriveFront);
    rightDriveBack = new VictorSP(RobotMap.rightDriveBack);

    //  rightDrive = new SpeedControllerGroup(rightDriveFront, rightDriveBack);
    //  leftDrive = new SpeedControllerGroup(rightDriveFront, leftDriveBack);

  
  }
      

  public void runRightDrive(double output){
    rightDriveFront.set(-output);
    rightDriveBack.set(-output);
  }

  public void runLeftDrive(double output){
    leftDriveFront.set(output);
    leftDriveBack.set(output);
  }
  


  @Override
  public void initDefaultCommand() {
     setDefaultCommand(new ArcadeDrive());
  }

  
}
