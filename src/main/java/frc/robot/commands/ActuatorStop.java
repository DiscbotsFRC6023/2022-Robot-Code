// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ActuatorSubsystem;

public class ActuatorStop extends CommandBase {
  ActuatorSubsystem m_actuator;

  /** Creates a new ActuatorStop. */
  public ActuatorStop(ActuatorSubsystem param_actuator) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_actuator = param_actuator;
    addRequirements(m_actuator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_actuator.ActuatorStop();
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
