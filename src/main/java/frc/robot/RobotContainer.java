// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.SpinMeRightAround;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // SECTION[epic=Step9]: GAMEPAD CREATE
  /* NOTE: We need to make every controller that we are going to use in code. Usually during competition we use two controllers.
  One is made for you, can you make the other one. The one made for you is plugged in at port 1. Can you create one
  that is plugged in at port 0.
  */
  private final XboxController controllerOne = new XboxController(1);

  // !SECTION

  // SECTION[epic=Step10]: CONNECTING CONTROLLER TO TANK DRIVE COMMAND
  /* NOTE: We need to connect the controller we created to the command. The one for tank drive is made below but the issue
   * is only the joystick for the left one is correct. Fix the one for the right one. We want to use left joystick y axis for the left
   * and right joystick y axis for the right.
  */
  private TankDrive tankDriveCommand = new TankDrive(() -> controllerOne.getLeftY());

  // !SECTION

  // SECTION[epic=Step15] ARCADE DRIVE COMMAND
  /* NOTE: Follow the way we created tankDriveCommand to create an arcade drive command and then proceed to use the left y for
   * speed and right x for rotational speed. Use your own controller that you made for this.
   */

  // !SECTION

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // SECTION[epic=Step16] DEFAULT COMMAND
    /* NOTE: You need to make any command you always want running to be a default command. To create a default command you write the code below
     * and replace the command with the name of the command you want to be running all the time. Change this to your arcade drive command.
     */
    Drivetrain.getInstance().setDefaultCommand(tankDriveCommand);


    //!SECTION
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new SpinMeRightAround();
  }
}
