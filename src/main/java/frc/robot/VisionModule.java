package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionModule {
    private static NetworkTableInstance inst = NetworkTableInstance.getDefault();
    private static NetworkTable table = inst.getTable("datatable");
    private static NetworkTableEntry Pitch;
    private static NetworkTableEntry Yaw;
    private static NetworkTableEntry Distance = table.getEntry("distance");


    public static double position() {
        Pitch = table.getEntry("X");
        Yaw = table.getEntry("Y");
    }
    public static double getDistance(){
        return Distance.getDouble(0);
    }
    public static double getYaw(){
        return Yaw
    }
    public static double getPitch(){
        return Pitch
    }
        return Pitch

}
