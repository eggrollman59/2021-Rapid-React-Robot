// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final PWMSparkMax m_leftFrontMotor = new PWMSparkMax(0);
  private final PWMSparkMax m_leftRearMotor = new PWMSparkMax(1);
  private final MotorControllerGroup m_leftMotor = new MotorControllerGroup(m_leftFrontMotor, m_leftRearMotor);

  private final PWMSparkMax m_rightFrontMotor = new PWMSparkMax(2);
  private final PWMSparkMax m_rightRearMotor = new PWMSparkMax(3);
  private final MotorControllerGroup m_rightMotor = new MotorControllerGroup(m_rightFrontMotor, m_rightRearMotor);

 // private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  
  

  
  public DriveSubsystem() {
    
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Drive value", m_rightMotor.get());
  }
  public void setMotors(double leftSpeed, double rightSpeed){
    m_rightMotor.set(rightSpeed);
    m_leftMotor.set(-leftSpeed);
  }

 
}
