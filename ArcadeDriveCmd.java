package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.ArcadeDriveCmd;


public class ArcadeDriveCmd extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final Supplier<Double> speedFunction, turnFunction;
    
    public ArcadeDriveCmd(DriveSubsystem driveSubsystem, Supplier<Double> speedFunction,
     Supplier<Double> turnFunction){
        this.speedFunction = speedFunction;
        this.turnFunction = turnFunction;
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
    }
    @Override
  public void initialize() {
    System.out.println("ArcadeDriveCmd is active");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();

    double left = realTimeSpeed + realTimeTurn;
    double right = realTimeSpeed - realTimeTurn;
    driveSubsystem.setMotors(left, right);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
