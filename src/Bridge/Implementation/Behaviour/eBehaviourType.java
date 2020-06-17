package Bridge.Implementation.Behaviour;

import Bridge.Abstraction.IVirus;

public enum eBehaviourType {
    //Objets directement construits
    BEHAVIOUR_LVL_1( BehaviourLvlOne.class),
    BEHAVIOUR_LVL_2 ( BehaviourLvlTwo.class),
    BEHAVIOUR_LVL_3( BehaviourLvlThree.class);

    private Class _bheaviourType;

    public eBehaviourType getNext() {
        return this.ordinal() < eBehaviourType.values().length - 1
                ? eBehaviourType.values()[this.ordinal() + 1]
                : eBehaviourType.values()[0];
    }

    public boolean isLastValue(){
        return this.ordinal() == eBehaviourType.values().length - 1;
    }

    //Constructeur
    eBehaviourType(Class bheaviourType){
        _bheaviourType = bheaviourType;
    }

    public String toString(){
        return _bheaviourType.toString();
    }

    public static eBehaviourType getBehaviourTypeFormInstance(IVirus virus){
        String behaviour = virus.getBehaviour().getClass().toString();
        if(behaviour.equals(BehaviourLvlOne.class.toString())){
            return BEHAVIOUR_LVL_1;
        }else if (behaviour.equals(BehaviourLvlTwo.class.toString())){
            return BEHAVIOUR_LVL_2;
        }else if (behaviour.equals(BehaviourLvlThree.class.toString())){
            return  BEHAVIOUR_LVL_3;
        }
        return null;
    }
}