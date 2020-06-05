import java.awt.*;

public class Main {

    public static void main(String args[]){
        //type class ou énum
        ITime sict = new TimeImpl(10 , 30,"SimpleCivilianTime");
        ITime dff = new TimeImpl(10,40);
        ITime dnf = new TimeImpl();

        ITime syct = new TimeImpl(10,50, "SyncronizedCivilTime");

        ITime simt = new TimeImpl(10, 50, "SimpleMilitaryTime");
        ITime symt = new TimeImpl(10, 50, "SyncronizedMilitaryTime");

        System.out.println();
        sict.tell();
        sict.tellHrs();
        sict.tellMin();
        System.out.println();
        dff.tell();
        dff.tellHrs();
        dff.tellMin();
        System.out.println();
        dnf.tell();
        dnf.tellHrs();
        dnf.tellMin();
        System.out.println();
        syct.tell();
        syct.tellHrs();
        syct.tellMin();
        System.out.println();
        simt.tell();
        simt.tellHrs();
        simt.tellMin();
        System.out.println();
        symt.tell();
        symt.tellHrs();
        symt.tellMin();

        System.out.println("test");
    }
}
