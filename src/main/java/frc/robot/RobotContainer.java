// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.*;
import edu.wpi.first.cameraserver.CameraServer;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  DrivetrainSubsystem m_drive = new DrivetrainSubsystem();
  ActuatorSubsystem m_actuator = new ActuatorSubsystem();
  ArmSubsytem m_arm = new ArmSubsytem();

  // Controllers
  final Joystick stick1 = new Joystick(0);
  final XboxController controller1 = new XboxController(1);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
      CameraServer.startAutomaticCapture();
      configureButtonBindings();
      
      // Default Commands
      m_drive.setDefaultCommand(new RunCommand(() -> m_drive.drive(stick1.getY(), -stick1.getX()),m_drive));
      m_arm.setDefaultCommand(new ArmStop(m_arm));
      m_actuator.setDefaultCommand(new ActuatorStop(m_actuator));
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */

    private void configureButtonBindings() {
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

      // Arm Button Bindings 
      JoystickButton ArmForward = new JoystickButton(controller1, 1);
      JoystickButton ArmBackward = new JoystickButton(controller1, 4);

      // Actuator Button Bindings
      JoystickButton ActuatorUp = new JoystickButton(controller1, 6);
      JoystickButton ActuatorDown = new JoystickButton(controller1, 5);

      // Arm Triggers
      ArmForward.whileHeld(new ArmForward(m_arm));
      ArmBackward.whileHeld(new ArmBackward(m_arm));

      // Actuator Triggers
      ActuatorUp.whileHeld(new ActuatorUp(m_actuator));
      ActuatorDown.whileHeld(new ActuatorDown(m_actuator));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */

    public Command getAutonomousCommand() {
      // Autonomous that makes robot go backwards at half speed for x amounts of seconds 
      return new RunCommand(() -> m_drive.drive(0.5, 0), m_drive).withTimeout(2.1).andThen(new InstantCommand(m_drive::stop, m_drive));
    }
}
