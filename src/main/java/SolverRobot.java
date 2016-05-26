import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

/**
 * Created by Dummyc0m on 5/21/16.
 */
public class SolverRobot {
    public static void main(String... args) throws Exception {
        new SolverRobot().run();
    }

    private MagicArm arm = new MagicArm(new NXTRegulatedMotor(MotorPort.C));
    private NXTRegulatedMotor motorA = new NXTRegulatedMotor(MotorPort.A);
    private MagicHolder holder = new MagicHolder(motorA);

    private void run() {
        resetHolder();
        Cube cube = new Cube(arm, holder);
        cube.apply(new Operation(CubeFace.RIGHT, 2));
    }

    private void resetHolder() {
        motorA.setSpeed(50);
        motorA.forward();
        while (!motorA.isStalled());
        motorA.flt();
        Delay.msDelay(1000L);
    }
}
