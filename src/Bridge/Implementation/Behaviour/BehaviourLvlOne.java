/**
 * @name: BehaviourLvlOne.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti, Alexandre Simik, Frédéric Korradi, Simon Flückiger
 * @date: 06.06.2020
 */

package Bridge.Implementation.Behaviour;

import Bridge.Abstraction.IVirus;
import app.Displayer;
import app.DisplayerManager;

public class BehaviourLvlOne extends Behaviour{
    public BehaviourLvlOne(IVirus virus) {
        super(virus);
    }

    @Override
    public void move() {
        Displayer displayer = DisplayerManager.getInstance();

        boolean lB = _virus.getX()+ _virus.getVX() < 0,
                rB = _virus.getX() +  _virus.getVX() + _virus.getSize() > displayer.getWidth(),
                tB = _virus.getY() + _virus.getVY() < 0,
                bB = _virus.getY() + _virus.getVY() + _virus.getSize() > displayer.getHeight();

        // rebond mur verticaux
        if(lB || rB) {
            _virus.setX(lB ? 0 : displayer.getWidth() - _virus.getSize());
            _virus.setVX(-_virus.getVX());
        }

        // rebond mur horizontaux
        if(tB || bB) {
            _virus.setY( tB ? 0 : displayer.getHeight() - _virus.getSize());
            _virus.setVY(- _virus.getVY());
        }

        _virus.setX(_virus.getX() + _virus.getVX());
        _virus.setY(_virus.getY() + _virus.getVY());

    }

    @Override
    public void LaunchCapacities() {

    }
}
