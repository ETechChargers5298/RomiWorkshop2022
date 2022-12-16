// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.sensors.RomiGyro;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  // The only instance of drivetrain
  private static Drivetrain instance;

  // Motors
  private final Spark leftMotor;
  private final Spark rightMotor;

  // Drivetrain tools
  private final DifferentialDrive diffDrive;

  // Sensors
  private final Encoder leftEncoder;
  private final Encoder rightEncoder;
  private final RomiGyro gyro;
  private final BuiltInAccelerometer accel;

  /** Creates a new Drivetrain. */
  private Drivetrain() {
    // Setups the motors
    leftMotor = new Spark(Ports.LEFT_MOTOR_PORT);
    rightMotor = new Spark(Ports.RIGHT_MOTOR_PORT);

    // Inverts the motors
    leftMotor.setInverted(!Constants.WHEELS_INVERTED);
    rightMotor.setInverted(Constants.WHEELS_INVERTED);

    // Sets up the differential drive object
    diffDrive = new DifferentialDrive(leftMotor, rightMotor);

    // Sets up encoders
    leftEncoder = new Encoder(Ports.ENCODER_LEFT_A, Ports.ENCODER_LEFT_B);
    rightEncoder = new Encoder(Ports.ENCODER_RIGHT_A, Ports.ENCODER_RIGHT_B);

    // Use inches as unit for encoder distances
    leftEncoder.setDistancePerPulse((Math.PI * Constants.WHEEL_DIAMETER_INCH) / Constants.COUNTS_PER_REV);
    rightEncoder.setDistancePerPulse((Math.PI * Constants.WHEEL_DIAMETER_INCH) / Constants.COUNTS_PER_REV);

    // Sets the encoders
    resetEncoders();

    // Setups gyro and accelometers
    gyro = new RomiGyro();
    accel = new BuiltInAccelerometer();

    // Reset gyro
    resetGyro();
  }

  /** Provides the drivetrain */
  public static Drivetrain getInstance() {
    if (instance == null) {
      instance = new Drivetrain();
    }
    return instance;
  }

  /** Drives using tank drive
   * @param leftSpeed the speed of the left wheels (-1 to 1)
   * @param rightSpeed the speed of the right wheels (-1 to 1)
   */
  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  /** Drives using arcade drive
   * @param xaxisSpeed the linear speed (-1 to 1)
   * @param zaxisRotate the angular speed (-1 to 1)
   */
  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }

  /** Resets the encoders to zero */
  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  /** Gets the raw value from the left encoders */
  public int getLeftEncoderCount() {
    return leftEncoder.get();
  }

  /** Gets the raw value from the right encoders */
  public int getRightEncoderCount() {
    return rightEncoder.get();
  }

  /** Gets the left wheel distance travelled in inches calculated using the encoders */
  public double getLeftDistanceInch() {
    return leftEncoder.getDistance();
  }

  /** Gets the right wheel distance travelled in inches calculated using the encoders */
  public double getRightDistanceInch() {
    return rightEncoder.getDistance();
  }

  /** Gets the average distance travelled by both wheels in inches */
  public double getAverageDistanceInch() {
    return (getLeftDistanceInch() + getRightDistanceInch()) / 2.0;
  }

  /**
   * The acceleration in the X-axis.
   * @return The acceleration of the Romi along the X-axis in Gs
   */
  public double getAccelX() {
    return accel.getX();
  }

  /**
   * The acceleration in the Y-axis.
   * @return The acceleration of the Romi along the Y-axis in Gs
   */
  public double getAccelY() {
    return accel.getY();
  }

  /**
   * The acceleration in the Z-axis.
   * @return The acceleration of the Romi along the Z-axis in Gs
   */
  public double getAccelZ() {
    return accel.getZ();
  }

  /**
   * Current angle of the Romi around the X-axis.
   * @return The current angle of the Romi in degrees
   */
  public double getGyroAngleX() {
    return gyro.getAngleX();
  }

  /**
   * Current angle of the Romi around the Y-axis.
   * @return The current angle of the Romi in degrees
   */
  public double getGyroAngleY() {
    return gyro.getAngleY();
  }

  /**
   * Current angle of the Romi around the Z-axis.
   * @return The current angle of the Romi in degrees
   */
  public double getGyroAngleZ() {
    return gyro.getAngleZ();
  }

  /** Reset the gyro. */
  public void resetGyro() {
    gyro.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
