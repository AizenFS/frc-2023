package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClutchSubsystem;
//import edu.wpi.first.math.controller.PIDController;

public class OpenCmd extends CommandBase {

    private ClutchSubsystem clutchSubsystem;
    private final double MaxOpen = 0.05;
    private final double kp=0.7;
    private double error;

    public OpenCmd(ClutchSubsystem clutchSubsystem)
    {
        this.clutchSubsystem=clutchSubsystem;
        addRequirements(clutchSubsystem);    
    }

    public void execute() 
    {
        double OPosition = clutchSubsystem.EncoderMeters();
        error=MaxOpen-OPosition;
        clutchSubsystem.setClutchMotor(kp*error);
    }
    
}
