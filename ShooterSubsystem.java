package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ShooterSubsystem extends SubsystemBase{
    private final PWMSparkMax m_leftShooterMotor = new PWMSparkMax(4);
    private final PWMSparkMax m_rightShooterMotor = new PWMSparkMax(5);
    private final PWMSparkMax m_topShooterMotor = new PWMSparkMax(6);
    public ShooterSubsystem(){
       
    }
    public void setMotors(double lowerSpeed, double upperSpeed){
        m_leftShooterMotor.set(-lowerSpeed);
        m_rightShooterMotor.set(lowerSpeed);
        m_topShooterMotor.set(-upperSpeed);
    }
    

}
