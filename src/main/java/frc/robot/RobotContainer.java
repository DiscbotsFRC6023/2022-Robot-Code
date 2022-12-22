// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//Subsystem Imports
import frc.robot.subsystems.ActuatorSubsystem;
import frc.robot.subsystems.ArmSubsytem;
import frc.robot.subsystems.DrivetrainSubsystem;

//Command Imports
import frc.robot.commands.ArmForward;
import frc.robot.commands.ArmStop;
import frc.robot.commands.ArmBackward;
import frc.robot.commands.ActuatorUp;
import frc.robot.commands.ActuatorDown;
import frc.robot.commands.ActuatorStop;





/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {

/* Create subsystems, joysticks, and etc. here*/

//Subsystems
DrivetrainSubsystem m_drive = new DrivetrainSubsystem();
ActuatorSubsystem m_actuator = new ActuatorSubsystem();
ArmSubsytem m_arm = new ArmSubsytem();

//Joysticks
final Joystick stick1 = new Joystick(0);
final XboxController controller1 = new XboxController(1);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    CameraServer.startAutomaticCapture();
    
    // Configure the button bindings
    configureButtonBindings();
    
    //Default Commands
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

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.



/*JoystickButton ArmForward = new JoystickButton(x, y);
x determines the controller
y determines which button from x
*/

//For Launchpad Controls use Launchpad and buttons 1 through 16
//Note: each launchpad registers a max of 16 buttons each one should be mapped into config file named midicontroller following the path C:\Users\*\Destop\midi2vjoy-master\midi2vjoy


//Arm Button Bindings (Xbox) 
//JoystickButton ArmForward = new JoystickButton(controller1, 1);
//JoystickButton ArmBackward = new JoystickButton(controller1, 4);

//Arm Button Bindings (Launchpad)
JoystickButton ArmForward = new JoystickButton(Launchpad, 1);
JoystickButton ArmBackward = new JoystickButton(Launchpad, 9);


//Actuator Button Bindings (Xbox)
//JoystickButton ActuatorUp = new JoystickButton(controller1, 6);
//JoystickButton ActuatorDown = new JoystickButton(controller1, 5);

//Arm Button Bindings (Launchpad)
JoystickButton ActuatorUp = new JoystickButton(Launchpad, 2);
JoystickButton ActuatorDown = new JoystickButton(Launchpad, 10);





  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  
//Arm Triggers
ArmForward.whileHeld(new ArmForward(m_arm));
ArmBackward.whileHeld(new ArmBackward(m_arm));

//Actuator Triggers
ActuatorUp.whileHeld(new ActuatorUp(m_actuator));
ActuatorDown.whileHeld(new ActuatorDown(m_actuator));



  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

  // Autonomous Commands
  /* Autonomous that makes robot go backwards at half speed for x amounts of seconds */
  return new RunCommand(() -> m_drive.drive(0.5, 0), m_drive).withTimeout(2.1).andThen(new InstantCommand(m_drive::stop, m_drive));
  

  }
}
