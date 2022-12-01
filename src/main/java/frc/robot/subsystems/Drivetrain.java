// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.sensors.RomiGyro;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  // Instance of the drivetrain
  private static Drivetrain instance;

  // The motors that drive the wheels
  private final Spark leftMotor;
  private final Spark rightMotor;

  // Differential drive object that handles the math for driving the robot
  private final DifferentialDrive diffDrive;

  // Sensors
  private final Encoder leftEncoder;
  private final Encoder rightEncoder;
  private final RomiGyro gyro;
  private final BuiltInAccelerometer accel;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // Creates the motors
    leftMotor = new Spark(0);
    rightMotor = new Spark(1);

    // Inverts the right motor
    rightMotor.setInverted(true);

    // Creates the differential drive object
    diffDrive = new DifferentialDrive(leftMotor, rightMotor);

    // Sensors are created
    leftEncoder = new Encoder(4, 5);
    rightEncoder = new Encoder(6, 7);
    gyro = new RomiGyro();
    accel = new BuiltInAccelerometer();

    // Use inches as unit for encoder distances
    leftEncoder.setDistancePerPulse((Math.PI * Constants.COUNTS_PER_REV) / Constants.WHEEL_DIAMETER_INCH);
    rightEncoder.setDistancePerPulse((Math.PI * Constants.COUNTS_PER_REV) / Constants.WHEEL_DIAMETER_INCH);

    // Resets the encoders and gyro
    resetEncoders();
    resetGyro();
  }

  /**
   * Returns the instance of the drivetrain.
   * 
   * @return The drivetrain instance
   */
  public static Drivetrain getInstance() {
    if (instance == null) {
      instance = new Drivetrain();
    }
    return instance;
  }

  /**
   * Drives the robot using arcade controls.
   * @param xaxisSpeed The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
   * @param zaxisRotate The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is positive.
   */
  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }

  /**
   * Resets the drive encoders to currently read a position of 0.
   */
  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  /**
   * Gets the distance driven by the left side of the robot.
   * @return The distance driven (in counts).
   */
  public int getLeftEncoderCount() {
    return leftEncoder.get();
  }

  /**
   * Gets the distance driven by the right side of the robot.
   * @return The distance driven (in counts).
   */
  public int getRightEncoderCount() {
    return rightEncoder.get();
  }

  /**
   * Gets the distance driven by the left side of the robot.
   * @return The distance driven (in inches).
   */
  public double getLeftDistanceInch() {
    return leftEncoder.getDistance();
  }

  /**
   * Gets the distance driven by the right side of the robot.
   * @return The distance driven (in inches).
   */
  public double getRightDistanceInch() {
    return rightEncoder.getDistance();
  }

  /**
   * Gets the distance driven by the average of the left and right sides of the robot.
   * @return The distance driven (in inches).
   */
  public double getAverageDistanceInch() {
    return (getLeftDistanceInch() + getRightDistanceInch()) / 2.0;
  }

  /**
   * The acceleration in the X-axis.
   *
   * @return The acceleration of the Romi along the X-axis in Gs
   */
  public double getAccelX() {
    return accel.getX();
  }

  /**
   * The acceleration in the Y-axis.
   *
   * @return The acceleration of the Romi along the Y-axis in Gs
   */
  public double getAccelY() {
    return accel.getY();
  }

  /**
   * The acceleration in the Z-axis.
   *
   * @return The acceleration of the Romi along the Z-axis in Gs
   */
  public double getAccelZ() {
    return accel.getZ();
  }

  /**
   * Current angle of the Romi around the X-axis.
   *
   * @return The current angle of the Romi in degrees
   */
  public double getGyroAngleX() {
    return gyro.getAngleX();
  }

  /**
   * Current angle of the Romi around the Y-axis.
   *
   * @return The current angle of the Romi in degrees
   */
  public double getGyroAngleY() {
    return gyro.getAngleY();
  }

  /**
   * Current angle of the Romi around the Z-axis.
   *
   * @return The current angle of the Romi in degrees
   */
  public double getGyroAngleZ() {
    return gyro.getAngleZ();
  }

  /** Reset the gyro to angle 0. */
  public void resetGyro() {
    gyro.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
