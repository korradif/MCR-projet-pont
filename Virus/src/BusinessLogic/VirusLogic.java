//package BusinessLogic;
//
//import Bridge.Abstraction.IVirus;
//import Bridge.Implementation.Behaviour.Behaviour;
//import Bridge.Implementation.Behaviour.BehaviourLvlOne;
//import Bridge.Implementation.Behaviour.BehaviourLvlThree;
//import Bridge.Implementation.Behaviour.BehaviourLvlTwo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class VirusLogic {
//
//    //jamais test !!!!
//    private final List<Class> LEVEL_BEHAVIOUR_ORDER_LIST = List.of(BehaviourLvlOne.class, BehaviourLvlTwo.class, BehaviourLvlThree.class);
//
//    void mutateVirus(IVirus virus){
//        var virusBehaviour = virus.getBehaviour().getClass();
//        if(isLastVirusLevel(virusBehaviour)){
//            virus.kill();
//        }else{
//            //virus.setBehaviour(getNextVirusLevel(virusBehaviour).);
//            virus.setBehaviour(createNewVirus(getNextVirusLevel(virusBehaviour)));
//        }
//
//
//
//
//    }
//
//    boolean isLastVirusLevel(Class virusBehaviour){
//        return LEVEL_BEHAVIOUR_ORDER_LIST.get(LEVEL_BEHAVIOUR_ORDER_LIST.size()-1) == virusBehaviour.getClass();
//    }
//
//    Class getNextVirusLevel(Class virusBehaviour){
//        return LEVEL_BEHAVIOUR_ORDER_LIST.get(LEVEL_BEHAVIOUR_ORDER_LIST.indexOf(virusBehaviour.getClass()) + 1);
//    }
//
//Behaviour createNewVirus(Class virusBehaviour){
//
//    switch(virusBehaviour.toString()){
//        case BehaviourLvlOne.class.toString():
//            return new  BehaviourLvlOne();
//        case BehaviourLvlTwo.class:
//            return new BehaviourLvlTwo();
//        case BehaviourLvlThree.class:
//            return new BehaviourLvlThree();
//    }
//
//}
//
//
//}
//