/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 *
 * @author Connor
 */
public class CIMPult extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    Talon cim1 = new Talon(4);
    Talon cim2 = new Talon(8);
    AnalogPotentiometer ana = new AnalogPotentiometer(2);
    
    double speed = 0.0;
    double minVolt = 0.4;
    double maxVolt = 2.3;
    double minAngle = 5.0;
    double maxAngle = 120.0;
    double launch_speed = 1.0;
    double launch_volt;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double degToVolt(float d) {
        if (d <= minAngle)
            return minVolt;
        else if (d >= maxAngle)
            return maxVolt;
        else
            return ((d-minAngle)/(maxAngle-minAngle))*(maxVolt-minVolt);
    }
    
    void launch(double angle, double speed) {
        launch_volt = angle;
        launch_speed = speed;
    }
}
