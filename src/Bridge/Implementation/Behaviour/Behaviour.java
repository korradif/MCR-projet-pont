package Bridge.Implementation.Behaviour;

import Bridge.Abstraction.IVirus;

public abstract class Behaviour implements IBehaviour{
    IVirus _virus;

   public Behaviour(IVirus virus){
       _virus = virus;
   }
}
