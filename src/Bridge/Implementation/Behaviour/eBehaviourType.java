/**
 * @name: EBehaviourType.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti, Alexandre Simik, Frédéric Korradi, Simon Flückiger
 * @date: 06.06.2020
 */

package Bridge.Implementation.Behaviour;

import Bridge.Abstraction.IVirus;

public enum EBehaviourType {
    //Objets directement construits
    BEHAVIOUR_LVL_1( BehaviourLvlOne.class),
    BEHAVIOUR_LVL_2 ( BehaviourLvlTwo.class),
    BEHAVIOUR_LVL_3( BehaviourLvlThree.class);

    private Class _bheaviourType;

    public EBehaviourType getNext() {
        return this.ordinal() < EBehaviourType.values().length - 1
                ? EBehaviourType.values()[this.ordinal() + 1]
                : EBehaviourType.values()[0];
    }

    public boolean isLastValue(){
        return this.ordinal() == EBehaviourType.values().length - 1;
    }

    //Constructeur
    EBehaviourType(Class bheaviourType){
        _bheaviourType = bheaviourType;
    }

    public String toString(){
        return _bheaviourType.toString();
    }

    public static EBehaviourType getBehaviourTypeFormInstance(IVirus virus){
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