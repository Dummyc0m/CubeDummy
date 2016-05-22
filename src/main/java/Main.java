import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

/**
 * Created by Dummyc0m on 5/21/16.
 */
public class Main {
    public static void main(String... args) throws Exception {
        new Main().run();
    }

    private void run() {
        NXTRegulatedMotor motorA = new NXTRegulatedMotor(MotorPort.A);
        motorA.setSpeed(50);
        motorA.forward();
        while (!motorA.isStalled());
        motorA.flt();
        Delay.msDelay(200L);
        MagicArm arm = new MagicArm(new NXTRegulatedMotor(MotorPort.C));
        MagicHolder holder = new MagicHolder(motorA);
        Cube cube = new Cube(arm, holder);
//        arm.repeatMagic(1);
//        Delay.msDelay(1000L);
//        holder.rotateMagic(2);
        cube.apply(new Operation(CubeFace.RIGHT, 1));
    }
}
