// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private static Drivetrain instance;

  // SECTION[epic=Step1]: CREATING A MOTOR
  /* NOTE: This creates the left motor.
  To create a motor in code you write...
  private final <type of motor> <name of motor> = new <type of motor>(<where it is wired>).
  Make the right motor in this section. */
  private final Spark leftMotor = new Spark(0);


  // !SECTION

  // SECTION[epic=Step13]: CREATING A DIFFERENTIAL DRIVE
  /* NOTE: There are objects we can create that have tools we can use. One is differential drive which is useful because
  it has built in methods to do complicated things like arcade drive. To make Differential Drive work, you need to give it the
  left motor and the right motor in the parenthesis. The code below is almost right, can you fix it to use the rightMotor as well. */
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotor, leftMotor);

  // !SECTION


  /** NOTE: This is the constructor, It is where you write all you setup code for this mechanism (Drivetrain) */
  private Drivetrain() {
    // SECTION[epic=Step12]: INVERTING MOTOR
    /* NOTE: To drive forward correctly, one motor always needs to be inverted because they are reflections of each other.
     * Set the right motor's inversion to true.
    */
    leftMotor.setInverted(false);

    // !SECTION
  }

  // SECTION[epic=Step2]: FINISHING TANK DRIVE

  /* NOTE: To give the robot behavior, we need to create methods here to tell the mechanism what to do.
   * The one below is the method to let the drivetrain use tankDrive. This means if we move the left joystick
   * it will move the left wheel and if we move the right joystick it will move the right wheel.
   * You write public void <name of method>(<things you are asking for separated by commas>) {Code Inside Curly Braces}.
   * Set the speed of the right motor correctly.
   */
    public void tankDrive(double leftSpeed, double rightSpeed) {
      // This drives the left motor using leftSpeed
      leftMotor.set(leftSpeed);


    }

    // !SECTION

    // SECTION[epic=Step13]: CREATE ARCADE DRIVE
    /* NOTE: Arcade drive is where the driver can use one joystick to move forward and backwards. They can use a second joystick
    to run the robot around. Can you create a brand new method like the one for tankDrive that takes in linearSpeed and rotationSpeed
    and uses the function diffDrive.arcadeDrive(linearSpeed, rotationSpeed) to drive the robot using arcade drive.   
    */


    // !SECTION
    

  public static Drivetrain getInstance() {
    if(instance == null) {
      return new Drivetrain();
    }
    return instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
