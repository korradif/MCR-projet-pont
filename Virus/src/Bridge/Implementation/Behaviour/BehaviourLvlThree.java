package Bridge.Implementation.Behaviour;

import Bridge.Abstraction.IVirus;
import app.Displayer;
import app.DisplayerManager;

import java.util.Random;

public class BehaviourLvlThree extends  Behaviour {
    private Random rnd;
    private int frameCounter;

    public BehaviourLvlThree(IVirus virus) {
        super(virus);
        frameCounter = 40;
        rnd = new Random();
    }

    @Override
    public void move() {
        Displayer displayer = DisplayerManager.getInstance();
        if(frameCounter <= 0) {
            _virus.setX(rnd.nextInt(displayer.getWidth()-_virus.getSize()));
            _virus.setY(rnd.nextInt(displayer.getHeight() - _virus.getSize()));
            frameCounter = 20;
        }else{
            --frameCounter;
        }
    }

    @Override
    public void LaunchCapacities() {

    }
}
