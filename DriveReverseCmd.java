package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;


public class DriveReverseCmd extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private int count;
    
    public DriveReverseCmd(DriveSubsystem driveSubsystem){
        count = 0;
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
    driveSubsystem.setMotors(-0.2, -0.2);    
    count++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.setMotors(0, 0);  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(count > 50){
        return true;
    }
    return false;
  }
}