package factory;

import Bridge.Abstraction.IVirus;
import Bridge.Abstraction.VirusG;
import Bridge.Abstraction.VirusT;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class VirusFactory {
    private static final Color VIRUS_T_COLOR = Color.red;
    private static final Color VIRUS_G_COLOR = Color.blue;

    public IVirus createVirusT(){
        return new VirusT(VIRUS_T_COLOR);
    }

    public IVirus createVirusG(){
        return new VirusG(VIRUS_G_COLOR);
    }

}
