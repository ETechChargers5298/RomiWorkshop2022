// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
  // We put all the subsystems we are going to use here
  private final Drivetrain drivetrain;

  // We put all the fields we need for this command here
  private final Supplier<Double> leftSpeed;
  private final Supplier<Double> rightSpeed;

  /** Creates a new TankDrive. */
  public TankDrive(Supplier<Double> leftSpeed, Supplier<Double> rightSpeed) {
    // This is how to get all the subsystems
    this.drivetrain = Drivetrain.getInstance();

    // We store our speed suppliers here
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Start the motors at zero
    drivetrain.tankDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Update the motors at each iteration using the suppliers
    drivetrain.arcadeDrive(leftSpeed.get(), rightSpeed.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // End by stopping the motors again
    drivetrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Never finishes
    return false;
  }
}
