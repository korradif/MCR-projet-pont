package Bridge;

import Bridge.Implementation.Behaviour.eBehaviourType;

public class Main {
    public static void main(String[] args){
        eBehaviourType behaviourType = eBehaviourType.BEHAVIOUR_LVL_1;
        System.out.println(behaviourType);
        System.out.println(behaviourType.isLastValue());
        behaviourType = behaviourType.getNext();
        System.out.println(behaviourType);
        System.out.println(behaviourType.isLastValue());
       behaviourType =  behaviourType.getNext();
        System.out.println(behaviourType);
        System.out.println(behaviourType.isLastValue());
       behaviourType =  behaviourType.getNext();
        System.out.println(behaviourType);
        System.out.println(behaviourType.isLastValue());
        behaviourType = behaviourType.getNext();
        System.out.println(behaviourType);
        System.out.println(behaviourType.isLastValue());
        behaviourType =  behaviourType.getNext();
        System.out.println(behaviourType);
        System.out.println(behaviourType.isLastValue());
        behaviourType =  behaviourType.getNext();
        System.out.println(behaviourType);
        System.out.println(behaviourType.isLastValue());



    }
}
