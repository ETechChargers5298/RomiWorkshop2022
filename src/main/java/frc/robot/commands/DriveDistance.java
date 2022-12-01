// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistance extends CommandBase {
  private final Drivetrain drive;

  private final double speed;
  private final double distance;

  /**
   * SECTION [3]: The subsystem only focuses on talking to the hardware. Lets create a command that will take inches and drive the robot to that distance.
   * The first thing is to figure out what we need for the command to work, what do we want to input. We write the inputs in DriveDistance(type input1, type input2, ...).
   * We mostly want everything in decimal values for now so we write double <input>. Currently there is one input, the speed but we need another input, can you guess what it is?
   */

  public DriveDistance(double speed) {
  /** !SECTION */

  /** SECTION [4]: We need to make sure that all the input is saved so we can use it everywhere in this file. We have stored the speed, can you store your input as well? */
    this.speed = speed;
    this.distance = 0;
  /** !SECTION */
    drive = Drivetrain.getInstance();
    
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    /** SECTION [5]: There are four parts to a command. The first part is code that should run at the start, the code that will repeatly run, 
     * the code that should run when the command is over, and the code that decides when the command is over. This section holds code that
     * runs at the start of the command. Here we want to prepare everything. This is done for you where it resets the motor and resets the 
     * sensor to read 0 again. */
    drive.arcadeDrive(0, 0);
    drive.resetEncoders();
    /** !SECTION */
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /** SECTION [6]: This is the section where code runs repeadly. Can you move the robot forward with the speed given. */

    /** !SECTION */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    /** SECTION [7]: This is code that runs when the command ends. We want to reset the motors for safety here. */

    /** !SECTION */
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /** SECTION [8]: This is the section that decides when our command to stop running. When the statement after return is true, The command stops.
     * Currently we are getting the absolute value of the left distance in inches and are saying that if it is less than or equal to the distance of 0, we want to stop.
     * This is not what we want. We want to stop when the average of both the wheels distance is greater than or equal to the distance we want to travel because it means
     * we went past the distance we wanted. Can you update the statement to do that?
     */
    return Math.abs(drive.getLeftDistanceInch()) <= 0;
    /** !SECTION */
  }
}
