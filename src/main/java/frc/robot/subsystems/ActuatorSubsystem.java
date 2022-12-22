// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.commands.ActuatorStop;

public class ActuatorSubsystem extends SubsystemBase {
  WPI_TalonSRX m_actuator = new WPI_TalonSRX(Constants.actuatorMotor);  
  private double current_speed = 0;

  /** Creates a new ActuatorSubsystem. */
  public ActuatorSubsystem() {
    setDefaultCommand(new ActuatorStop(this));
  }

  public void setActuator( double speed ) {
    m_actuator.set(ControlMode.PercentOutput, -speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      m_actuator.set(current_speed);
  }

  public void ActuatorStop() {
    m_actuator.set(0);
  }

  public void ActuatorUp() {
    m_actuator.set(0.2);
  }

  public void ActuatorDown() {
    m_actuator.set(-0.2);
  }
}
