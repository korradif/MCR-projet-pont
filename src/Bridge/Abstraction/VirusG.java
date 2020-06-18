/**
 * @name: VirusG.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti, Alexandre Simik, Frédéric Korradi, Simon Flückiger
 * @date: 06.06.2020
 */
package Bridge.Abstraction;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import render.RenderableFull;

public class VirusG extends Virus {
    /**
     * @brief constructeur
     * @param color la couleur de la forme
     */
    public VirusG(Color color) { super(color,  new RenderableFull()); }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getX(), getY(), getSize(), getSize());
    }


}
