package Bridge.Abstraction;


import Bridge.Implementation.Behaviour.Behaviour;
import Bridge.Implementation.Behaviour.IBehaviour;
import Bridge.Implementation.Behaviour.eBehaviourType;
import app.Bouncable;
import jdk.jshell.spi.ExecutionControl;
import render.Renderable;


import java.awt.*;

public interface IVirus extends Bouncable {
    void setBehaviour(IBehaviour behaviour);
    IBehaviour getBehaviour();
    eBehaviourType getBehaviourType();
    void kill();

    void draw();
    Renderable getRenderer();
    Color getColor();
    void launchBehaviour();
    int getX();
    void setX(int x);
    int getY();
    void setY(int y);

    int getVX();
    void setVX(int vx);
    int getVY();
    void setVY(int vy);
    boolean isDead();
    int getSize();
    void setSize(int size);

    void reactToMouseEvent(double x, double y);
}
