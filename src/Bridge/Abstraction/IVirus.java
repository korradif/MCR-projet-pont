package Bridge.Abstraction;


import java.awt.Color;

import Bridge.Implementation.Behaviour.IBehaviour;
import Bridge.Implementation.Behaviour.EBehaviourType;
import app.Bouncable;
import render.Renderable;

public interface IVirus extends Bouncable {
    void setBehaviour(IBehaviour behaviour);
    IBehaviour getBehaviour();
    EBehaviourType getBehaviourType();
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
}
