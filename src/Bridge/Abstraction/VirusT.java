/**
 * @name: VirusT.java
 * @work: MCR-Pont
 * @authors: Guillaume Zaretti, Alexandre Simik, Frédéric Korradi, Simon Flückiger
 * @date: 06.06.2020
 */
package Bridge.Abstraction;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;

import render.RenderableFull;
public class VirusT extends Virus {
    /**
     * @brief constructeur
     * @param color la couleur
     */
    public VirusT(Color color) { super(color, new RenderableFull()); }

    @Override
    public Shape getShape() {
        return new Rectangle.Double(getX(), getY(), getSize(), getSize());
    }
}