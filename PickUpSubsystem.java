package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class PickUpSubsystem extends SubsystemBase {
    private final DoubleSolenoid upperLeftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 5,1);
    private final DoubleSolenoid lowerLeftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,0,6);
    // private final DoubleSolenoid upperRightSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,5,6);
    // private final DoubleSolenoid lowerRightSolenoid = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, 7, 8);
    private final PWMSparkMax m_pickUpMotor = new PWMSparkMax(7);
    private TalonSRX intake1= new TalonSRX(31);
    //private TalonSRX intake2= new TalonSRX(32);
    private TalonSRX intake3 = new TalonSRX(33);
    // private Timer time;
    
    public PickUpSubsystem(){

    }
    public void setMotor(double speed){
        m_pickUpMotor.set(speed);
    }
    public void deployFoward(){
        upperLeftSolenoid.set(kForward); 
        lowerLeftSolenoid.set(kReverse); 
        intake1.set(ControlMode.PercentOutput,-50);
        //intake2.set(ControlMode.PercentOutput,50);
        intake3.set(ControlMode.PercentOutput,50);

    }
    public void retract(){
        upperLeftSolenoid.set(kReverse); 
        lowerLeftSolenoid.set(kForward);
    
    }
    public void end(){
        intake1.set(ControlMode.PercentOutput,0);
        //intake2.set(ControlMode.PercentOutput,0);
        intake3.set(ControlMode.PercentOutput,0);
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