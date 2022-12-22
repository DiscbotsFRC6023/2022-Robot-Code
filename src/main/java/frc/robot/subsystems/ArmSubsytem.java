// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.commands.ArmStop;

public class ArmSubsytem extends SubsystemBase {
  WPI_TalonSRX m_extension = new WPI_TalonSRX(Constants.armMotor);
  private double current_speed = 0;

  /** Creates a new ArmSubsytem. */
  public ArmSubsytem() {
    setDefaultCommand(new ArmStop(this));
  }

  public void extend(double speed) {
      m_extension.set(ControlMode.PercentOutput, -speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
      m_extension.set(current_speed);
  }

  public void ArmStop() {
    m_extension.set(0);
  }

  public void ArmForward() {
    m_extension.set(0.2);
  }

  public void ArmBackward() {
    m_extension.set(-0.2);
  }
}
