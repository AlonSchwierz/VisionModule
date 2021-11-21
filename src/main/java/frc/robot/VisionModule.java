package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

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

    /**
     *
     * @param target is target
     * @return x2 is the x coordinats of the robot
     * @return y2 is the y coordinats of the robot
     */
    public static Pose2d getPose(Pose2d target, double cameraPitch) {
        double x2 = target.getTranslation().getX();
        double y2 = target.getTranslation().getY();
        return new Pose2d(
                x2 - getX(cameraPitch) * Math.cos(Math.toRadians(90 - getYaw())),
                y2 - getX(cameraPitch) * Math.sin(Math.toRadians(90 - getYaw())),
                new Rotation2d(Math.toRadians(getYaw()))
        );
    }
}
