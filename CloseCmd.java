package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClutchSubsystem;


public class CloseCmd extends CommandBase
{
    private ClutchSubsystem clutchSubsystem;
    private final double MaxOpen = 0.05;
    private final double kp=0.7;
    private double error;

    public CloseCmd(ClutchSubsystem clutchSubsystem)
    {
        this.clutchSubsystem=clutchSubsystem;
        addRequirements(clutchSubsystem);    
    }

    public void execute() 
    {
        double RPosition = clutchSubsystem.EncoderMeters();
        error=MaxOpen-RPosition;
        clutchSubsystem.setClutchMotor(kp*error);        
    }
}
