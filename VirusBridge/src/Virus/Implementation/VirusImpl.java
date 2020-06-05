package Virus.Implementation;

import Virus.Abstraction.IVirus;
import Virus.Abstraction.VirusLvlOne;
import Virus.Abstraction.VirusLvlTwo;
import Virus.VirusType;

public class VirusImpl implements IVirus{
    IVirus virusImplementation;

    public VirusImpl(VirusType virusType){
        switch (virusType){
            case VIRUS_LVL_1:
                this.virusImplementation = new VirusLvlOne();
                break;
            case VIRUS_LVL_2:
                this.virusImplementation = new VirusLvlTwo();
                break;
            default:
                throw new IllegalArgumentException("Invalid implementation ! ");
        }
    }

    public void mutaite(){

    }


    @Override
    public int get_x() {
        return virusImplementation.get_x();
    }

    @Override
    public void set_x(int x) {
        virusImplementation.set_x(x);
    }

    @Override
    public int get_y() {
        return virusImplementation.get_y();
    }

    @Override
    public void set_y(int y) {
        virusImplementation.set_y(y);
    }

    @Override
    public int get_speed() {
        return virusImplementation.get_speed();
    }

    @Override
    public void set_speed(int speed) {
        virusImplementation.set_speed(speed);
    }

    @Override
    public int get_size() {
        return virusImplementation.get_size();
    }

    @Override
    public void set_size(int size) {
        virusImplementation.set_size(size);
    }
}
