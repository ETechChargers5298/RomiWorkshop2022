// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnDegrees extends CommandBase {
  private final Drivetrain drive;

  private final double degrees;
  private final double speed;

  /** SECTION [10]: Its Time to build our second command. The ideas are similar to the last command so you can use the code as reference. 
   * Can you first gather all the inputs you will need to turn to an angle. Hint there are two inputs.
   */
  public TurnDegrees() {
  /** !SECTION */

    /** SECTION [11]: Before we do anything, we need to gather all our subsystems because there will be commands that will use many mechanisms at once. 
     * For this command, we only need the drivetrain. Refer to the DriveDistance command to see how to get the drivetrain.
     */
    drive = null;
    /** !SECTION */

    /** SECTION [12]: We need to gather all our inputs for our command like we did in the DriveDistance command. Update both the inputs here.
     */
    degrees = 0;
    speed = 0;
    /** !SECTION */

    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    /** SECTION [13]: The first thing we want to do is to reset our sensor here so that we measure our angles correctly later. 
     * Can you reset the gyro here and stop the motors as well> The gyro is what we will use to get our angle. */

    /** !SECTION */
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /** SECTION [14]: This is the section where code runs repeadly. Can you move the robot to TURN with the speed given. */

    /** !SECTION */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    /** SECTION [15]: This is code that runs when the command ends. We want to reset the motors for safety here. */

    /** !SECTION */
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /** SECTION [16]: Please replace false with the statement we want to use to decide if the command is over. We say the command is over when
     * the absolute value of the gyro x value is greater than the degrees we want to turn. 
     */
    return false;
    /** !SECTION */
  }
}
