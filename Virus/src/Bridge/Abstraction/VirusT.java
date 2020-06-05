package Bridge.Abstraction;

import Bridge.Implementation.Behaviour.Behaviour;
import Bridge.Implementation.Behaviour.eBehaviourType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class VirusT  extends Rectangle implements IVirus  {
    Behaviour behaviourImplementation;

    @Override
    public void setBehaviour(eBehaviourType behaviourType) {

    }

    @Override
    public eBehaviourType getBehaviour() {
        return null;
    }
}
