import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.utility.Delay;

/**
 * Created by Dummyc0m on 5/21/16.
 */
public class MagicArm {
    private NXTRegulatedMotor motor;
    private int magic = 90;

    public MagicArm(NXTRegulatedMotor motor) {
        motor.setSpeed(360);
        this.motor = motor;
    }

    public void doMagic() {
        motor.rotate(magic);
    }

    public void reverseMagic() {
        motor.rotate(-magic);
    }

    public void repeatMagic(int times) {
        for(int i = 0; i < times; i++) {
            doMagic();
            Delay.msDelay(400L);
            reverseMagic();
            Delay.msDelay(400L);
        }
    }
}
