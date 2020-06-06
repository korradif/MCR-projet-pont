package BusinessLogic;

import Bridge.Abstraction.IVirus;
import Bridge.Implementation.Behaviour.*;

import java.util.ArrayList;
import java.util.List;

public class VirusLogic {

  public void mutateVirus(IVirus virus){

       if(virus.getBehaviourType().isLastValue()){
           virus.kill();
       }else{
           switchBheaviour(virus);
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
