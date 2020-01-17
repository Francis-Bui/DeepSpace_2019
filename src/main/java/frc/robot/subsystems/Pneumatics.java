//Francis' Super Cool Code
package frc.robot.subsystems;

import frc.robot.commands.OperatePneumatics;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Pneumatics extends Subsystem {
    private static Pneumatics instance = null;
    public static final int COMPRESSOR_PCM_ID = 0;
    public static final int BOOM_FORWARD_CHANNEL_ID = 3;
    public static final int BOOM_REVERSE_CHANNEL_ID = 2;
    public static final int WRIST_FORWARD_CHANNEL_ID = 1;
    public static final int WRIST_REVERSE_CHANNEL_ID = 0;
    public static final int DEAD_FORWARD_CHANNEL_ID = 7; // single button
    public static final int DEAD_REVERSE_CHANNEL_ID = 6;
    public static final int MORT_FORWARD_CHANNEL_ID = 5; // double single
    public static final int MORT_REVERSE_CHANNEL_ID = 4;

    Compressor c = new Compressor(COMPRESSOR_PCM_ID);
    DoubleSolenoid boom = new DoubleSolenoid(COMPRESSOR_PCM_ID, BOOM_FORWARD_CHANNEL_ID, BOOM_REVERSE_CHANNEL_ID);
    DoubleSolenoid wrist = new DoubleSolenoid(COMPRESSOR_PCM_ID, WRIST_FORWARD_CHANNEL_ID, WRIST_REVERSE_CHANNEL_ID);
    DoubleSolenoid dead = new DoubleSolenoid(COMPRESSOR_PCM_ID, DEAD_FORWARD_CHANNEL_ID, DEAD_REVERSE_CHANNEL_ID);
    DoubleSolenoid mort = new DoubleSolenoid(COMPRESSOR_PCM_ID, MORT_FORWARD_CHANNEL_ID, MORT_REVERSE_CHANNEL_ID);
       
      
    // Turns compressor on and off\
    public Pneumatics() { 
    c.setClosedLoopControl(true);
    //c.setClosedLoopControl(false);
    
    }
    

    // Move boom piston forward
    public void firstForward(){
        boom.set(DoubleSolenoid.Value.kForward);
    }
    // Move boom piston reverse
    public void firstReverse(){
        boom.set(DoubleSolenoid.Value.kReverse);
    }
    // boom pistion off
    public void firstOff(){
        boom.set(DoubleSolenoid.Value.kOff);
    }
    // Move wrist piston forward
    public void secondForward(){
        wrist.set(DoubleSolenoid.Value.kForward);
    }
    // Move wrist piston reverse
    public void secondReverse(){
        wrist.set(DoubleSolenoid.Value.kReverse);
    }
    // wrist piston off
    public void secondOff(){
        wrist.set(DoubleSolenoid.Value.kOff);
    }
    // Move dead piston forward
    public void thirdForward(){
        dead.set(DoubleSolenoid.Value.kForward);
    }
    // Move dead piston reverse
    public void thirdReverse(){
        dead.set(DoubleSolenoid.Value.kReverse);
    }
    // dead piston off
    public void thirdOff(){
        dead.set(DoubleSolenoid.Value.kOff);
    }
    // Move dead 2 piston forward
    public void fourthForward(){
        mort.set(DoubleSolenoid.Value.kForward);
    }
    // Move dead 2 piston reverse
    public void fourthReverse(){
        mort.set(DoubleSolenoid.Value.kReverse);
    }
    // dead 2 piston off
    public void fourthOff(){
        mort.set(DoubleSolenoid.Value.kOff);
    }

	public static Pneumatics getInstance(){
		if(instance == null)
			instance = new Pneumatics();
		
		return instance;
    }
    
    @Override
    public void initDefaultCommand() {
       setDefaultCommand(new OperatePneumatics());
    }

}
