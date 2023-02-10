package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClutchSubsystem;


public class CloseCmd extends CommandBase
{
    private ClutchSubsystem clutchSubsystem;
    private final double MaxOpen = 0.05;

    public CloseCmd(ClutchSubsystem clutchSubsystem)
    {
        this.clutchSubsystem=clutchSubsystem;
        addRequirements(clutchSubsystem);    
    }

    public void execute() 
    {
        double RPosition = clutchSubsystem.EncoderMeters();
        if(RPosition>-MaxOpen)
        {
            clutchSubsystem.setClutchMotor(-1);
        }
        else
        {
            clutchSubsystem.setClutchMotor(0);
        }
    }
}
