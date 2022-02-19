package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class AutoShooterCmd extends CommandBase {
    private final ShooterSubsystem shooterSubsystem;
    private final DriveSubsystem driveSubsystem;
    private int timer1;
    private int timer2;

    public AutoShooterCmd(DriveSubsystem driveSubsystem, ShooterSubsystem shooterSubsystem){
        timer1 = 0;
        timer2 = 0;
        this.driveSubsystem = driveSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
        addRequirements(driveSubsystem);
    }

    @Override
  public void initialize() {
    System.out.println("AutoShooterCmd is active");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer1 < 200){ 
        driveSubsystem.setMotors(-0.2, -0.2); 
        System.out.println("hitting");
    }
    else if(timer1 >= 50){ 
        System.out.println("Hit");
        driveSubsystem.setMotors(0,0);
        shooterSubsystem.setMotors(0.802, 0.898);
        timer2++;
    }
    timer1++;
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.setMotors(0, 0);
    driveSubsystem.setMotors(0,0);
  }

      // Returns true when the command should end.
  @Override
    public boolean isFinished() {
        if(timer2 > 50){
            return true;
        }
        return false;
      }
}