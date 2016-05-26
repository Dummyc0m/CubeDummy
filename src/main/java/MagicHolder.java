import lejos.hardware.motor.NXTRegulatedMotor;

/**
 * Created by Dummyc0m on 5/21/16.
 */
public class MagicHolder {
    private NXTRegulatedMotor motor;
    private int currentPos;

    public MagicHolder(NXTRegulatedMotor motor) {
        motor.setSpeed(150);
        this.motor = motor;
    }

    public void rotateMagic(int times) {
        int oldPos = currentPos;
        currentPos = (currentPos + times) % 4;
        motor.rotate(-(currentPos - oldPos) * 90);
    }
}
