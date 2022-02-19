// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.AutoShooterCmd;
import frc.robot.commands.PickUpCmd;
//import frc.robot.commands.DriveReverseCmd;
//import frc.robot.commands.PickUpCmd;
import frc.robot.commands.ShooterCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PickUpSubsystem;
// import frc.robot.subsystems.FeederSubsystem;
// import frc.robot.subsystems.PickUpSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_DriveSubsystem = new DriveSubsystem();
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();
  private final PickUpSubsystem m_PickUpSubsystem = new PickUpSubsystem();

  //private final ShooterCmd m_shootCommand = new ShooterCmd()

  private final Joystick joystick1 = new Joystick(0);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    m_DriveSubsystem.setDefaultCommand(
      new ArcadeDriveCmd(m_DriveSubsystem, () -> -joystick1.getRawAxis(1),() -> joystick1.getRawAxis(4))
    );
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(joystick1,3).whileActiveOnce(new ShooterCmd(m_ShooterSubsystem,0.802,0.898));
    new JoystickButton(joystick1, 4).whileActiveOnce(new PickUpCmd(m_PickUpSubsystem, .8));
  }
    
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new SequentialCommandGroup(
      //Remember to add back that driveReverseCmd
      new AutoShooterCmd(m_DriveSubsystem, m_ShooterSubsystem)
    );  
    
  }
}
