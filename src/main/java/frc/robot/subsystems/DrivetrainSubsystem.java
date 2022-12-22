// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//Imports
  package frc.robot.subsystems;
  import edu.wpi.first.wpilibj2.command.SubsystemBase;
  import frc.robot.Constants;
  import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
  import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
  import edu.wpi.first.wpilibj2.command.Command;
  import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */

  //Left Motors
    WPI_TalonFX LD1 = new WPI_TalonFX(Constants.LD1);
    WPI_TalonFX LD2 = new WPI_TalonFX(Constants.LD2);
    WPI_TalonFX LD3 = new WPI_TalonFX(Constants.LD3);
  
  //Right Motors
    WPI_TalonFX RD1 = new WPI_TalonFX(Constants.RD1);
    WPI_TalonFX RD2 = new WPI_TalonFX(Constants.RD2);
    WPI_TalonFX RD3 = new WPI_TalonFX(Constants.RD3);

  //Motor Controller Groups
    MotorControllerGroup leftControllerGroup = new MotorControllerGroup(LD1, LD2, LD3);
    MotorControllerGroup rightControllerGroup = new MotorControllerGroup(RD1, RD2, RD3);

  //Drive
    DifferentialDrive m_drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);



  public DrivetrainSubsystem() {
    this.leftControllerGroup.setInverted(true);
  }


  public void drive(double Speed, double Rotation){
    m_drive.arcadeDrive(Speed, Rotation);
  }


  public void stop(){
    m_drive.arcadeDrive(0, 0);
  }


  public void setDefaultCommand(Command defaultCommand){
    super.setDefaultCommand(defaultCommand);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
