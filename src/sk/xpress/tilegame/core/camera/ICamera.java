package sk.xpress.tilegame.core.camera;

import sk.xpress.tilegame.core.utils.Cord;

public interface ICamera {

    double getCameraPositionX();
    double getCameraPositionY();

    Cord.Double getCameraPosition();
    void setCameraPosition(Cord.Double cameraPosition);
    void moveCamera(double x, double y);

}
