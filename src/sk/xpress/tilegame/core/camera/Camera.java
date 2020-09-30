package sk.xpress.tilegame.core.camera;

import sk.xpress.tilegame.core.utils.Cord;

public class Camera implements ICamera {

    private Cord.Double cameraPos;

    public Camera() {
        cameraPos = new Cord.Double<>(0,0);
    }

    @Override
    public double getCameraPositionX() {
        cameraPosIsNull();
        return cameraPos.getX();
    }

    @Override
    public double getCameraPositionY() {
        cameraPosIsNull();
        return cameraPos.getY();
    }

    @Override
    public Cord.Double getCameraPosition() {
        cameraPosIsNull();
        return cameraPos;
    }

    @Override
    public void setCameraPosition(Cord.Double cameraPosition) {
        cameraPosIsNull();
        this.cameraPos = cameraPosition;
    }

    @Override
    public void moveCamera(double x, double y) {
        cameraPosIsNull();
        double newX = (cameraPos.getX()+x);
        double newY = (cameraPos.getY()+y);

        cameraPos.setX(newX);
        cameraPos.setY(newY);
    }

    private void cameraPosIsNull() {
        if(cameraPos == null)
            cameraPos = new Cord.Double<>(1000,1000);
    }

    @Override
    public String toString() {
        return "Camera{" +
                "cameraPos=" + cameraPos +
                '}';
    }
}
