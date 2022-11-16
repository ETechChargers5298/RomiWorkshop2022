// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

// SECTION[epic=Step14]: ARCADE DRIVE COMMAND
/* NOTE: Create your own command for arcade drive here. Use the tank drive as reference but instead of using drivetrain.tankDrive,
you will be using drivetrain.arcadeDrive. The first step is to setup all your variables that you will for your whole file. This means
adding lines for the input under private final Drivetrain drivetrain; Then you want to get the input in the parenthesis of the constructor.
Then write all your setup code. After that is done, make sure you make sure the robot isn't moving at the start and at the end. In execute,
drive using controller input. */
public class ArcadeDrive extends CommandBase {

  private final Drivetrain drivetrain;

  public ArcadeDrive() {
    this.drivetrain = Drivetrain.getInstance();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  // !SECTION
}
