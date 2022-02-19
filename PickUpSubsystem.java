package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PickUpSubsystem extends SubsystemBase {
    private final DoubleSolenoid upperLeftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 5,1);
    private final DoubleSolenoid lowerLeftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,0,6);
    // private final DoubleSolenoid upperRightSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,5,6);
    // private final DoubleSolenoid lowerRightSolenoid = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, 7, 8);
    private final PWMSparkMax m_pickUpMotor = new PWMSparkMax(7);
    
    public PickUpSubsystem(){

    }
    public void setMotor(double speed){
        m_pickUpMotor.set(speed);
    }
    public void deployFoward(){
        upperLeftSolenoid.set(kForward); 
        lowerLeftSolenoid.set(kReverse); 

    }
    public void retract(){
        upperLeftSolenoid.set(kReverse); 
        lowerLeftSolenoid.set(kForward);
    }
    // public void lift(){
    //     upperLeftSolenoid.set(kForward);
    //     upperRightSolenoid.set(kForward);
    // }
    // public void lower(){
    //     upperLeftSolenoid.set(kReverse);
    //     upperRightSolenoid.set(kReverse);
    // }
    // public void stopSolenoid(){
    //     upperLeftSolenoid.set(kOff);
    //     upperRightSolenoid.set(kOff);
    //     lowerLeftSolenoid.set(kOff);
    //     lowerRightSolenoid.set(kOff);
    // }
    
}