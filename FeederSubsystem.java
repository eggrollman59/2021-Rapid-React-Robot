package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FeederSubsystem extends SubsystemBase{
    private final PWMSparkMax feederMotor1 = new PWMSparkMax(7);
    private final PWMSparkMax feederMotor2 = new PWMSparkMax(8);
    
    public FeederSubsystem(){
       
    }
    public void setMotors(double speed1, double speed2){
        feederMotor1.set(-speed1);
        feederMotor2.set(speed2);       
    }
    
}
