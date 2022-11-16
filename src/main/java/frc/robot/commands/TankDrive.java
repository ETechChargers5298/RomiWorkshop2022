// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {

  // SECTION[epic=Step3]: CREATING A FIELD
  /* NOTE: Everything created here can be used anywhere in the file, so we need to make sure
   * to create everything important here. For tankdrive, we need drivetrain (the mechanism),
   * the input from the controllers for the leftWheel and rightWheel respectively. Make the
   * input for the right wheel here.
   */
  private final Drivetrain drivetrain;
  private final DoubleSupplier leftWheelInput;

  // !SECTION

  // SECTION[epic=Step4]: CREATING SETUP CODE
  /* NOTE: All your setup code for a command goes here. For tank drive it means getting controller input and saving it.
   * The left controller input is done for you, please do the right controller input.
   */

  /** Creates a new TankDrive. */
  public TankDrive(DoubleSupplier leftInput) {
    this.drivetrain = Drivetrain.getInstance();
    this.leftWheelInput = leftInput;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // !SECTION


  // SECTION[epic=Step5]
  /* NOTE: This is the first thing that runs in a command. We want to set the motors to 0. Use the method you created in Drivetrain.java
  called tankDrive() and set both motor speeds to 0. Place this in the curly braces.
  */
  @Override
  public void initialize() {
    // drivetrain.<method name>(<inputs>)
  }
  // !SECTION

  // SECTION[epic=Step6]
  /* NOTE: This is the code that will run repeatedly until the command ends. Set the motor speeds to what ever our input is.
   * The one for the left motor is done for you.
   */
  @Override
  public void execute() {
    drivetrain.tankDrive(leftWheelInput.getAsDouble(), 0);
  }

  // !SECTION

  // SECTION[epic=Step7]
  /* NOTE: This is the code that will run at the end of the command. Lets set the speed of the robot back to zero in here. */
  @Override
  public void end(boolean interrupted) {

  }
  // !SECTION

  // SECTION[epic=Step8]
  /*NOTE: This is where you write code to decide when the command is finished. Returning false means it will never be finished.
  This works for us because we always want to be driving. You don't have to do anything here.
  */
  @Override
  public boolean isFinished() {
    return false;
  }
  // !SECTION
}
