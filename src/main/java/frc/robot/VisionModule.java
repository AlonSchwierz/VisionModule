package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionModule {
    private static NetworkTableInstance inst = NetworkTableInstance.getDefault();
    private static NetworkTable table = inst.getTable("CV");
    private static NetworkTableEntry Distance = table.getEntry("distance");
    private static NetworkTableEntry Pitch = table.getEntry("pitch");
    private static NetworkTableEntry Yaw = table.getEntry("yaw");

    public static double getDistance() {
        return Distance.getDouble(0);
    }

    public static double getYaw() {
        return Yaw.getDouble(0);
    }

    public static double getPitch() {
        return Pitch.getDouble(0);
    }

    /**
     * @param cameraPitch the pitch of the camera in degrees.
     * @return the horizontal distance to the target
     */
    public static double getX(double cameraPitch) {
        return Math.cos(Math.toRadians(cameraPitch - getPitch())) * getDistance();
    }

}
