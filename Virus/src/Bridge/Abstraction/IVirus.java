package Bridge.Abstraction;


import Bridge.Implementation.Behaviour.eBehaviourType;

import java.awt.*;

public interface IVirus extends Shape{
    void setBehaviour(eBehaviourType behaviourType);
    eBehaviourType getBehaviour();
}
