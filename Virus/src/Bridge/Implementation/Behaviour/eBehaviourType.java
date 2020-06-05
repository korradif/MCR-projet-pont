package Bridge.Implementation.Behaviour;

public enum eBehaviourType {
    //Objets directement construits
    BEHAVIOUR_LVL_1("BehaviourLvlOne"),
    BEHAVIOUR_LVL_2 ("BehaviourLvlTwo"),
    BEHAVIOUR_LVL_3("BehaviourLvlThree");

    private String _bheaviourType = "";

    public eBehaviourType getNext() {
        return this.ordinal() < eBehaviourType.values().length - 1
                ? eBehaviourType.values()[this.ordinal() + 1]
                : eBehaviourType.values()[0];
    }

    public boolean isLastValue(){
        return this.ordinal() == eBehaviourType.values().length - 1;
    }

    //Constructeur
    eBehaviourType(String bheaviourType){
        _bheaviourType = bheaviourType;
    }


    public String toString(){
        return _bheaviourType;
    }

}