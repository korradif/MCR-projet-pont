/**
 * @name: Behaviour.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti, Alexandre Simik, Frédéric Korradi, Simon Flückiger
 * @date: 06.06.2020
 */
package Bridge.Implementation.Behaviour;

import Bridge.Abstraction.IVirus;

public abstract class Behaviour implements IBehaviour{
    IVirus _virus;

   public Behaviour(IVirus virus){
       _virus = virus;
   }
}
