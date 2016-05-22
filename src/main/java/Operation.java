/**
 * Created by Dummyc0m on 5/21/16.
 */
public class Operation {
    private CubeFace face;
    private int parameter;

    public Operation(CubeFace face, int parameter) {
        this.face = face;
        this.parameter = parameter;
    }

    public CubeFace getFace() {
        return face;
    }

    public void setFace(CubeFace face) {
        this.face = face;
    }

    public int getParameter() {
        return parameter;
    }

    public void setParameter(int parameter) {
        this.parameter = parameter;
    }
}
