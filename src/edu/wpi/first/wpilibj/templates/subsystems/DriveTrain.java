/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Connor
 */
public class DriveTrain extends Subsystem {
    Talon frontLeft;
    Talon frontRight;
    Talon rearLeft;
    Talon rearRight;
    
    RobotDrive driveTrain = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    
    public DriveTrain() {
        driveTrain.setSafetyEnabled(false);
        frontLeft = new Talon(RobotMap.frontLeftMotor);
        frontRight = new Talon(RobotMap.frontRightMotor);
        rearLeft = new Talon(RobotMap.rearLeftMotor);
        rearRight = new Talon(RobotMap.rearRightMotor);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new JoystickDrive());
    }
    
    public void mecanumDrive(double x, double y, double z) {
        driveTrain.mecanumDrive_Cartesian(x, y, z, 0);
    }
}
