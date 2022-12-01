// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;

import frc.robot.commands.DriveTime;
import frc.robot.commands.TurnTime;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoTime extends SequentialCommandGroup {
  public AutoTime() {
    /** SECTION [1]: Our robot is broken up into two sections. Subsystems and Commands. The subsystem is focused on connecting the hardware with code and giving it basic functionality.
     * Commands are where we use the subsystems often together to create a specific behavior or action. For example, the subsystem for drivetrain will have code to move the robot and
     * we can use that to create a command that moves the robot forward. For our competition, one important thing we do is code autonomous which is where the robot moves on its own.
     * We achieve this by using commands together to create a sequence of actions. Below is an example of a command group and each command runs in order. All the commands are listed
     * in the addCommands() and are seperated by commas. There are two commands currently built. One is DriveTime which you give the speed first and the time second to drive forward. 
     * The second is TurnTime which you give the speed first and the time second to turn. You can drive the autonomously by chaining these two commands together.
     * 
     * WRITE A SEQUENCE OF COMMANDS TO DRIVE THE ROBOT THROUGH A SECTION OF THE MAZE
    */
    addCommands(
      new DriveTime(-0.6, 2.0),
      new TurnTime(-0.5, 1.3),
      new DriveTime(-0.6, 2.0),
      new TurnTime(0.5, 1.3)
    );
    /** !SECTION */
  }
}