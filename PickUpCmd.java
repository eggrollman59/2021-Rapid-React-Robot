package frc.robot.commands;

import frc.robot.subsystems.PickUpSubsystem;

import frc.robot.commands.PickUpCmd;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class PickUpCmd extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
private final PickUpSubsystem pickupSubsystem;
private final double speed;

//private final Joystick m_stickOne = new Joystick(0);

  /**
   * Creates a new ExampleCommand.  
   *
   * @param subsystem The subsystem used by this command.
   */
  public PickUpCmd(PickUpSubsystem subsystem, double motorSpeed) {
    pickupSubsystem = subsystem;
    speed = motorSpeed;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      System.out.println("PickUpCmd Started!");
      
    }
    
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    pickupSubsystem.setMotor(speed); 
    pickupSubsystem.deployFoward();
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    pickupSubsystem.retract();
    pickupSubsystem.end();
  }

        
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}