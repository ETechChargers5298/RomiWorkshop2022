// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/*
 * Creates a new TurnTime command. This command will turn your robot for a
 * desired rotational speed and time.
 */
public class TurnTime extends CommandBase {
  private final double duration;
  private final double rotationalSpeed;
  private final Drivetrain drive;
  private long startTime;

  /**
   * Creates a new TurnTime.
   *
   * @param speed The speed which the robot will turn. Negative is in reverse.
   * @param time How much time to turn in seconds
   * @param drive The drive subsystem on which this command will run
   */
  public TurnTime(double speed, double time) {
    this.rotationalSpeed = speed;
    this.duration = time * 1000;
    
    drive = Drivetrain.getInstance();

    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
    drive.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.arcadeDrive(0, rotationalSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - startTime) >= duration;
  }
}
