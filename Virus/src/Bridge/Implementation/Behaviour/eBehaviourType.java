package Bridge.Implementation.Behaviour;

public enum eBehaviourType {
    //Objets directement construits
    BEHAVIOUR_LVL_1("BehaviourLvlOne"),
    BEHAVIOUR_LVL_2 ("BehaviourLvlTwo"),
    BEHAVIOUR_LVL_3("BehaviourLvlThree");

    private String _bheaviourType = "";

    //Constructeur
    eBehaviourType(String bheaviourType){
        _bheaviourType = bheaviourType;
    }


    public String toString(){
        return _bheaviourType;
    }

}