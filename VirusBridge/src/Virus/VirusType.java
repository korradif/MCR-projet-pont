package Virus;

public enum VirusType {
    //Objets directement construits
    VIRUS_LVL_1("VirusLvlOne"),
    VIRUS_LVL_2 ("VirusLvlTwo");

    private String _virusType = "";

    //Constructeur
    VirusType(String virusType){
       _virusType = virusType;
    }


    public String toString(){
        return _virusType;
    }

}