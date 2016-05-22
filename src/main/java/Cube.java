import lejos.utility.Delay;

/**
 * Created by Dummyc0m on 5/21/16.
 */
public class Cube {
    //private int roll;
    private int yaw;
    private int pitch;

    private MagicArm arm;
    private MagicHolder holder;

    public Cube(MagicArm arm, MagicHolder holder) {
        this.arm = arm;
        this.holder = holder;
    }

    public void transform(Operation operation) {
        CubeFace face = operation.getFace();
        //.nextRoll(roll)
        face = face.nextPitch(pitch).nextYaw(yaw);
        operation.setFace(face);
    }

    public void apply(Operation operation) {
        switch (operation.getFace()) {
            case UP:
                pitch = (pitch + 2) % 4;
                arm.repeatMagic(2);
                break;
            case LEFT:
                yaw = (yaw + 1) % 4;
                pitch = (pitch + 3) % 4;
                holder.rotateMagic(1);
                arm.repeatMagic(1);
                break;
            case RIGHT:
                yaw = (yaw + 3) % 4;
                pitch = (pitch + 3) % 4;
                holder.rotateMagic(3);
                arm.repeatMagic(1);
                break;
            case FRONT:
                yaw = (yaw + 2) % 4;
                pitch = (pitch + 1) % 4;
                holder.rotateMagic(2);
                arm.repeatMagic(1);
                break;
            case BACK:
                pitch = (pitch + 3) % 4;
                arm.repeatMagic(1);
                break;
        }
        arm.doMagic();
        Delay.msDelay(200L);
        holder.rotateMagic(operation.getParameter());
        Delay.msDelay(200L);
        arm.reverseMagic();
    }
}
