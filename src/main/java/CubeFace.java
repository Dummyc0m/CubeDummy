/**
 * Created by Dummyc0m on 5/21/16.
 */
public enum CubeFace {
    UP(0, -1, 0),
    DOWN(2, -1, 2),
    FRONT(-1, 0, 1),
    BACK(-1, 2, 3),
    LEFT(3, 1, -1),
    RIGHT(1, 3, -1);

//    private static CubeFace[] rollFaces = {UP, RIGHT, DOWN, LEFT};

    private static CubeFace[] yawFaces = {FRONT, LEFT, BACK, RIGHT};

    private static CubeFace[] pitchFaces = {UP, FRONT, DOWN, BACK};

    //remove
    private final int rollIndex;

    private final int yawIndex;

    private final int pitchIndex;

    CubeFace(int rollIndex, int yawIndex, int pitchIndex) {
        this.rollIndex = rollIndex;
        this.yawIndex = yawIndex;
        this.pitchIndex = pitchIndex;
    }

//    public CubeFace nextRoll(int next) {
//        if(rollIndex == -1) {
//            return this;
//        }
//        return rollFaces[(rollIndex + next) % 4];
//    }

    public CubeFace nextYaw(int next) {
        if(rollIndex == -1) {
            return this;
        }
        return yawFaces[(yawIndex + next) % 4];
    }

    public CubeFace nextPitch(int next) {
        if(rollIndex == -1) {
            return this;
        }
        return pitchFaces[(pitchIndex + next) % 4];
    }
}
