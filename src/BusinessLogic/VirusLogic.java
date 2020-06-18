/**
 * @name: VirusLogic.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti, Alexandre Simik, Frédéric Korradi, Simon Flückiger
 * @date: 06.06.2020
 */

package BusinessLogic;

import Bridge.Abstraction.IVirus;
import Bridge.Implementation.Behaviour.BehaviourLvlOne;
import Bridge.Implementation.Behaviour.BehaviourLvlThree;
import Bridge.Implementation.Behaviour.BehaviourLvlTwo;

public class VirusLogic {
//returns if the virus is dead or not.
  public void mutateVirus(IVirus virus){

       if(virus.getBehaviourType().isLastValue()){
           virus.kill();
       }else{
           switchBheaviour(virus);
       }
   }


    public void reactToMouseEvent(double x, double y, IVirus virus) {
        if (virus.getShape().contains(x, y)) {
            // System.out.println("Touché !");
            mutateVirus(virus);
        }
    }
private void switchBheaviour(IVirus virus){
    switch (virus.getBehaviourType().getNext()){
        case BEHAVIOUR_LVL_1:
            virus.setBehaviour(new BehaviourLvlOne(virus));
            break;
        case BEHAVIOUR_LVL_2:
            virus.setBehaviour(new BehaviourLvlTwo(virus));
            break;
        case BEHAVIOUR_LVL_3:
            virus.setBehaviour(new BehaviourLvlThree(virus));
            break;
    }

}


}
