/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleBoolean {

  private boolean toggle = false; 
  private boolean waited = true; 
  private double waitTime = 0;

  Timer timer = new Timer();

  public ToggleBoolean() {
    waitTime = 0.5; 
  }
  public ToggleBoolean(double waitTime){
    this.waitTime = waitTime; 
    timer.start(); 
  }

  public void set(boolean state){
    if(timer.get()>waitTime){
      toggle = !toggle; 
    }
    if(timer.get()>waitTime){
      timer.reset();
      timer.start();
    }
  }

  public boolean get(){
    return toggle; 
  }
}
