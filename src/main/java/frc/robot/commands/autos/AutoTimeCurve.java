// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveTime;
import frc.robot.commands.TurnTime;

public class AutoTimeCurve extends SequentialCommandGroup {
  public AutoTimeCurve() {
    addCommands(
      new DriveTime(-0.6, 2.0),
      new TurnTime(-0.5, 1.3),
      new DriveTime(-0.6, 2.0),
      new TurnTime(0.5, 1.3)
    );
  }
}
