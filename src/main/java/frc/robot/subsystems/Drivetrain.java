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

  VictorSP FRONT_LEFT_DRIVE_MOTOR, BACK_LEFT_DRIVE_MOTOR, FRONT_RIGHT_DRIVE_MOTOR, BACK_RIGHT_DRIVE_MOTOR;
  SpeedControllerGroup rightDrive;
  SpeedControllerGroup leftDrive;

  public Drivetrain(){
    FRONT_LEFT_DRIVE_MOTOR = new VictorSP(RobotMap.FRONT_LEFT_DRIVE_MOTOR);
    BACK_LEFT_DRIVE_MOTOR = new VictorSP(RobotMap.BACK_LEFT_DRIVE_MOTOR);

    FRONT_RIGHT_DRIVE_MOTOR = new VictorSP(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
    BACK_RIGHT_DRIVE_MOTOR = new VictorSP(RobotMap.BACK_RIGHT_DRIVE_MOTOR);

    //  rightDrive = new SpeedControllerGroup(rightDriveFront, rightDriveBack);
    //  leftDrive = new SpeedControllerGroup(rightDriveFront, leftDriveBack);

  
  }
      

  public void runRightDrive(double output){
    FRONT_RIGHT_DRIVE_MOTOR.set(-output);
    BACK_RIGHT_DRIVE_MOTOR.set(-output);
  }

  public void runLeftDrive(double output){
    FRONT_LEFT_DRIVE_MOTOR.set(output);
    BACK_LEFT_DRIVE_MOTOR.set(output);
  }
  


  @Override
  public void initDefaultCommand() {
     setDefaultCommand(new ArcadeDrive());
  }

  
}
