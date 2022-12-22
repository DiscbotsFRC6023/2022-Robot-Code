// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsytem;

public class ArmStop extends CommandBase {
  ArmSubsytem m_arm;
  /** Creates a new ArmStop. */
  public ArmStop(ArmSubsytem param_ArmSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_arm = param_ArmSubsystem;
    addRequirements(m_arm);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_arm.ArmStop();
  }

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
}
