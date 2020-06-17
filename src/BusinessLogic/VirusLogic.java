package BusinessLogic;

import Bridge.Abstraction.IVirus;
import Bridge.Implementation.Behaviour.*;

import java.util.ArrayList;
import java.util.List;

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
        // TODO Ici on peut appeler ce qu'on veut en fonction de la position.
        if (virus.getShape().contains(x, y)) {
            System.out.println("Touché !");
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
