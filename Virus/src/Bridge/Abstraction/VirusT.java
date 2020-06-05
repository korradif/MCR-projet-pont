package Bridge.Abstraction;

import Bridge.Implementation.Behaviour.*;
import jdk.jshell.spi.ExecutionControl;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class VirusT  extends Rectangle implements IVirus  {
    public Behaviour behaviourImplementation;


    @Override
    public void setBehaviour(Behaviour behaviour) {
        behaviourImplementation = behaviour;
    }

    @Override
    public Behaviour getBehaviour() {
        return behaviourImplementation;
    }

    @Override
    public void kill(){

    }
}
