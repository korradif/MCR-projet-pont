package Bridge.Abstraction;


import Bridge.Implementation.Behaviour.Behaviour;
import jdk.jshell.spi.ExecutionControl;


import java.awt.*;

public interface IVirus extends Shape{
    void setBehaviour(Behaviour behaviour);
    Behaviour getBehaviour();
    void kill();
}
