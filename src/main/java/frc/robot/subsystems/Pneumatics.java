package frc.robot.subsystems;

import frc.robot.commands.OperatePneumatics;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Pneumatics extends Subsystem {
    private static Pneumatics instance = null;
    
    Compressor c = new Compressor(0);
    DoubleSolenoid boom = new DoubleSolenoid(1, 2);
    DoubleSolenoid wrist = new DoubleSolenoid(3, 4);

    // Turns compressor on
	public Pneumatics() {
        c.setClosedLoopControl(true);

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
